package com.javaschool.domainlogic.user.registration.validation.validator;

import com.javaschool.domainlogic.user.registration.service.api.UserRegistrationService;
import com.javaschool.domainlogic.user.registration.validation.annotation.UserEmailUnique;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UserEmailUniqueValidator implements ConstraintValidator<UserEmailUnique, String> {

    private final UserRegistrationService userRegistrationService;

    @Override
    public void initialize(UserEmailUnique userEmailUnique) {
        // Do nothing because UserEmailUnique annotation doesn't have any parameters
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && !userRegistrationService.emailExists(email);
    }
}
