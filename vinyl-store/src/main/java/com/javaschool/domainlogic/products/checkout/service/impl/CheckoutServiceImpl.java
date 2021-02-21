package com.javaschool.domainlogic.products.checkout.service.impl;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.checkout.dto.*;
import com.javaschool.domainlogic.products.checkout.service.api.*;
import com.javaschool.entity.order.enumeration.PaymentMethod;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CountryService countryService;
    private final TownService townService;
    private final DeliveryService deliveryService;
    private final UserService userService;
    private final CheckoutCartService checkoutCartService;

    @Override
    public List<TownDto> getTownsByCountryId(Integer countryId) {
        return townService.getTownByCountry(countryId);
    }

    @Override
    public CheckoutFormDto getNewCheckoutForm(Cart cart) {
        CheckoutFormDto checkoutFormDto = new CheckoutFormDto();

        checkoutFormDto.setAddress( new AddressDto() );
        checkoutFormDto.setPaymentMethod( PaymentMethod.DEBIT_CARD );

        User user = userService.getCurrentUser();

        checkoutFormDto.setFirstName( user.getFirstName() );
        checkoutFormDto.setLastName( user.getLastName() );

        return checkoutFormDto;
    }

    @Override
    public void fillShowCheckoutPageModelMap(ModelMap modelMap, Cart cart) {
        List<CountryDto> countries = countryService.getCountries();
        List<DeliveryDto> deliveryOptions = deliveryService.getDeliveryOptions();
        PaymentMethod[] paymentOptions = PaymentMethod.values();
        CheckoutFormDto checkoutFormDto = getNewCheckoutForm(cart);
        CheckoutCart checkoutCart = checkoutCartService.getCheckoutCart(cart);

        modelMap.put("countries", countries);
        modelMap.put("deliveryOptions", deliveryOptions);
        modelMap.put("paymentOptions", paymentOptions);
        modelMap.put("checkoutForm", checkoutFormDto);
        modelMap.put("cartDto", checkoutCart);
    }

    @Override
    public ModelAndView checkoutErrorPage(Cart cart, CheckoutFormDto checkoutFormDto) {
        ModelAndView modelAndView = new ModelAndView("/order/checkout");

        List<CountryDto> countries = countryService.getCountries();
        List<DeliveryDto> deliveryOptions = deliveryService.getDeliveryOptions();
        CheckoutCart checkoutCart = checkoutCartService.getCheckoutCart(cart);
        List<TownDto> towns = getTownsByCountryId(checkoutFormDto.getAddress().getCountryId());

        modelAndView.addObject("countries", countries);
        modelAndView.addObject("towns", towns);
        modelAndView.addObject("deliveryOptions", deliveryOptions);
        modelAndView.addObject("cartDto", checkoutCart);
        return modelAndView;
    }

}
