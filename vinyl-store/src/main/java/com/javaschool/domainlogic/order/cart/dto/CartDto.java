package com.javaschool.domainlogic.order.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {

    private List<CartItemDto> items;
    private double total;

}
