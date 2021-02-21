package com.javaschool.domainlogic.products.cart.service.api;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.response.dto.RemoveItemResponse;
import org.springframework.http.ResponseEntity;

public interface RemoveFromCartService {

    ResponseEntity<RemoveItemResponse> removeItemFromCart(Long productId, Cart cart);

}
