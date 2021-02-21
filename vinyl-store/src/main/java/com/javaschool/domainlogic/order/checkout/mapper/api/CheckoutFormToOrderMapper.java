package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;
import com.javaschool.entity.order.Order;

public interface CheckoutFormToOrderMapper {

    Order toEntity(CheckoutFormDto checkoutFormDto, Cart cart);

}
