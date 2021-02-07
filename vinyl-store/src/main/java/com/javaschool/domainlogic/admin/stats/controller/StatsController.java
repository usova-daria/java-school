package com.javaschool.domainlogic.admin.stats.controller;

import com.javaschool.domainlogic.admin.stats.dto.CustomerStats;
import com.javaschool.domainlogic.admin.stats.dto.ProductStats;
import com.javaschool.domainlogic.admin.stats.dto.SalesStats;
import com.javaschool.domainlogic.admin.stats.service.api.CustomerStatsService;
import com.javaschool.domainlogic.admin.stats.service.api.ProductStatsService;
import com.javaschool.domainlogic.admin.stats.service.api.SalesStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/stats")
public class StatsController {

    @Autowired
    private SalesStatsService salesStatsService;

    @Autowired
    private CustomerStatsService customerStatsService;

    @Autowired
    private ProductStatsService productStatsService;

    @GetMapping
    public String showStats(ModelMap modelMap) {
        SalesStats salesStats = salesStatsService.getSalesStats();
        CustomerStats customerStats = customerStatsService.getCustomerStats();
        ProductStats productStats = productStatsService.getProductStats();

        modelMap.addAttribute("salesStats", salesStats);
        modelMap.addAttribute("customerStats", customerStats);
        modelMap.addAttribute("productStats", productStats);

        return "admin/stats";
    }

    @GetMapping("/{year}")
    public String showStatsOfYear(@PathVariable int year, ModelMap modelMap) {
        SalesStats salesStats = salesStatsService.getSalesStats(year);
        CustomerStats customerStats = customerStatsService.getCustomerStats();
        ProductStats productStats = productStatsService.getProductStats();

        modelMap.addAttribute("salesStats", salesStats);
        modelMap.addAttribute("customerStats", customerStats);
        modelMap.addAttribute("productStats", productStats);

        return "admin/stats";
    }

}
