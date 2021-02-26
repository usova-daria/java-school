package com.javaschool.domainlogic.user.registration.validation.validator;

import com.javaschool.domainlogic.user.registration.validation.annotation.ValidPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword validPassword) {
        // Do nothing because ValidPassword annotation doesn't have any parameters
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 20),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new WhitespaceRule()
        ));

        if (password == null) {
            return false;
        }

        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }

        setUpContext(context, validator.getMessages(result));
        return false;
    }

    public void setUpContext(ConstraintValidatorContext context, List<String> messages) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
                String.join("\n", messages)
        ).addConstraintViolation();
    }

}
