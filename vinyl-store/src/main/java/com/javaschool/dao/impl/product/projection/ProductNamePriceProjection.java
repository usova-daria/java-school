package com.javaschool.dao.impl.product.projection;

import lombok.Data;

@Data
public class ProductNamePriceProjection {

    private Long id;
    private float price;
    private String name;

    public ProductNamePriceProjection(Long id, float price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
}
