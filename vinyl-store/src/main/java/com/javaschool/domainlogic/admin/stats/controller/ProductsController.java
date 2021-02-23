package com.javaschool.domainlogic.admin.stats.controller;

import com.javaschool.domainlogic.admin.stats.dto.ProductStats;
import com.javaschool.domainlogic.admin.stats.service.api.ProductStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Daria Usova
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/stats/products")
public class ProductsController {

    private final ProductStatsService productStatsService;

    @GetMapping
    public String showStats(ModelMap modelMap) {
        ProductStats productStats = productStatsService.getProductStats();
        modelMap.addAttribute("productStats", productStats);

        return "admin/products";
    }

}
