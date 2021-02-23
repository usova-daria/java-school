package com.javaschool.domainlogic.admin.order.service.impl;

import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.domainlogic.admin.order.dto.AdminOrderInfo;
import com.javaschool.domainlogic.admin.order.dto.UpdateOrderStatusDto;
import com.javaschool.domainlogic.admin.order.exception.OrderStatusUpdateFailed;
import com.javaschool.domainlogic.admin.order.mapper.AdminOrderInfoMapper;
import com.javaschool.domainlogic.admin.order.service.api.AdminOrderService;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.enumeration.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class AdminOrderServiceImpl implements AdminOrderService {

    private final OrderRepository orderRepository;
    private final AdminOrderInfoMapper orderInfoMapper;

    @Override
    @Transactional
    public void updateOrderStatus(UpdateOrderStatusDto orderStatusDto) {
        try {
            orderRepository.updateOrderStatusWithId(orderStatusDto.getId(), orderStatusDto.getStatus());
        } catch (PersistenceException e) {
            log.error("An error occurred while updating order status with id = " + orderStatusDto.getId(), e);
            throw new OrderStatusUpdateFailed("Order status not updated");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void fillModelMap(ModelMap modelMap) {
        List<AdminOrderInfo> orders = getOrderInfoList();
        OrderStatus[] orderStatuses = OrderStatus.values();

        modelMap.put("orders", orders);
        modelMap.put("orderStatusList", orderStatuses);
    }

    private List<AdminOrderInfo> getOrderInfoList() {
        List<AdminOrderInfo> orderInfoList = new ArrayList<>();

        try {
            List<Order> orderList = orderRepository.findAllSortedByIdDesc();
            orderInfoList = orderInfoMapper.toDtoList(orderList);
        } catch (PersistenceException e) {
            log.error("An error occurred while getting order information", e);
        }

        return orderInfoList;
    }

}
