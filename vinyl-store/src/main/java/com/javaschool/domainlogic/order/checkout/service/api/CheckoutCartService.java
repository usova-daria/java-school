package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutCart;

public interface CheckoutCartService {

    CheckoutCart getCheckoutCart(Cart cart);

}
