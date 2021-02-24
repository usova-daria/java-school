package com.javaschool.domainlogic.order.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CartItem implements Serializable {

    private Long productId;
    private int quantity;

}
