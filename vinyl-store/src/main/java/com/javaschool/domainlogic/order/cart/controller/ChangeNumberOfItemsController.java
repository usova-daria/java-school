package com.javaschool.domainlogic.order.cart.controller;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.response.dto.NumberOfItemsResponse;
import com.javaschool.domainlogic.order.cart.service.api.ChangeNumberOfItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
@RequestMapping("/cart/update")
public class ChangeNumberOfItemsController {

    @Autowired
    private ChangeNumberOfItemsService changeNumberOfItemsService;

    @GetMapping(value = "/{id}/{quantity}")
    public ResponseEntity<NumberOfItemsResponse> updateNumberOfItemsInTheCart(@PathVariable("id") Long productId,
                                                                              @PathVariable("quantity") Integer quantity,
                                                                              @ModelAttribute("cart") Cart cart) {
        return changeNumberOfItemsService.updateNumberOfItemsInTheCart(productId, quantity, cart);
    }

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

}
