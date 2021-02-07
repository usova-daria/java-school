package com.javaschool.domainlogic.products.checkout.service.api;

import com.javaschool.domainlogic.products.cart.dto.CartItem;
import com.javaschool.domainlogic.products.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.products.checkout.dto.CountryDto;
import com.javaschool.domainlogic.products.checkout.dto.DeliveryDto;
import com.javaschool.domainlogic.products.checkout.dto.TownDto;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CheckoutService {

    boolean cartItemIsAvailable(CartItem cartItem);

    List<CountryDto> getCountries();

    List<TownDto> getTownsByCountryId(Integer countryId);

    void updateCart(HttpSession session);

    List<DeliveryDto> getDeliveryOptions();

    boolean cartIsEmpty(HttpSession session);

    CheckoutFormDto getNewCheckoutForm();

}
