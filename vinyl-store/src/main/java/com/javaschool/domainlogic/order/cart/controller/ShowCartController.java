package com.javaschool.domainlogic.order.cart.controller;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.service.api.ShowCartPageService;
import com.javaschool.domainlogic.order.cart.service.api.UpdateCartService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Log4j
@Controller
@SessionAttributes("cart")
@RequestMapping("/cart")
public class ShowCartController {

    @Autowired
    private ShowCartPageService showCartPageService;

    @Autowired
    private UpdateCartService updateCartService;

    @GetMapping
    public String showCartPage(ModelMap modelMap, @ModelAttribute("cart") Cart cart) {
        modelMap.addAttribute("cartDto", showCartPageService.getCartDto(cart));
        return "order/cart";
    }

    @GetMapping("/redirect-to-checkout")
    public String redirectToCheckout(@ModelAttribute("cart") Cart cart) {
        if (updateCartService.itemsAreAvailable(cart)) {
            return "redirect:/checkout";
        }

        return "redirect:/cart";
    }

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

}
