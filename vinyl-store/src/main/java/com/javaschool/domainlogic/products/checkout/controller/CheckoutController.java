package com.javaschool.domainlogic.products.checkout.controller;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.service.api.UpdateCartService;
import com.javaschool.domainlogic.products.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.products.checkout.dto.TownDto;
import com.javaschool.domainlogic.products.checkout.exception.NotEnoughUnitsInStoreException;
import com.javaschool.domainlogic.products.checkout.exception.OrderNotPlacedException;
import com.javaschool.domainlogic.products.checkout.service.api.CheckoutService;
import com.javaschool.domainlogic.products.checkout.service.api.PlaceOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Log4j
@Controller
@AllArgsConstructor
@SessionAttributes("cart")
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final UpdateCartService updateCartService;
    private final PlaceOrderService placeOrderService;

    @GetMapping
    public String showCheckoutPage(ModelMap modelMap, @ModelAttribute("cart") Cart cart) {
        checkoutService.fillShowCheckoutPageModelMap(modelMap, cart);
        return "/order/checkout";
    }

    @ResponseBody
    @GetMapping(value = "/towns/{id}", produces = "application/json")
    public List<TownDto> getTownsByCountryId(@PathVariable("id") Integer countryId) {
        return checkoutService.getTownsByCountryId(countryId);
    }

    @PostMapping("/place-order")
    public ModelAndView placeOrder(@Valid @ModelAttribute("checkoutForm") CheckoutFormDto checkoutFormDto,
                                   BindingResult result, @ModelAttribute("cart") Cart cart) {

        if (cart.getItems().size() == 0) {
            return new ModelAndView("redirect:/cart");
        }

        if (result.hasErrors() || !updateCartService.itemsAreAvailable(cart)) {
            return checkoutService.checkoutErrorPage(cart, checkoutFormDto);
        }

        placeOrderService.placeOrder(checkoutFormDto, cart);
        cart = new Cart();
        return new ModelAndView("redirect:/checkout/success");
    }

    @GetMapping("/success")
    public String success() {
        return "/order/success";
    }

    @ExceptionHandler(OrderNotPlacedException.class)
    public String handleOrderNotPlaced(OrderNotPlacedException ex) {
        if (ex.getCause() instanceof NotEnoughUnitsInStoreException) {
            return "redirect:/cart";
        }

        return "exception/error";
    }

}
