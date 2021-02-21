package com.javaschool.domainlogic.order.checkout.service.impl;

import com.javaschool.dao.impl.product.projection.ProductNamePriceProjection;
import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.service.api.UpdateCartService;
import com.javaschool.domainlogic.order.cart.service.impl.CartServiceImpl;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutCartItem;
import com.javaschool.domainlogic.order.checkout.service.api.CheckoutCartService;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutCart;
import com.javaschool.domainlogic.order.checkout.mapper.api.CheckoutCartItemMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
@Service
@AllArgsConstructor
public class CheckoutCartServiceImpl extends CartServiceImpl implements CheckoutCartService {

    private final CheckoutCartItemMapper cartItemMapper;
    private final UpdateCartService updateCartService;

    @Override
    public CheckoutCart getCheckoutCart(Cart cart) {
        List<CheckoutCartItem> items = getItems(cart);
        updateCartItems(items, cart);

        return new CheckoutCart(items, cart.getTotal());
    }

    private List<CheckoutCartItem> getItems(Cart cart) {
        List<Long> idList = getProductIdList(cart);
        List<ProductNamePriceProjection> products = productService.getNameAndPriceByIdList(idList);

        List<CheckoutCartItem> items = cartItemMapper.toDtoList(products);

        // set quantity
        HashMap<Long, Integer> productQuantityMap = getProductQuantityMap(cart);
        items.forEach(i -> i.setPrevQuantity( productQuantityMap.get(i.getId()) ) );
        return items;
    }

    private void updateCartItems(List<CheckoutCartItem> cartItems, Cart cart) {
        Map<Long, Integer> notAvailableProducts = updateCartService.updateCartItems(cart);

        cartItems.forEach(ci -> {
            Long productId = ci.getId();
            int newQuantity = notAvailableProducts.getOrDefault(productId, ci.getPrevQuantity());

            ci.setNewQuantity(newQuantity);
        });
    }

}
