package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.cart.dto.CartItem;
import com.javaschool.entity.order.OrderItem;

import java.util.List;

public interface OrderItemMapper {

    OrderItem toEntity(CartItem cartItem);

    List<OrderItem> toEntityList(List<CartItem> cartItems);

}
