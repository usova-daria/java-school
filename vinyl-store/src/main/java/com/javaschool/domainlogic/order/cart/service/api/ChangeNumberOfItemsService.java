package com.javaschool.domainlogic.order.cart.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.response.dto.NumberOfItemsResponse;
import org.springframework.http.ResponseEntity;

public interface ChangeNumberOfItemsService {

    ResponseEntity<NumberOfItemsResponse> updateNumberOfItemsInTheCart(Long productId, Integer quantity, Cart cart);

}
