package com.javaschool.domainlogic.user.registration.validation.validator;

import com.javaschool.domainlogic.user.registration.service.api.UserRegistrationService;
import com.javaschool.domainlogic.user.registration.validation.annotation.UserEmailUnique;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserEmailUniqueValidator implements ConstraintValidator<UserEmailUnique, String> {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Override
    public void initialize(UserEmailUnique userEmailUnique) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && !userRegistrationService.emailExists(email);
    }
}
