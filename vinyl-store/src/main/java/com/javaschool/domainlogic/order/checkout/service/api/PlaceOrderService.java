package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;

public interface PlaceOrderService {

    void placeOrder(CheckoutFormDto checkoutFormDto, Cart cart);

}
