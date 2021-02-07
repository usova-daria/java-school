package com.javaschool.domainlogic.products.checkout.service.impl;

import com.javaschool.dao.api.order.OrderItemRepository;
import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.service.CartService;
import com.javaschool.domainlogic.products.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.products.checkout.mapper.api.CheckoutFormToOrderMapper;
import com.javaschool.domainlogic.products.checkout.service.api.PaymentService;
import com.javaschool.domainlogic.products.checkout.service.api.PlaceOrderService;
import com.javaschool.domainlogic.salesdisplay.jms.MessageSender;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.OrderItem;
import com.javaschool.entity.product.Product;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Log4j
@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    private final CheckoutFormToOrderMapper orderMapper;
    private final CartService cartService;
    private final PaymentService paymentService;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserService userService;
    private final MessageSender messageSender;

    @Autowired
    public PlaceOrderServiceImpl(CheckoutFormToOrderMapper orderMapper, CartService cartService,
                                 PaymentService paymentService, OrderRepository orderRepository,
                                 ProductRepository productRepository, OrderItemRepository orderItemRepository,
                                 UserService userService, MessageSender messageSender) {
        this.orderMapper = orderMapper;
        this.cartService = cartService;
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
        this.userService = userService;
        this.messageSender = messageSender;
    }

    @Override
    @Transactional
    public void placeOrder(CheckoutFormDto checkoutFormDto, HttpSession session) {
        Cart cart = cartService.getCart(session);
        Order order = orderMapper.toEntity(checkoutFormDto, cart);

        saveOrder(order);
        paymentService.payForTheOrder(order);

        addOrderToUser(order);
        session.setAttribute("cart", new Cart());
        messageSender.sendMessage();
    }

    private void saveOrder(Order order) {
        // save order
        List<OrderItem> orderItems = order.getItems();
        order.setItems(null);
        orderRepository.save(order);
        log.info("New order: id=" + order.getId());

        // save data to order_item table
        orderItems.forEach(oi -> oi.setOrder(order));
        orderItems.forEach(orderItemRepository::save);
        orderItems.forEach(oi -> log.info("New orderItem: order id - " + oi.getOrder().getId() +
                "; product id - " + oi.getProduct().getId()));

        // update number of units in store
        for (OrderItem item : orderItems) {
            Product product = item.getProduct();
            int newUnitsInStore = product.getUnitsInStore() - 1;
            product.setUnitsInStore(newUnitsInStore);

            productRepository.update(product);
        }
    }

    public void addOrderToUser(Order order) {
        User user = userService.getCurrentUser();
        user.getOrders().add(order);
        userService.update(user);

    }

}
