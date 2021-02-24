package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.user.User;

/**
 * @author Daria Usova
 */
public interface SaveOrderService {

    /**
     * Saves order.
     *
     * @param order the order
     * @param user  the user
     * @return the order
     */
    Order saveOrder(Order order, User user);

    /**
     * Saves order.
     *
     * @param checkoutFormDto the checkout form dto
     * @param cart            the cart
     * @return the order
     */
    Order saveOrder(CheckoutFormDto checkoutFormDto, Cart cart);

}
