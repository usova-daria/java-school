package com.javaschool.domainlogic.products.cart.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveItemResponse {

    private String message;
    private Double newTotal;

}
