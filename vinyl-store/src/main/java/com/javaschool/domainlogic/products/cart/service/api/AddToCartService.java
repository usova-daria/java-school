package com.javaschool.domainlogic.products.cart.service.api;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.response.dto.NumberOfItemsResponse;
import org.springframework.http.ResponseEntity;

public interface AddToCartService {

    ResponseEntity<NumberOfItemsResponse> addItemToCart(Long productId, Cart cart);

    ResponseEntity<NumberOfItemsResponse> addItemToCart(Long productId, int quantity, Cart cart);

}
