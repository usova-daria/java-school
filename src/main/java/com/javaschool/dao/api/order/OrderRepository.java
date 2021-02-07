package com.javaschool.dao.api.order;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.enumeration.OrderStatus;

public interface OrderRepository extends AbstractRepository<Order, Long> {

    void updateOrderStatusWithId(Long id, OrderStatus orderStatus);

}
