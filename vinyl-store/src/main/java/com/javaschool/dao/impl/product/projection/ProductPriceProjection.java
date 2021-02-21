package com.javaschool.dao.impl.product.projection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductPriceProjection {

    private Long productId;
    private float price;

}
