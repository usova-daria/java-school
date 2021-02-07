package com.javaschool.domainlogic.products.home.controller;

import com.javaschool.domainlogic.products.dto.ProductDto;
import com.javaschool.domainlogic.products.home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("products")
    private List<ProductDto> productDtoList() {
        return productService.getNotDeletedProductsSortedByCreated(8);
    }

    @GetMapping
    public String showHomePage() {
        return "home";
    }

}
