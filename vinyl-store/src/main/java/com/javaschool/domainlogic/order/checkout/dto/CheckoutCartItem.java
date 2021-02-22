package com.javaschool.domainlogic.order.checkout.dto;

import lombok.Data;

@Data
public class CheckoutCartItem {

    private Long id;
    private String name;
    private float price;

    private int prevQuantity;
    private int newQuantity;

    public CheckoutCartItem(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
