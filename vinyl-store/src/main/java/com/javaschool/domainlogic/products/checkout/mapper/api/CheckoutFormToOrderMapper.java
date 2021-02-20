package com.javaschool.domainlogic.products.checkout.mapper.api;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.checkout.dto.CheckoutFormDto;
import com.javaschool.entity.order.Order;

public interface CheckoutFormToOrderMapper {

    Order toEntity(CheckoutFormDto checkoutFormDto, Cart cart);

}
