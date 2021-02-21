package com.javaschool.domainlogic.products.cart.service.impl;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.dto.CartItem;
import com.javaschool.domainlogic.products.cart.response.dto.NumberOfItemsResponse;
import com.javaschool.domainlogic.products.cart.response.factory.ChangeNumberOfItemsFactory;
import com.javaschool.domainlogic.products.cart.service.api.ChangeNumberOfItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChangeNumberOfItemsServiceImpl extends CartServiceImpl implements ChangeNumberOfItemsService {

    @Override
    public ResponseEntity<NumberOfItemsResponse> updateNumberOfItemsInTheCart(Long productId,
                                                                              Integer requiredQuantity, Cart cart) {
        if (cart == null || cart.getItems() == null || productId == null || requiredQuantity < 1) {
            return ChangeNumberOfItemsFactory.getIllegalArgumentResponse();
        }

        CartItem cartItem = getCartItemByProductIdOrNull(productId, cart);
        if (cartItem == null) {
            return ChangeNumberOfItemsFactory.getNoSuchItemResponse();
        }

        int unitsInStore = productService.getUnitsInStoreById(productId);
        int newQuantity = Math.min(requiredQuantity, unitsInStore);

        setNewQuantity(newQuantity, cartItem, cart);
        return ChangeNumberOfItemsFactory.getResponseByRequired(requiredQuantity, newQuantity, cart.getTotal());
    }

}
