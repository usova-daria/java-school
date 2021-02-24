package com.javaschool.domainlogic.order.cart.controller;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.service.api.ShowCartPageService;
import com.javaschool.domainlogic.order.cart.service.api.UpdateCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Log4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class ShowCartController {

    private final ShowCartPageService showCartPageService;
    private final UpdateCartService updateCartService;

    @GetMapping
    public String showCartPage(ModelMap modelMap, @SessionAttribute("cart") Cart cart) {
        modelMap.addAttribute("cartDto", showCartPageService.getCartDto(cart));
        return "order/cart";
    }

    @GetMapping("/redirect-to-checkout")
    public String redirectToCheckout(@SessionAttribute("cart") Cart cart) {
        if (updateCartService.itemsAreAvailable(cart)) {
            return "redirect:/checkout";
        }

        return "redirect:/cart";
    }

}
