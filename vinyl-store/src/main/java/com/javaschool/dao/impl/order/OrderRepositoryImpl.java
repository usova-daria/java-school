package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreviewInfo;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.enumeration.OrderStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Optional<Order> findByIdWithEntityGraph(Long id) {
        if (id == null) return Optional.empty();

        EntityGraph entityGraph = entityManager.getEntityGraph("order-graph");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);

        Order order = entityManager.find(Order.class, id, properties);
        return Optional.ofNullable(order);
    }

    @Override
    public List<Order> findAllSortedByIdDesc() {
        EntityGraph entityGraph = entityManager.getEntityGraph("order-graph");

        return entityManager.createQuery("SELECT o from Order o order by o.id DESC", Order.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }

    @Override
    public List<UserOrderPreviewInfo> findUserOrderPreviewInfoByUserId(Long id) {
        return entityManager.createNamedQuery("Order.findUserOrderPreviewInfoByUserId")
                .setParameter("user_id", id)
                .getResultList();
    }

    @Override
    public List<byte[]> findOrderItemPicturesByOrderId(Long id, int resultSize) {
        TypedQuery<byte[]> query =
                entityManager.createNamedQuery("Order.findOrderItemPicturesByOrderId", byte[].class);

        return query.setParameter("order_id", id)
                .setMaxResults(resultSize)
                .getResultList();
    }

}
