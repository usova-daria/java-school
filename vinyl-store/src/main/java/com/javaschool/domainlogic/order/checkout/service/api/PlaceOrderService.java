package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;

/**
 * @author Daria Usova
 */
public interface PlaceOrderService {

    /**
     * Places order.
     *
     * @param checkoutFormDto the checkout form dto
     * @param cart            the cart
     */
    void placeOrder(CheckoutFormDto checkoutFormDto, Cart cart);

}
