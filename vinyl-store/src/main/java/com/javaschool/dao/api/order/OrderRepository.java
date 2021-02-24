package com.javaschool.dao.api.order;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreviewInfo;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.enumeration.OrderStatus;

import java.util.List;
import java.util.Optional;

/**
 * @author Daria Usova
 */
public interface OrderRepository extends AbstractRepository<Order, Long> {

    /**
     * Update order status with id.
     *
     * @param id          the id
     * @param orderStatus the order status
     */
    void updateOrderStatusWithId(Long id, OrderStatus orderStatus);

    /**
     * Find all sorted by id desc list.
     *
     * @return the list
     */
    List<Order> findAllSortedByIdDesc();

    /**
     * Find user order preview info by user id list.
     *
     * @param id the id
     * @return the list
     */
    List<UserOrderPreviewInfo> findUserOrderPreviewInfoByUserId(Long id);

    /**
     * Find order item pictures by order id list.
     *
     * @param id         the id
     * @param resultSize the result size
     * @return the list
     */
    List<byte[]> findOrderItemPicturesByOrderId(Long id, int resultSize);

    /**
     * Find by id with entity graph optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Order> findByIdWithEntityGraph(Long id);

}
