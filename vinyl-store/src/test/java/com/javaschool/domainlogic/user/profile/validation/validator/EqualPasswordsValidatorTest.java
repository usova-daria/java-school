package com.javaschool.domainlogic.user.profile.validation.validator;

import com.javaschool.domainlogic.user.profile.dto.password.ChangePasswordDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.*;

/**
 * @author Daria Usova
 */
public class EqualPasswordsValidatorTest {

    @Mock
    private ConstraintValidatorContext context;

    private final EqualPasswordsValidator validator = new EqualPasswordsValidator();

    private ChangePasswordDto valid;
    private ChangePasswordDto invalid;

    @Before
    public void setUp() {
        valid = new ChangePasswordDto();
        valid.setNewPassword("new password");
        valid.setConfirmPassword("new password");

        invalid = new ChangePasswordDto();
        invalid.setNewPassword("new password");
        invalid.setConfirmPassword("different password");
    }

    @Test
    public void testValidation1() {
        assertFalse(validator.isValid(null, context));
    }

    @Test
    public void testValidation2() {
        assertTrue(validator.isValid(valid, context));
    }

    @Test
    public void testValidation3() {
        assertFalse(validator.isValid(invalid, context));
    }


}