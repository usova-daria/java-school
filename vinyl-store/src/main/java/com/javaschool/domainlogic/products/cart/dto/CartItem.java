package com.javaschool.domainlogic.products.cart.dto;

import com.javaschool.domainlogic.products.common.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {

    private ProductDto product;

    private int quantity;

}
