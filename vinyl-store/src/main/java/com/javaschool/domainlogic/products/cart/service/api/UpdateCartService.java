package com.javaschool.domainlogic.products.cart.service.api;

import com.javaschool.domainlogic.products.cart.dto.Cart;

import java.util.Map;

public interface UpdateCartService {

    Map<Long, Integer> updateCartItems(Cart cart);

    boolean itemsAreAvailable(Cart cart);

    void emptyCart(Cart cart);

}
