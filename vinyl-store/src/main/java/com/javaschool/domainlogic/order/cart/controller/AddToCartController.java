package com.javaschool.domainlogic.order.cart.controller;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.response.dto.NumberOfItemsResponse;
import com.javaschool.domainlogic.order.cart.service.api.AddToCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cart/add")
public class AddToCartController  {

    private final AddToCartService addToCartService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<NumberOfItemsResponse> addItemToCart(@PathVariable("id") Long productId,
                                                               @SessionAttribute("cart") Cart cart) {
        return addToCartService.addItemToCart(productId, cart);
    }

    @GetMapping(value = "/{id}/{quantity}")
    public ResponseEntity<NumberOfItemsResponse> addItemsToCart(@PathVariable("id") Long productId,
                                                                @PathVariable("quantity") Integer quantity,
                                                                @SessionAttribute("cart") Cart cart) {
        return addToCartService.addItemToCart(productId, quantity, cart);
    }

}
