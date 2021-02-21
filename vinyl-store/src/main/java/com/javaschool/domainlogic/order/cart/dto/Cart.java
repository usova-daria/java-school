package com.javaschool.domainlogic.order.cart.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<CartItem> items;

    private double total;

    public Cart() {
        this.items = new ArrayList<>();
    }

}
