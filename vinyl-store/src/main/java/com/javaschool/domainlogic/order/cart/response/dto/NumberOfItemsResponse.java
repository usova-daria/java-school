package com.javaschool.domainlogic.order.cart.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumberOfItemsResponse {

    private String message;
    private int newQuantity;
    private Double newTotal;

}
