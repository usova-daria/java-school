package com.javaschool.domainlogic.products.cart.service.impl;

import com.javaschool.dao.impl.product.projection.ProductPriceProjection;
import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.dto.CartItem;
import com.javaschool.domainlogic.products.cart.service.api.CartService;
import com.javaschool.service.api.ProductService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    protected ProductService productService;

    @Override
    public CartItem getCartItemByProductIdOrNull(Long productId, Cart cart) {
        if (productId == null || cart.getItems() == null) {
            return null;
        }

        return cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public void updateTotal(Cart cart) {
        if (cart == null || cart.getItems() == null) {
            return;
        }

        List<Long> productIdList = getProductIdList(cart);
        List<ProductPriceProjection> priceList = productService.getPriceByProductId(productIdList);

        HashMap<Long, Float> priceMap = priceListToMap(priceList);

        double total = calcTotal(cart.getItems(), priceMap);
        cart.setTotal(total);
    }

    private double calcTotal(List<CartItem> cartItems, HashMap<Long, Float> priceMap) {
        double total = 0;
        for (CartItem cartItem :cartItems) {
            int quantity = cartItem.getQuantity();
            long id = cartItem.getProductId();

            float price = priceMap.getOrDefault(id, 0f);
            total = total + price * quantity;
        }

        return total;
    }

    private HashMap<Long, Float> priceListToMap(List<ProductPriceProjection> priceList) {
        HashMap<Long, Float> map = new HashMap<>();
        priceList.forEach(i -> map.put(i.getProductId(), i.getPrice()));

        return map;
    }

    @Override
    public List<Long> getProductIdList(Cart cart) {
        if (cart == null || cart.getItems() == null) {
            throw new IllegalArgumentException("Cart and cart items must not be null");
        }

        return cart.getItems()
                .stream()
                .map(CartItem::getProductId)
                .collect(Collectors.toList());
    }

    @Override
    public void setNewQuantity(int newQuantity, CartItem cartItem, Cart cart) {
        cartItem.setQuantity(newQuantity);
        updateTotal(cart);
    }

    @Override
    public void removeItemFromCart(CartItem cartItem, Cart cart) {
        if (cart == null || cartItem == null || cart.getItems() == null) {
            throw new IllegalArgumentException("Item to be removed, cart and cart items must not be null");
        }

        boolean itemIsRemoved = cart.getItems().remove( cartItem );
        if (itemIsRemoved) {
            updateTotal(cart);
        }
    }

    @Override
    public HashMap<Long, Integer> getProductQuantityMap(Cart cart) {
        List<CartItem> cartItems = cart.getItems();
        HashMap<Long, Integer> map = new HashMap<>();

        cartItems.forEach(ci -> map.put(ci.getProductId(), ci.getQuantity()));
        return map;
    }

}
