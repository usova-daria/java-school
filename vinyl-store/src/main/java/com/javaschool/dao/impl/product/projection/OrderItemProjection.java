package com.javaschool.dao.impl.product.projection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemProjection {

    private Long id;
    private String name;
    private byte[] picture;
    private float price;
    private int quantity;

}
