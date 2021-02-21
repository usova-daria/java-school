package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.order.checkout.dto.TownDto;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface CheckoutService {

    List<TownDto> getTownsByCountryId(Integer countryId);

    CheckoutFormDto getNewCheckoutForm(Cart cart);

    void fillShowCheckoutPageModelMap(ModelMap modelMap, Cart cart);

    ModelAndView checkoutErrorPage(Cart cart, CheckoutFormDto checkoutFormDto);

}
