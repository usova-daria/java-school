package com.javaschool.domainlogic.user.profile.validation.validator;

import com.javaschool.domainlogic.user.profile.service.api.ChangePasswordService;
import com.javaschool.domainlogic.user.profile.validation.annotation.CorrectPassword;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class CorrectPasswordValidator implements ConstraintValidator<CorrectPassword, String> {

    private final ChangePasswordService changePasswordService;

    @Override
    public void initialize(CorrectPassword constraintAnnotation) {
        // Do nothing because CorrectPassword annotation doesn't have any parameters
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return changePasswordService.isCorrectPassword(password);
    }

}
