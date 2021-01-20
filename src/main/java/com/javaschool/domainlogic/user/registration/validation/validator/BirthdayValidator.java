package com.javaschool.domainlogic.user.registration.validation.validator;

import com.javaschool.domainlogic.user.registration.dto.Birthday;
import com.javaschool.domainlogic.user.registration.validation.annotation.ValidBirthday;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.DateTimeException;
import java.time.LocalDate;

public class BirthdayValidator implements ConstraintValidator<ValidBirthday, Birthday> {

    @Override
    public void initialize(ValidBirthday validBirthday) {
    }

    @Override
    public boolean isValid(Birthday birthday, ConstraintValidatorContext constraintValidatorContext) {
        try {
            LocalDate.of(birthday.getYear(), birthday.getMonth(), birthday.getDay());
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
}
