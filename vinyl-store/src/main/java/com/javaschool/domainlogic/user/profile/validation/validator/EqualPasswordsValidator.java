package com.javaschool.domainlogic.user.profile.validation.validator;

import com.javaschool.domainlogic.user.profile.dto.password.ChangePasswordDto;
import com.javaschool.domainlogic.user.profile.validation.annotation.EqualPasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class EqualPasswordsValidator implements ConstraintValidator<EqualPasswords, ChangePasswordDto> {

    @Override
    public void initialize(EqualPasswords constraintAnnotation) {
    }

    @Override
    public boolean isValid(ChangePasswordDto changePasswordDto, ConstraintValidatorContext context) {
        if (changePasswordDto == null) {
            return false;
        }

        String newPassword = changePasswordDto.getNewPassword();
        String confirmPassword = changePasswordDto.getConfirmPassword();

        return Objects.equals(newPassword, confirmPassword);
    }

}
