package com.javaschool.domainlogic.products.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {

    private List<CartItemDto> items;
    private double total;

}
