package com.javaschool.domainlogic.admin.order.controller;

import com.javaschool.domainlogic.admin.order.dto.UpdateOrderStatusDto;
import com.javaschool.domainlogic.admin.order.service.api.AdminOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author Daria Usova
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/orders")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    @GetMapping
    public String getOrders(ModelMap modelMap) {
        adminOrderService.fillModelMap(modelMap);
        return "/admin/orders";
    }

    @ResponseBody
    @PostMapping(value = "/update-status", consumes = "application/json")
    public void editGenre(@RequestBody UpdateOrderStatusDto orderStatusDto) {
        adminOrderService.updateOrderStatus(orderStatusDto);
    }

}
