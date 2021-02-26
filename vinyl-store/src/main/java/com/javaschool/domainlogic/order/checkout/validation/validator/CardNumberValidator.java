package com.javaschool.domainlogic.order.checkout.validation.validator;

import com.javaschool.domainlogic.order.checkout.validation.annotation.ValidCardNumber;
import com.javaschool.util.LuhnAlgorithm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Daria Usova
 */
public class CardNumberValidator implements ConstraintValidator<ValidCardNumber, String> {

    @Override
    public void initialize(ValidCardNumber constraintAnnotation) {
        // Do nothing because ValidCardNumber annotation doesn't have any parameters
    }

    @Override
    public boolean isValid(String cardNumber, ConstraintValidatorContext context) {
        if (cardNumber == null) {
            return false;
        }

        return LuhnAlgorithm.cardNumberIdValid(cardNumber);
    }

}
