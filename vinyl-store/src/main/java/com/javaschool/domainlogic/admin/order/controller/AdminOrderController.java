package com.javaschool.domainlogic.admin.order.controller;

import com.javaschool.domainlogic.admin.order.dto.AdminOrderInfo;
import com.javaschool.domainlogic.admin.order.dto.UpdateOrderStatusDto;
import com.javaschool.domainlogic.admin.order.service.api.AdminOrderService;
import com.javaschool.entity.order.enumeration.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Daria Usova
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/orders")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    @ModelAttribute("orders")
    public List<AdminOrderInfo> adminOrderInfoList() {
        return adminOrderService.getOrderInfoList();
    }

    @ModelAttribute("orderStatusList")
    public OrderStatus[] orderStatusList() {
        return OrderStatus.values();
    }

    @GetMapping
    public String getOrders() {
        return "/admin/orders";
    }

    @ResponseBody
    @PostMapping(value = "/update-status", consumes = "application/json")
    public void editGenre(@RequestBody UpdateOrderStatusDto orderStatusDto) {
        adminOrderService.updateOrderStatus(orderStatusDto);
    }

}
