package com.javaschool.domainlogic.products.cart.controller;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @ResponseBody
    @GetMapping(value = "/add/{id}")
    public void addItemToCart(@PathVariable("id") Long productId, HttpSession session) {
        cartService.addItemToCartByProductId(productId, session);
    }

    @ResponseBody
    @GetMapping(value = "/remove/{id}")
    public double removeItemFromCart(@PathVariable("id") Long productId, HttpSession session) {
        cartService.removeItemFromCartByProductId(productId, session);
        return cartService.getCart(session).getTotal();
    }

    @GetMapping
    public String showCartPage(ModelMap modelMap, HttpSession session) {
        Cart cart = cartService.updateCart(session);
        modelMap.addAttribute("cart", cart);

        return "order/cart";
    }

    @GetMapping("/redirect-to-checkout")
    public String redirectToCheckout(HttpSession session) {
        // TODO: check if all items are available, show changes in the cart if any
        return "redirect:/checkout";
    }


}
