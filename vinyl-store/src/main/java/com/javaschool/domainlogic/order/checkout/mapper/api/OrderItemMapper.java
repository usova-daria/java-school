package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.cart.dto.CartItem;
import com.javaschool.entity.order.OrderItem;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface OrderItemMapper {

    /**
     * Maps cart item to order item.
     *
     * @param cartItem the cart item
     * @return the order item
     */
    OrderItem toEntity(CartItem cartItem);

    /**
     * Maps cart item list to order item list.
     *
     * @param cartItems the cart items
     * @return the list
     */
    List<OrderItem> toEntityList(List<CartItem> cartItems);

}
