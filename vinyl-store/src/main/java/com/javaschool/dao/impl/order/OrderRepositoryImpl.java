package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.enumeration.OrderStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl extends AbstractRepositoryImpl<Order, Long> implements OrderRepository {

    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public void updateOrderStatusWithId(Long id, OrderStatus orderStatus) {
        Optional<Order> order = findById(id);
        order.ifPresent(o -> {
            o.setStatus(orderStatus);
            update(o);
        });
    }

    @Override
    public List<Order> findAll() {
        EntityGraph entityGraph = entityManager.getEntityGraph("order-graph");

        return entityManager.createQuery("SELECT o from Order o", Order.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }

    @Override
    public List<Order> findAllSortedByIdDesc() {
        EntityGraph entityGraph = entityManager.getEntityGraph("order-graph");

        return entityManager.createQuery("SELECT o from Order o order by o.id DESC", Order.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }
}
