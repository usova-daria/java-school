package com.javaschool.domainlogic.order.checkout.mapper.impl;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.order.cart.dto.CartItem;
import com.javaschool.domainlogic.order.checkout.exception.OrderItemMappingException;
import com.javaschool.domainlogic.order.checkout.mapper.api.OrderItemMapper;
import com.javaschool.entity.order.OrderItem;
import com.javaschool.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderItem toEntity(CartItem cartItem) {
        if (cartItem == null) {
            throw new OrderItemMappingException("Cart item must not be null");
        };

        OrderItem orderItem = new OrderItem();
        orderItem.setAmount( cartItem.getQuantity() );

        Long productId = cartItem.getProductId();
        Product product = productRepository.findById( productId )
                .orElseThrow(() -> new OrderItemMappingException("There is no product with id=" +
                                                                    productId));

        orderItem.setProduct( product );
        orderItem.setPrice( product.getPrice() );

        return orderItem;
    }

    @Override
    public List<OrderItem> toEntityList(List<CartItem> cartItems) {
        if (cartItems == null) {
            throw new OrderItemMappingException("Cart item list must not be null");
        };

        return cartItems.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}
