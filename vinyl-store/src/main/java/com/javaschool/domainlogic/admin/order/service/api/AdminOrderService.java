package com.javaschool.domainlogic.admin.order.service.api;

import com.javaschool.domainlogic.admin.order.dto.AdminOrderInfo;
import com.javaschool.domainlogic.admin.order.dto.UpdateOrderStatusDto;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface AdminOrderService {

    /**
     * Gets order info list.
     *
     * @return the order info list
     */
    List<AdminOrderInfo> getOrderInfoList();

    /**
     * Update order status.
     *
     * @param orderStatusDto the order status dto
     */
    void updateOrderStatus(UpdateOrderStatusDto orderStatusDto);

}
