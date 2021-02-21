package com.javaschool.domainlogic.products.cart.service.api;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.response.dto.NumberOfItemsResponse;
import org.springframework.http.ResponseEntity;

public interface ChangeNumberOfItemsService {

    ResponseEntity<NumberOfItemsResponse> updateNumberOfItemsInTheCart(Long productId, Integer quantity, Cart cart);

}
