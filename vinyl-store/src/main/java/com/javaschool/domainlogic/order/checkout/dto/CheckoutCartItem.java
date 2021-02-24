package com.javaschool.domainlogic.order.checkout.dto;

import lombok.Data;

/**
 * @author Daria Usova
 */
@Data
public class CheckoutCartItem {

    /**
     * Product id
     */
    private Long id;

    /**
     * Product name
     */
    private String name;

    /**
     * Product price
     */
    private float price;

    /**
     * Number of items added to the cart by user
     */
    private int prevQuantity;

    /**
     * Updated number of items
     */
    private int newQuantity;

    /**
     * Instantiates a new checkout cart item.
     *
     * @param id    the id
     * @param name  the name
     * @param price the price
     */
    public CheckoutCartItem(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
