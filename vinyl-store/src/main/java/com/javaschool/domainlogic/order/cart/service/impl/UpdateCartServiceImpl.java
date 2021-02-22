package com.javaschool.domainlogic.order.cart.service.impl;

import com.javaschool.dao.impl.product.projection.ProductUnitsInStoreProjection;
import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.dto.CartItem;
import com.javaschool.domainlogic.order.cart.service.api.UpdateCartService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j
@Service
public class UpdateCartServiceImpl extends CartServiceImpl implements UpdateCartService {

    @Override
    public boolean itemsAreAvailable(Cart cart) {
        List<ProductUnitsInStoreProjection> notAvailableItems = getNotAvailableItems(cart);
        return notAvailableItems.size() == 0;
    }

    @Override
    public Map<Long, Integer> updateCartItems(Cart cart) {
        List<ProductUnitsInStoreProjection> notAvailableItems = getNotAvailableItems(cart);
        updateCartItems(notAvailableItems, cart);

        return getNotAvailableQuantityMap(notAvailableItems);
    }

    private HashMap<Long, Integer> getNotAvailableQuantityMap(List<ProductUnitsInStoreProjection> notAvailableItems) {
        HashMap<Long, Integer> map = new HashMap<>();
        notAvailableItems.forEach(i -> map.put( i.getId(), i.getUnitsInStore() ) );

        return map;
    }

    private List<ProductUnitsInStoreProjection> getNotAvailableItems(Cart cart) {
        List<ProductUnitsInStoreProjection> unitsInStoreList = getUnitsInStoreList(cart);
        return getNotAvailableItems(unitsInStoreList, cart);
    }

    private List<ProductUnitsInStoreProjection> getUnitsInStoreList(Cart cart) {
        List<Long> productIdList = getProductIdList(cart);
        return productService.getUnitsInStoreByIdList(productIdList);
    }

    private List<ProductUnitsInStoreProjection> getNotAvailableItems(
            List<ProductUnitsInStoreProjection> allItems, Cart cart) {

        HashMap<Long, Integer> quantityMap = getProductQuantityMap(cart);
        return allItems.stream()
                .filter(i -> i.getUnitsInStore() < quantityMap.get(i.getId()))
                .collect(Collectors.toList());
    }

    private void updateCartItems(List<ProductUnitsInStoreProjection> notAvailableItems, Cart cart) {
        notAvailableItems.forEach(i -> {
            CartItem cartItem = getCartItemByProductIdOrNull(i.getId(), cart);

            int unitsInStore = i.getUnitsInStore();
            if (unitsInStore == 0) {
                removeItemFromCart(cartItem, cart);
            } else {
                cartItem.setQuantity(i.getUnitsInStore());
            }
        });

        updateTotal(cart);
    }

    @Override
    public void emptyCart(Cart cart) {
        cart.setItems( new ArrayList<>());
        cart.setTotal(0);
    }
}
