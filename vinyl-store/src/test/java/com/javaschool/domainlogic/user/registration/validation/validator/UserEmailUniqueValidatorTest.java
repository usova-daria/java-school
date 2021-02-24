package com.javaschool.domainlogic.user.registration.validation.validator;

import com.javaschool.domainlogic.user.registration.service.api.UserRegistrationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.*;

/**
 * @author Daria Usova
 */
@RunWith(MockitoJUnitRunner.class)
public class UserEmailUniqueValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @Mock
    private UserRegistrationService userRegistrationService;

    @InjectMocks
    private UserEmailUniqueValidator validator;

    private final String nonExistingEmail = "non@existing.email";
    private final String existingEmail = "existing@email.com";

    public UserEmailUniqueValidatorTest() {
    }

    @Before
    public void setUp() {
        defineMocks();
    }

    private void defineMocks() {
        Mockito.when(userRegistrationService.emailExists(nonExistingEmail))
                .thenReturn(false);

        Mockito.when(userRegistrationService.emailExists(existingEmail))
                .thenReturn(true);
    }

    @Test
    public void testValidEmail() {
        assertFalse(validator.isValid(existingEmail, constraintValidatorContext));
    }

    @Test
    public void testNotValidEmail1() {
        assertTrue(validator.isValid(nonExistingEmail, constraintValidatorContext));
    }

    @Test
    public void testNotValidEmail2() {
        assertFalse(validator.isValid(null, constraintValidatorContext));
    }

}