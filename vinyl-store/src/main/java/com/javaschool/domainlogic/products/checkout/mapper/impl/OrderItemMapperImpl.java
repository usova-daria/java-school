package com.javaschool.domainlogic.products.checkout.mapper.impl;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.products.cart.dto.CartItem;
import com.javaschool.domainlogic.products.checkout.mapper.api.OrderItemMapper;
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
        if (cartItem == null) return null;

        OrderItem orderItem = new OrderItem();
        orderItem.setAmount( cartItem.getQuantity() );

        Long productId = cartItem.getProduct().getId();
        Product product = productRepository.findById( productId )
                .orElseThrow(() -> new IllegalArgumentException("An error occurred while mapping cartItem with id=" +
                        productId));

        orderItem.setProduct( product );
        orderItem.setPrice( cartItem.getProduct().getPrice() );

        return orderItem;
    }

    @Override
    public List<OrderItem> toEntityList(List<CartItem> cartItems) {
        if (cartItems == null) return null;

        return cartItems.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}
