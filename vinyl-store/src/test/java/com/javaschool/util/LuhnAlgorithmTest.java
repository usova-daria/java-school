package com.javaschool.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author Daria Usova
 */
@RunWith(Parameterized.class)
public class LuhnAlgorithmTest {

    private String cardNumber;
    private boolean isValid;

    public LuhnAlgorithmTest(String cardNumber, boolean isValid) {
        this.cardNumber = cardNumber;
        this.isValid = isValid;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                { "4485430177898652", true },
                { "4485430177898653", false },
                { "4929247801775866668", true },
                { "4929247801775866667", false }
        });
    }

    @Test
    public void cardNumberIdValid() {
        assertEquals(isValid, LuhnAlgorithm.cardNumberIdValid(cardNumber));
    }
}