package com.javaschool.domainlogic.admin.order.service.impl;

import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.domainlogic.admin.order.dto.AdminOrderInfo;
import com.javaschool.domainlogic.admin.order.dto.UpdateOrderStatusDto;
import com.javaschool.domainlogic.admin.order.exception.OrderStatusUpdateFailed;
import com.javaschool.domainlogic.admin.order.mapper.AdminOrderInfoMapper;
import com.javaschool.domainlogic.admin.order.service.api.AdminOrderService;
import com.javaschool.entity.order.Order;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AdminOrderInfoMapper orderInfoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AdminOrderInfo> getOrderInfoList() {
        List<AdminOrderInfo> orderInfoList = new ArrayList<>();

        try {
            List<Order> orderList = orderRepository.findAllSortedByIdDesc();
            orderInfoList = orderInfoMapper.toDtoList(orderList);
        } catch (PersistenceException e) {
            log.error("An error occurred while getting order information", e);
        }

        return orderInfoList;
    }

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
}
