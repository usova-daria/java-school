package com.javaschool.domainlogic.user.profile.controller.order;

import com.javaschool.domainlogic.user.profile.service.api.UserOrderPreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class UserOrderPreviewController {

    @Autowired
    private UserOrderPreviewService userOrderPreviewService;

    @GetMapping("/orders")
    public String showOrdersPage(ModelMap modelMap) {
        modelMap.addAttribute("orders", userOrderPreviewService.getOrdersOfCurrentUser());
        return "/user/profile/orders";
    }

}
