package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.order.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends AbstractRepositoryImpl<Order, Long> implements OrderRepository {

    public OrderRepositoryImpl() {
        super(Order.class);
    }


}
