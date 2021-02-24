package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;
import com.javaschool.entity.order.Order;

/**
 * @author Daria Usova
 */
public interface CheckoutFormToOrderMapper {

    /**
     * Maps checkoutFormDto and cart to order entity.
     *
     * @param checkoutFormDto the checkout form dto
     * @param cart            the cart
     * @return the order
     */
    Order toEntity(CheckoutFormDto checkoutFormDto, Cart cart);

}
