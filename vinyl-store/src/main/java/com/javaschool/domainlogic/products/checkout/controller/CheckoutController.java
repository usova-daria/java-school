package com.javaschool.domainlogic.products.checkout.controller;

import com.javaschool.domainlogic.products.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.products.checkout.dto.CountryDto;
import com.javaschool.domainlogic.products.checkout.dto.DeliveryDto;
import com.javaschool.domainlogic.products.checkout.dto.TownDto;
import com.javaschool.domainlogic.products.checkout.service.api.CheckoutService;
import com.javaschool.domainlogic.products.checkout.service.api.PlaceOrderService;
import com.javaschool.entity.order.enumeration.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private PlaceOrderService placeOrderService;

    @ModelAttribute("countries")
    private List<CountryDto> countries() {
        return checkoutService.getCountries();
    }

    @ModelAttribute("deliveryOptions")
    private List<DeliveryDto> deliveryOptions() {
        return checkoutService.getDeliveryOptions();
    }

    @ModelAttribute("paymentOptions")
    private PaymentMethod[] paymentOptions() {
        return PaymentMethod.values();
    }

    @GetMapping
    public String showCheckoutPage(ModelMap modelMap, HttpSession session) {
        checkoutService.updateCart(session);

        CheckoutFormDto checkoutFormDto = checkoutService.getNewCheckoutForm();
        modelMap.addAttribute("checkoutForm", checkoutFormDto);

        return "/order/checkout";
    }

    @PostMapping("/place-order")
    public String placeOrder(@Valid @ModelAttribute("checkoutForm") CheckoutFormDto checkoutFormDto,
                             BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            return "/order/checkout";
        }

        placeOrderService.placeOrder(checkoutFormDto, session);
        return "redirect:/checkout/success";
    }

    @ResponseBody
    @GetMapping(value = "/towns/{id}", produces = "application/json")
    public List<TownDto> getTownsByCountryId(@PathVariable("id") Integer countryId) {
        return checkoutService.getTownsByCountryId(countryId);
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "/order/success";
    }

}
