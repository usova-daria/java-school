package com.javaschool.domainlogic.products.checkout.validation;

import com.javaschool.domainlogic.products.cart.dto.CartItem;
import com.javaschool.domainlogic.products.checkout.service.api.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CartItemValidator implements ConstraintValidator<AvailableCartItem, CartItem> {

    @Autowired
    private CheckoutService checkoutService;

    @Override
    public void initialize(AvailableCartItem availableCartItem) { }

    @Override
    public boolean isValid(CartItem cartItem, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
