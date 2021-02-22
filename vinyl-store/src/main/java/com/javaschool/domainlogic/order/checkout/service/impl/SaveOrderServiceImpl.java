package com.javaschool.domainlogic.order.checkout.service.impl;

import com.javaschool.dao.api.order.OrderItemRepository;
import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.order.checkout.exception.OrderMappingException;
import com.javaschool.domainlogic.order.checkout.exception.OrderNotPlacedException;
import com.javaschool.domainlogic.order.checkout.mapper.api.CheckoutFormToOrderMapper;
import com.javaschool.domainlogic.order.checkout.service.api.SaveOrderService;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.OrderItem;
import com.javaschool.entity.product.Product;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class SaveOrderServiceImpl implements SaveOrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserService userService;
    private final CheckoutFormToOrderMapper orderMapper;

    @Override
    @Transactional
    public Order saveOrder(Order order, User user) {
        // save order
        List<OrderItem> orderItems = order.getItems();
        order.setItems(null);
        orderRepository.save(order);

        // save data to order_item table
        orderItems.forEach(oi -> oi.setOrder(order));
        orderItems.forEach(orderItemRepository::save);

        // update number of units in store
        for (OrderItem item : orderItems) {
            Product product = item.getProduct();
            int newUnitsInStore = product.getUnitsInStore() - 1;
            product.setUnitsInStore(newUnitsInStore);

            productRepository.updateWithLock(product);
        }

        // add order to user
        user.getOrders().add(order);
        userService.update(user);

        return order;
    }

    @Override
    @Transactional
    public Order saveOrder(CheckoutFormDto checkoutFormDto, Cart cart) {
        User user = userService.getCurrentUser();
        Order order = mapOrder(checkoutFormDto, cart);
        return saveOrder(order, user);
    }

    private Order mapOrder(CheckoutFormDto checkoutFormDto, Cart cart) {
        try {
            return orderMapper.toEntity(checkoutFormDto, cart);
        } catch (OrderMappingException e) {
            log.error(e.getMessage(), e);
            throw new OrderNotPlacedException(e.getMessage(), e);
        }
    }
}
