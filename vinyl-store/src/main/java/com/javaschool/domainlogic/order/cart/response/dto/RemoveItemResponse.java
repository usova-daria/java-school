package com.javaschool.domainlogic.order.cart.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveItemResponse {

    private String message;
    private Double newTotal;

}
