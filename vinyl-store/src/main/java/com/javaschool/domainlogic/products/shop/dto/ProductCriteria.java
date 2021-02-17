package com.javaschool.domainlogic.products.shop.dto;

import lombok.Data;

@Data
public class ProductCriteria {

    private Integer[] genre;
    private float maxPrice;
    private float minPrice;
    private boolean available;
    private String nameContains;
    private boolean highPriceFirst;

}
