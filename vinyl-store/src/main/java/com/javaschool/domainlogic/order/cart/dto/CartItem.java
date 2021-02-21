package com.javaschool.domainlogic.order.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {

    private Long productId;
    private int quantity;

}
