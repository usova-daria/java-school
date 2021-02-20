package com.javaschool.domainlogic.user.profile.validation.validator;

import com.javaschool.domainlogic.user.profile.service.api.ChangePasswordService;
import com.javaschool.domainlogic.user.profile.validation.annotation.CorrectPassword;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectPasswordValidator implements ConstraintValidator<CorrectPassword, String> {

    @Autowired
    private ChangePasswordService changePasswordService;

    @Override
    public void initialize(CorrectPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return changePasswordService.isCorrectPassword(password);
    }

}
