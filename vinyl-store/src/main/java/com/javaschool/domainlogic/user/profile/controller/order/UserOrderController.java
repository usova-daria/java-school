package com.javaschool.domainlogic.user.profile.controller.order;

import com.javaschool.domainlogic.user.profile.exception.UserHasNoSuchOrder;
import com.javaschool.domainlogic.user.profile.service.api.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping("/orders/{id}")
    public String showOrder(@PathVariable("id") Long orderId, ModelMap modelMap) {
        modelMap.put("order", userOrderService.getUserOrderByOrderId(orderId));
        return "user/profile/order";
    }

    @ExceptionHandler(UserHasNoSuchOrder.class)
    public String handleAccessDeniedException() {
        return "access-denied";
    }

}
