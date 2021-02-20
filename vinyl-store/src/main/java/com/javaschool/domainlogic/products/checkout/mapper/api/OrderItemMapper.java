package com.javaschool.domainlogic.products.checkout.mapper.api;

import com.javaschool.domainlogic.products.cart.dto.CartItem;
import com.javaschool.entity.order.OrderItem;

import java.util.List;

public interface OrderItemMapper {

    OrderItem toEntity(CartItem cartItem);

    List<OrderItem> toEntityList(List<CartItem> cartItems);

}
