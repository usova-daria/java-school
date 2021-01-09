package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.OrderDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.order.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractDaoImpl<Order, Long> implements OrderDao {

    public OrderDaoImpl() {
        super(Order.class);
    }


}
