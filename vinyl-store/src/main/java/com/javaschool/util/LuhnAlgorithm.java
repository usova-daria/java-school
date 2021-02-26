package com.javaschool.util;

/**
 * @author Daria Usova
 */
public class LuhnAlgorithm {

    private LuhnAlgorithm() {}

    /**
     * Generates check digit int.
     *
     * @param input the input
     * @return the int
     */
    public static int generateCheckDigit(String input) {
        int[] cardNumbers = new int[input.length()];
        for (int i = 0; i < cardNumbers.length; i++) {
            cardNumbers[i] = Integer.parseInt(input.charAt(i) + "");
        }

        // multiply odd digits by 2
        for (int i = cardNumbers.length - 1; i >= 0; i = i - 2) {
            int n = cardNumbers[i];
            cardNumbers[i] = n * 2;
        }

        // subtract 9 to numbers over 9
        for (int i = 0; i < cardNumbers.length; i++) {
            int n = cardNumbers[i];
            if (n > 9) {
                cardNumbers[i] = n - 9;
            }
        }

        // add all numbers
        int sum = 0;
        for (int cardNumber : cardNumbers) {
            sum += cardNumber;
        }

        if (sum % 10 == 0) {
            return 0;
        }

        return 10 - sum % 10;
    }

    /**
     * Checks if card number is valid.
     *
     * @param number the number
     * @return the boolean
     */
    public static boolean cardNumberIdValid(String number) {
        String trimmedString = number.trim();
        int checkDigit = generateCheckDigit(trimmedString
                .substring(0, trimmedString.length() - 1));
        System.out.println(checkDigit);

        return checkDigit == Integer.parseInt("" +
                trimmedString.charAt(trimmedString.length() - 1));
    }

}
