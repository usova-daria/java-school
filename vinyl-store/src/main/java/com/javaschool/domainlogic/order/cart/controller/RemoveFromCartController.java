package com.javaschool.domainlogic.order.cart.controller;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.response.dto.RemoveItemResponse;
import com.javaschool.domainlogic.order.cart.service.api.RemoveFromCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes("cart")
@RequestMapping("/cart/remove")
public class RemoveFromCartController {

    @Autowired
    private RemoveFromCartService removeFromCartService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<RemoveItemResponse> removeItemFromCart(@PathVariable("id") Long productId,
                                                                 @ModelAttribute("cart") Cart cart) {
        return removeFromCartService.removeItemFromCart(productId, cart);
    }

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

}
