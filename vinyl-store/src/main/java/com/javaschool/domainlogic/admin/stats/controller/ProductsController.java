package com.javaschool.domainlogic.admin.stats.controller;

import com.javaschool.domainlogic.admin.stats.dto.ProductStats;
import com.javaschool.domainlogic.admin.stats.service.api.ProductStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/stats/products")
public class ProductsController {

    @Autowired
    private ProductStatsService productStatsService;

    @GetMapping
    public String showStats(ModelMap modelMap) {
        ProductStats productStats = productStatsService.getProductStats();
        modelMap.addAttribute("productStats", productStats);

        return "admin/products";
    }

}
