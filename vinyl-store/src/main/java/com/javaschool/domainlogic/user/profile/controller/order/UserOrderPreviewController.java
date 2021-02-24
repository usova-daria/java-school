package com.javaschool.domainlogic.user.profile.controller.order;

import com.javaschool.domainlogic.user.profile.service.api.orderpreview.UserOrderPreviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")
public class UserOrderPreviewController {

    private final UserOrderPreviewService userOrderPreviewService;

    @GetMapping("/orders")
    public String showOrdersPage(ModelMap modelMap) {
        modelMap.addAttribute("orders", userOrderPreviewService.getOrdersOfCurrentUser());
        return "/user/profile/orders";
    }

}
