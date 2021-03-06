package com.javaschool.domainlogic.admin.stats.controller;

import com.javaschool.domainlogic.admin.stats.service.api.SalesStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Daria Usova
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/stats/sales")
public class SalesController {

    private final SalesStatsService salesStatsService;

    @GetMapping
    public String showStats(ModelMap modelMap) {
        salesStatsService.fillModelMap(modelMap);
        return "/admin/sales";
    }

    @GetMapping("/{year}")
    public String showStatsOfYear(@PathVariable int year, ModelMap modelMap) {
        salesStatsService.fillModelMap(year, modelMap);

        return "admin/year-profit :: #year-profit";
    }

}
