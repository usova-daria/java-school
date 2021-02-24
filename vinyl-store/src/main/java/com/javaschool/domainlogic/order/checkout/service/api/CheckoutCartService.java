package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutCart;

/**
 * @author Daria Usova
 */
public interface CheckoutCartService {

    /**
     * Gets checkout cart.
     *
     * @param cart the cart
     * @return the checkout cart
     */
    CheckoutCart getCheckoutCart(Cart cart);

}
