package com.javaschool.domainlogic.user.registration.validation.annotation;

import com.javaschool.domainlogic.user.registration.validation.validator.BirthdayValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BirthdayValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBirthday {

    String message() default "{birthday.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
