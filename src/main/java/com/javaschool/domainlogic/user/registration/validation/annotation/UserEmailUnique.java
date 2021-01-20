package com.javaschool.domainlogic.user.registration.validation.annotation;

import com.javaschool.domainlogic.user.registration.validation.validator.UserEmailUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserEmailUniqueValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserEmailUnique {

    String message() default "{email.unique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
