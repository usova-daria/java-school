package com.javaschool.domainlogic.products.checkout.service.api;

import com.javaschool.domainlogic.products.checkout.dto.CheckoutFormDto;

import javax.servlet.http.HttpSession;
import java.security.Principal;

public interface PlaceOrderService {

    void placeOrder(CheckoutFormDto checkoutFormDto, HttpSession session);

}
