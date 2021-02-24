package com.javaschool.domainlogic.order.cart.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart implements Serializable {

    private List<CartItem> items;

    private double total;

    public Cart() {
        this.items = new ArrayList<>();
    }

}
