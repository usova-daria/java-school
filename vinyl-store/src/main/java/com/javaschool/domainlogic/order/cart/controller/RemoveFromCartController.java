package com.javaschool.domainlogic.order.cart.controller;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.response.dto.RemoveItemResponse;
import com.javaschool.domainlogic.order.cart.service.api.RemoveFromCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart/remove")
public class RemoveFromCartController {

    private final RemoveFromCartService removeFromCartService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<RemoveItemResponse> removeItemFromCart(@PathVariable("id") Long productId,
                                                                 @SessionAttribute("cart") Cart cart) {
        return removeFromCartService.removeItemFromCart(productId, cart);
    }

}
