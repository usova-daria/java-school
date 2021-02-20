package com.javaschool.dao.impl.product.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class ProductProjection {

    /**
     * Product id
     */
    private Long id;

    /**
     * Product price
     */
    private float price;

    /**
     * Product name
     */
    private String name;

    /**
     * Product picture
     */
    @ToString.Exclude
    private byte[] picture;

    /**
     * Number of units in the store
     */
    private int unitsInStore;

}
