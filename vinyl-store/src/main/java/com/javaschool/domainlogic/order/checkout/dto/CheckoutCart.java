package com.javaschool.domainlogic.order.checkout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutCart {

    /**
     * Cart items
     */
    private List<CheckoutCartItem> items;

    /**
     * Total
     */
    private double total;

}
