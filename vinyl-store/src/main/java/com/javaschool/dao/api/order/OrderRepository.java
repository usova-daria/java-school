package com.javaschool.dao.api.order;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.enumeration.OrderStatus;

import java.util.List;

public interface OrderRepository extends AbstractRepository<Order, Long> {

    void updateOrderStatusWithId(Long id, OrderStatus orderStatus);

    List<Order> findAllSortedByIdDesc();

}
