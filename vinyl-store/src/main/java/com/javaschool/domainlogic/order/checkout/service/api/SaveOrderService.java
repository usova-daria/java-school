package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.user.User;

public interface SaveOrderService {

    Order saveOrder(Order order, User user);

    Order saveOrder(CheckoutFormDto checkoutFormDto, Cart cart);

}
