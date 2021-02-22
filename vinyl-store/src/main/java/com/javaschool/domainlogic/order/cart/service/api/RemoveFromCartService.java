package com.javaschool.domainlogic.order.cart.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.response.dto.RemoveItemResponse;
import org.springframework.http.ResponseEntity;

public interface RemoveFromCartService {

    ResponseEntity<RemoveItemResponse> removeItemFromCart(Long productId, Cart cart);

}
