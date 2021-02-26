package com.javaschool.domainlogic.order.checkout.validation.annotation;

import com.javaschool.domainlogic.order.checkout.validation.validator.CardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Daria Usova
 */
@Documented
@Constraint(validatedBy = CardNumberValidator.class)
@Target( {ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCardNumber {

    String message() default "{card.number.wrong}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
