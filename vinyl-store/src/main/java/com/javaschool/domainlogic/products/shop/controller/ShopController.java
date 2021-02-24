package com.javaschool.domainlogic.products.shop.controller;

import com.javaschool.domainlogic.products.shop.service.api.ShopService;
import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public String showAllProductsPage(ModelMap modelMap) {
        shopService.fillShowAllProductsModelMap(modelMap);
        return "product/shop";
    }

    @GetMapping("/filter")
    public String showSearchResults(ProductCriteria productCriteria, ModelMap modelMap) {
        shopService.fillSearchResultsModelMap(productCriteria, modelMap);
        return "product/shop";
    }

    @GetMapping("/search")
    public String search(ProductCriteria productCriteria, ModelMap modelMap) {
        shopService.fillSearchModelMap(productCriteria, modelMap);
        return "fragments/shop-fragment :: #shop-fragment";
    }

}
