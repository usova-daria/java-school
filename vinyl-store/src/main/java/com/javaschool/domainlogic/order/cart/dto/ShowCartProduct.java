package com.javaschool.domainlogic.order.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class ShowCartProduct {

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
    private String picture;

    /**
     * Number of units in the store
     */
    private int unitsInStore;

}
