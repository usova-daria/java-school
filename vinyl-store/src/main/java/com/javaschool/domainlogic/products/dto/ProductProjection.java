package com.javaschool.domainlogic.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

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
    private byte[] picture;

    /**
     * Number of units in the store
     */
    private int unitsInStore;

}
