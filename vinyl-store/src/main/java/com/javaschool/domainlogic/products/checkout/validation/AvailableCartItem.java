package com.javaschool.domainlogic.products.checkout.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CartItemValidator.class)
@Target( {ElementType.FIELD, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AvailableCartItem {

    String message() default "Invalid cart item";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
