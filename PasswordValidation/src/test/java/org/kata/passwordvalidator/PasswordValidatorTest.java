package org.kata.passwordvalidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {

    PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    void shouldThrowException_whenPasswordHasLessThan8Signs() {
        String password = "abcdef";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> passwordValidator.validatePassword(password),
                "Password must be at least 8 characters");
    }

    @Test
    void shouldThrowException_whenPasswordDoesNotHaveAtLest2Digits() {
        String password = "abc1efg";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> passwordValidator.validatePassword(password),
                "The password must contain at least 2 numbers");
    }

    @Test
    void shouldThrowException_whenPasswordDoesNotHaveAtLest2DigitsAndLessThan8Signs() {
        String password = "ac1efg";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> passwordValidator.validatePassword(password),
                "Password must be at least 8 characters.\nThe password must contain at least 2 numbers");
    }


    @Test
    void shouldThrowException_whenPasswordDoesNotAtLeastOneCapitalLetter() {
        String password = "abc1efg";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> passwordValidator.validatePassword(password),
                "Password must contain at least one capital letter");
    }

    @Test
    void shouldReturnTrue_whenPasswordHas8SignsAndAtLeast2DigitsAndOneCapitalLetterAndOneSpecialSign() {
        String password = "aBc1ef4h!";
        boolean isValid = passwordValidator.validatePassword(password);
        assertTrue(isValid);
    }

    @Test
    void shouldThrowException_whenPasswordDoesAtLeast8SignsAndAtLeast2DigitsAndOneCapitalLetterAndOneSpecialSign() {
        String password = "abc1efg";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> passwordValidator.validatePassword(password),
                "Password must contain at least one special character");
    }
}
