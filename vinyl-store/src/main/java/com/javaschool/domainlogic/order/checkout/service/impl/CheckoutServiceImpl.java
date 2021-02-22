package com.javaschool.domainlogic.order.checkout.service.impl;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.*;
import com.javaschool.domainlogic.order.checkout.mapper.api.UserAddressDtoMapper;
import com.javaschool.domainlogic.order.checkout.service.api.*;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.order.enumeration.PaymentMethod;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CountryService countryService;
    private final TownService townService;
    private final DeliveryService deliveryService;
    private final UserService userService;
    private final CheckoutCartService checkoutCartService;
    private final UserAddressDtoMapper userAddressDtoMapper;

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
    @Transactional(readOnly = true)
    public void fillShowCheckoutPageModelMap(ModelMap modelMap, Cart cart) {
        List<CountryDto> countries = countryService.getCountries();
        List<DeliveryDto> deliveryOptions = deliveryService.getDeliveryOptions();
        PaymentMethod[] paymentOptions = PaymentMethod.values();
        CheckoutFormDto checkoutFormDto = getNewCheckoutForm(cart);
        CheckoutCart checkoutCart = checkoutCartService.getCheckoutCart(cart);
        List<UserAddressDto> addresses = getUserAddresses();

        modelMap.put("countries", countries);
        modelMap.put("deliveryOptions", deliveryOptions);
        modelMap.put("paymentOptions", paymentOptions);
        modelMap.put("checkoutForm", checkoutFormDto);
        modelMap.put("cartDto", checkoutCart);
        modelMap.put("addresses", addresses);
    }

    public List<UserAddressDto> getUserAddresses() {
        List<Address> addresses = userService.getAddressesOfCurrentUser();
        return userAddressDtoMapper.toDtoList(addresses);
    }

    @Override
    public ModelAndView checkoutErrorPage(Cart cart, CheckoutFormDto checkoutFormDto) {
        ModelAndView modelAndView = new ModelAndView("/order/checkout");

        List<CountryDto> countries = countryService.getCountries();
        List<DeliveryDto> deliveryOptions = deliveryService.getDeliveryOptions();
        CheckoutCart checkoutCart = checkoutCartService.getCheckoutCart(cart);
        List<TownDto> towns = townService.getTownByCountry(checkoutFormDto.getAddress().getCountryId());

        modelAndView.addObject("countries", countries);
        modelAndView.addObject("towns", towns);
        modelAndView.addObject("deliveryOptions", deliveryOptions);
        modelAndView.addObject("cartDto", checkoutCart);
        return modelAndView;
    }

}
