package com.javaschool.domainlogic.admin.stats.controller;

import com.javaschool.domainlogic.admin.stats.dto.CustomerStats;
import com.javaschool.domainlogic.admin.stats.service.api.CustomerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/stats/customers")
public class CustomersController {

    @Autowired
    private CustomerStatsService customerStatsService;

    @GetMapping
    public String showStats(ModelMap modelMap) {
        CustomerStats customerStats = customerStatsService.getCustomerStats();
        modelMap.addAttribute("customerStats", customerStats);

        return "admin/customers";
    }

}
