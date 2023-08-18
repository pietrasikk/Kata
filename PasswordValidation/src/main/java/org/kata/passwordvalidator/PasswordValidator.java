package org.kata.passwordvalidator;

public class PasswordValidator {

    public boolean validatePassword(String password) {
        boolean hasEightCharacters = false;
        boolean hasAtLeastTwoDigits = false;
        boolean hasAtLeastOneCapitalLetter = false;
        boolean hasAtLeastOneSpecialSign = false;
        if (password.length() >= 8) hasEightCharacters = true;
        char[] chars = password.toCharArray();
        hasAtLeastTwoDigits = areTwoDigitsInPassword(hasAtLeastTwoDigits, chars);
        hasAtLeastOneCapitalLetter = isCapitalLetterInPassword(hasAtLeastOneCapitalLetter, chars);
        hasAtLeastOneSpecialSign = isHasAtLeastOneSpecialSign(hasAtLeastOneSpecialSign, chars);

        if (!hasEightCharacters && !hasAtLeastTwoDigits)
            throw new IllegalArgumentException("Password must be at least 8 characters.\nThe password must contain at least 2 numbers");
        if (!hasEightCharacters)
            throw new IllegalArgumentException("Password must be at least 8 characters");
        if (!hasAtLeastTwoDigits)
            throw new IllegalArgumentException("The password must contain at least 2 numbers");
        if (!hasAtLeastOneCapitalLetter)
            throw new IllegalArgumentException("Password must contain at least one capital letter");
        if (!hasAtLeastOneSpecialSign)
            throw new IllegalArgumentException("Password must contain at least one special character");

        return true;
    }

    private static boolean isHasAtLeastOneSpecialSign(boolean hasAtLeastOneSpecialSign, char[] chars) {
        for (char sign : chars) {
            if (!Character.isAlphabetic(sign) && !Character.isDigit(sign)) hasAtLeastOneSpecialSign = true;
        }
        return hasAtLeastOneSpecialSign;
    }

    private static boolean areTwoDigitsInPassword(boolean hasAtLeastTwoDigits, char[] chars) {
        int digits = 0;
        for (char sign : chars) {
            if (Character.isDigit(sign)) digits++;
        }
        if (digits >= 2) hasAtLeastTwoDigits = true;
        return hasAtLeastTwoDigits;
    }

    private static boolean isCapitalLetterInPassword(boolean hasAtLeastOneCapitalLetter, char[] chars) {
        for (char sign : chars) {
            if (Character.isUpperCase(sign)) hasAtLeastOneCapitalLetter = true;
        }
        return hasAtLeastOneCapitalLetter;
    }
}
