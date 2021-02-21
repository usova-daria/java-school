package com.javaschool.domainlogic.products.checkout.service.api;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.products.checkout.dto.CountryDto;
import com.javaschool.domainlogic.products.checkout.dto.DeliveryDto;
import com.javaschool.domainlogic.products.checkout.dto.TownDto;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public interface CheckoutService {

    List<TownDto> getTownsByCountryId(Integer countryId);

    CheckoutFormDto getNewCheckoutForm(Cart cart);

    void fillShowCheckoutPageModelMap(ModelMap modelMap, Cart cart);

    ModelAndView checkoutErrorPage(Cart cart, CheckoutFormDto checkoutFormDto);

}
