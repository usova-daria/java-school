package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public interface CheckoutService {

    CheckoutFormDto getNewCheckoutForm(Cart cart);

    void fillShowCheckoutPageModelMap(ModelMap modelMap, Cart cart);

    ModelAndView checkoutErrorPage(Cart cart, CheckoutFormDto checkoutFormDto);

}
