package com.javaschool.domainlogic.order.checkout.validation.validator;

import com.javaschool.domainlogic.order.checkout.validation.annotation.ValidExpirationDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * @author Daria Usova
 */
public class ExpirationDateValidator implements ConstraintValidator<ValidExpirationDate, String> {

    @Override
    public void initialize(ValidExpirationDate constraintAnnotation) {
        // Do nothing because ValidExpirationDate annotation doesn't have any parameters
    }

    @Override
    public boolean isValid(String expirationDate, ConstraintValidatorContext context) {
        if (expirationDate == null) return true;

        String[] monthAndYear = expirationDate.split("/");

        int month = Integer.parseInt(monthAndYear[0]);
        int thisMonth = LocalDate.now().getMonthValue();
        if (month < 1 || month > 12) return false;

        int year = Integer.parseInt(monthAndYear[1]);
        int thisYear = LocalDate.now().getYear() % 100;
        if (year < thisYear) return false;

        return !(year == thisYear && month < thisMonth);
    }
}
