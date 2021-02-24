package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Daria Usova
 */
public interface CheckoutService {

    /**
     * Gets new checkout form.
     *
     * @param cart the cart
     * @return the new checkout form
     */
    CheckoutFormDto getNewCheckoutForm(Cart cart);

    /**
     * Fills show checkout page model map.
     *
     * @param modelMap the model map
     * @param cart     the cart
     */
    void fillShowCheckoutPageModelMap(ModelMap modelMap, Cart cart);

    /**
     * Creates checkout error page model and view.
     *
     * @param cart            the cart
     * @param checkoutFormDto the checkout form dto
     * @return the model and view
     */
    ModelAndView checkoutErrorPage(Cart cart, CheckoutFormDto checkoutFormDto);

}
