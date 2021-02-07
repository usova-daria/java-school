package com.javaschool.domainlogic.products.cart.service;

import com.javaschool.domainlogic.products.cart.dto.Cart;

import javax.servlet.http.HttpSession;

public interface CartService {

    void addItemToCartByProductId(Long id, HttpSession session);

    Cart getCart(HttpSession session);

    void removeItemFromCartByProductId(Long id, HttpSession session);

    Cart updateCart(HttpSession session);

    Cart updateCart(Cart cart);

    boolean cartIsEmpty(HttpSession session);

}
