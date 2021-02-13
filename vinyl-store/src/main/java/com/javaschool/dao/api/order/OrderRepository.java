package com.javaschool.dao.api.order;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreviewInfo;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.enumeration.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends AbstractRepository<Order, Long> {

    void updateOrderStatusWithId(Long id, OrderStatus orderStatus);

    List<Order> findAllSortedByIdDesc();

    List<UserOrderPreviewInfo> findUserOrderPreviewInfoByUserId(Long id);

    List<byte[]> findOrderItemPicturesByOrderId(Long id, int resultSize);

    Optional<Order> findByIdWithEntityGraph(Long id);

}
