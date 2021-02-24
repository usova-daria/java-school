package com.javaschool.domainlogic.user.registration.validation.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Daria Usova
 */
@RunWith(Parameterized.class)
public class PasswordConstraintValidatorTest {

    @Mock
    private ConstraintValidatorContext context;
    private PasswordConstraintValidator validator;

    private final boolean expected;
    private final String input;

    @Before
    public void setUp() {
        validator = spy(PasswordConstraintValidator.class);
        doNothing().when(validator).setUpContext(eq(context), anyList());
    }

    public PasswordConstraintValidatorTest(String input, boolean expected) {
        this.expected = expected;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                { "123A", false },
                { "123-Password-too-long", false },
                { "no-uppercase-123", false },
                { "Password-no-digits", false },
                { "1Password with-space", false },
                { "1Password with-space", false },
                { "35-Java-school", true }
        });
    }

    @Test
    public void testValidation() {
        assertEquals(expected, validator.isValid(input, context));
    }

}