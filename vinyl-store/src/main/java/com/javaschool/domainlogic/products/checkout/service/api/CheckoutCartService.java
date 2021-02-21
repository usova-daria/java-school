package com.javaschool.domainlogic.products.checkout.service.api;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.checkout.dto.CheckoutCart;

public interface CheckoutCartService {

    CheckoutCart getCheckoutCart(Cart cart);

}
