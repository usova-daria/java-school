package com.javaschool.domainlogic.admin.order.service.api;

import com.javaschool.domainlogic.admin.order.dto.AdminOrderInfo;
import com.javaschool.domainlogic.admin.order.dto.UpdateOrderStatusDto;

import java.util.List;

public interface AdminOrderService {

    List<AdminOrderInfo> getOrderInfoList();

    void updateOrderStatus(UpdateOrderStatusDto orderStatusDto);

}
