package com.javaschool.domainlogic.salesdisplay.controller;

import com.javaschool.domainlogic.salesdisplay.dto.ProductStats;
import com.javaschool.domainlogic.salesdisplay.service.SalesDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SalesDisplayRestController {

    @Autowired
    private SalesDisplayService salesDisplayService;

    @GetMapping("/product-stats")
    public ProductStats getProductStats() {
        return salesDisplayService.getProductStats();
    }

}
