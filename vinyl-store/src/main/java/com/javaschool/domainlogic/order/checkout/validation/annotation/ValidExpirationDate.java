package com.javaschool.domainlogic.order.checkout.validation.annotation;

import com.javaschool.domainlogic.order.checkout.validation.validator.ExpirationDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Daria Usova
 */
@Documented
@Constraint(validatedBy = ExpirationDateValidator.class)
@Target( {ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidExpirationDate {

    String message() default "{expiration.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
