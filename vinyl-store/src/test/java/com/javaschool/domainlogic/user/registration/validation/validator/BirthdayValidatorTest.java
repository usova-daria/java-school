package com.javaschool.domainlogic.user.registration.validation.validator;

import com.javaschool.domainlogic.user.registration.dto.Birthday;
import org.junit.Test;
import org.mockito.Mock;

import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

/**
 * @author Daria Usova
 */
public class BirthdayValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    private final BirthdayValidator validator = new BirthdayValidator();

    @Test
    public void testValidationIsValid() {
        Birthday input = new Birthday(21, Month.MARCH, 2020);
        assertTrue(validator.isValid(input, constraintValidatorContext));
    }

    @Test
    public void testValidationNotValid() {
        Birthday input = new Birthday(30, Month.FEBRUARY, 2020);
        assertFalse(validator.isValid(input, constraintValidatorContext));
    }

}