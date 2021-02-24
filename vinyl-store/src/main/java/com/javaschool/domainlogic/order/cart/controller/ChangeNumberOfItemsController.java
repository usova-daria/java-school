package com.javaschool.domainlogic.order.cart.controller;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.response.dto.NumberOfItemsResponse;
import com.javaschool.domainlogic.order.cart.service.api.ChangeNumberOfItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart/update")
public class ChangeNumberOfItemsController {

    private final ChangeNumberOfItemsService changeNumberOfItemsService;

    @GetMapping(value = "/{id}/{quantity}")
    public ResponseEntity<NumberOfItemsResponse> updateNumberOfItemsInTheCart(@PathVariable("id") Long productId,
                                                                              @PathVariable("quantity") Integer quantity,
                                                                              @SessionAttribute("cart") Cart cart) {
        return changeNumberOfItemsService.updateNumberOfItemsInTheCart(productId, quantity, cart);
    }

}
