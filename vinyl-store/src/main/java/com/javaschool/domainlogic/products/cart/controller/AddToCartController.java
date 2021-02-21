package com.javaschool.domainlogic.products.cart.controller;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.response.dto.NumberOfItemsResponse;
import com.javaschool.domainlogic.products.cart.service.api.AddToCartService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@SessionAttributes("cart")
@RequestMapping("/cart/add")
public class AddToCartController  {

    @Autowired
    private AddToCartService addToCartService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<NumberOfItemsResponse> addItemToCart(@PathVariable("id") Long productId,
                                                               @ModelAttribute("cart") Cart cart) {
        return addToCartService.addItemToCart(productId, cart);
    }

    @GetMapping(value = "/{id}/{quantity}")
    public ResponseEntity<NumberOfItemsResponse> addItemsToCart(@PathVariable("id") Long productId,
                                                                @PathVariable("quantity") Integer quantity,
                                                                @ModelAttribute("cart") Cart cart) {
        return addToCartService.addItemToCart(productId, quantity, cart);
    }

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

}
