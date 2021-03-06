package com.javaschool.domainlogic.order.cart.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.dto.CartItem;

import java.util.HashMap;
import java.util.List;

public interface CartService {

    void updateTotal(Cart cart);

    CartItem getCartItemByProductIdOrNull(Long productId, Cart cart);

    List<Long> getProductIdList(Cart cart);

    void setNewQuantity(int newQuantity, CartItem cartItem, Cart cart);

    void removeItemFromCart(CartItem cartItem, Cart cart);

    HashMap<Long, Integer> getProductQuantityMap(Cart cart);

}
