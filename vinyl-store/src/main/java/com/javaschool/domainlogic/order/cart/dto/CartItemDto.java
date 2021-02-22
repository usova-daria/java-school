package com.javaschool.domainlogic.order.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemDto {

    private ShowCartProduct product;
    private int prevQuantity;
    private int newQuantity;

}
