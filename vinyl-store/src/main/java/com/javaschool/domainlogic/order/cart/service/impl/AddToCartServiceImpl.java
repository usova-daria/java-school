package com.javaschool.domainlogic.order.cart.service.impl;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.dto.CartItem;
import com.javaschool.domainlogic.order.cart.response.dto.NumberOfItemsResponse;
import com.javaschool.domainlogic.order.cart.response.factory.AddItemResponseFactory;
import com.javaschool.domainlogic.order.cart.service.api.AddToCartService;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j
@Service
public class AddToCartServiceImpl extends CartServiceImpl implements AddToCartService {

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<NumberOfItemsResponse> addItemToCart(Long productId, Cart cart) {
        return addItemToCart(productId, 1, cart);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<NumberOfItemsResponse> addItemToCart(Long productId, int quantity, Cart cart) {
        if (cart == null || cart.getItems() == null || productId == null || quantity < 1) {
            return AddItemResponseFactory.getIllegalArgumentResponse();
        }

        boolean deleted = productService.getDeletedById(productId);
        if (deleted) {
            return AddItemResponseFactory.getDeletedResponse();
        }

        int unitsInStore = productService.getUnitsInStoreById(productId);
        if (unitsInStore == 0) {
            return AddItemResponseFactory.getNotAvailableResponse();
        }

        CartItem cartItem = getCartItemByProductOrAddNew(productId, cart);
        int required = cartItem.getQuantity() + quantity;
        int newQuantity = Math.min(required, unitsInStore);

        setNewQuantity(newQuantity, cartItem, cart);

        return AddItemResponseFactory.getResponseByRequired(required, newQuantity, cart.getTotal());
    }

    private CartItem getCartItemByProductOrAddNew(Long productId, Cart cart) {
        CartItem cartItem = getCartItemByProductIdOrNull(productId, cart);
        if (cartItem != null) {
            return cartItem;
        }

        cartItem = new CartItem(productId, 0);
        cart.getItems().add(cartItem);

        return cartItem;
    }


}
