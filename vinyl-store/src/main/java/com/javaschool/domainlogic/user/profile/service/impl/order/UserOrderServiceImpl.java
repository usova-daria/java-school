package com.javaschool.domainlogic.user.profile.service.impl.order;

import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.dao.impl.product.projection.OrderItemProjection;
import com.javaschool.domainlogic.user.profile.dto.order.UserOrder;
import com.javaschool.domainlogic.user.profile.dto.order.UserOrderInfo;
import com.javaschool.domainlogic.user.profile.dto.order.UserOrderItem;
import com.javaschool.domainlogic.user.profile.exception.order.OrderNotFound;
import com.javaschool.domainlogic.user.profile.exception.order.UserHasNoSuchOrder;
import com.javaschool.domainlogic.user.profile.mapper.order.UserOrderInfoMapper;
import com.javaschool.domainlogic.user.profile.mapper.order.UserOrderItemMapper;
import com.javaschool.domainlogic.user.profile.service.api.order.UserOrderService;
import com.javaschool.entity.order.Order;
import com.javaschool.service.api.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class UserOrderServiceImpl implements UserOrderService {

    private final UserOrderInfoMapper userOrderInfoMapper;
    private final UserOrderItemMapper userOrderItemMapper;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final UserService userService;

    @Transactional(readOnly = true)
    public UserOrder getUserOrderByOrderId(Long id) {
        try {
            return tryToGetUserOrderById(id);
        } catch (PersistenceException e) {
            log.error("An error occurred while getting order info by order id", e);
            return new UserOrder();
        }
    }

    private UserOrder tryToGetUserOrderById(Long id) {
        if (!userService.currentUserHasOrder(id)) {
            throw new UserHasNoSuchOrder();
        }

        UserOrderInfo orderInfo = getUserOrderInfoByOrderId(id);
        List<UserOrderItem> items = getItemsByOrderId(id);

        return new UserOrder(orderInfo, items);
    }

    private UserOrderInfo getUserOrderInfoByOrderId(Long id) {
        Order order = orderRepository.findByIdWithEntityGraph(id)
                .orElseThrow(() -> new OrderNotFound(id));
        return userOrderInfoMapper.toDto(order);
    }

    private List<UserOrderItem> getItemsByOrderId(Long id) {
        List<OrderItemProjection> orderItemProjections = productRepository.findOrderItemProjectionByOrderId(id);
        return userOrderItemMapper.toDtoList(orderItemProjections);
    }

}
