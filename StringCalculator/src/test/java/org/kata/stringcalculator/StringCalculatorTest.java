package org.kata.stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void shouldReturnFloatNumber_whenPassTwoStringNumbers() {
        String firstNumber = "1";
        String secondNumber = "1,2";
        float expectedNumber = 2.2f;
        float number = stringCalculator.add(firstNumber, secondNumber);
        assertEquals(number, expectedNumber);
    }

    @Test
    void shouldReturnZero_whenPassEmptyStrings() {
        String firstNumber = "";
        String secondNumber = "";
        float expectedNumber = 0;
        float number = stringCalculator.add(firstNumber, secondNumber);
        assertEquals(number, expectedNumber);
    }

    @Test
    void shouldReturnFloatNumber_whenPassManyStringNumbers() {
        String firstNumber = "2";
        String secondNumber = "3,5";
        String thirdNumber = "4,5";
        float expectedNumber = 10f;
        float number = stringCalculator.add(firstNumber, secondNumber, thirdNumber);
        assertEquals(number, expectedNumber);
    }

    @Test
    void shouldReturnFloatNumber_whenPassManyStringNumbersSeparateByNewLine() {
        String numbers = "1,2\n3\n4";
        float expectedNumber = 8.2f;
        float number = stringCalculator.add(numbers);
        assertEquals(number, expectedNumber);
    }

    @Test
    void shouldThrowException_whenPassCommaSeparatorAfterNumber() {
        String numbers = "1,2\n3,\n4";
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(numbers));
    }

    @Test
    void shouldReturnFloatNumber_whenPassManyStringNumbersAndPipeDelimiter() {
        String numbers = "\\|\n1|3";
        float expectedNumber = 4;
        float number = stringCalculator.add(numbers);
        assertEquals(number, expectedNumber);

        String anotherNumbers = "\\|\n1|2|3";
        float anotherExpectedNumber = 6;
        float result = stringCalculator.add(anotherNumbers);
        assertEquals(result, anotherExpectedNumber);
    }

    @Test
    void shouldReturnFloatNumber_whenPassManyStringNumbersAndSepDelimiter() {
        String numbers = "sep\n2sep5";
        float expectedNumber = 7;
        float number = stringCalculator.add(numbers);
        assertEquals(number, expectedNumber);
    }

    @Test
    void shouldThrowException_whenPassNegativeNumber() {
        String numbers = "1,2\n-3\n4";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add(numbers),
                "Negative number(s) not allowed");
    }

    @Test
    void shouldThrowException_whenPassNegativeNumbers() {
        String numbers = "1,2\n-3\n-4";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add(numbers),
                "Negative number(s) not allowed");
    }

    @Test
    void shouldReturnFloatNumberWithIgnoredValue_whenPassNumberGreaterThan1000() {
        String numbers = "2\n6\n1001";
        float expectedNumber = 8;
        float number = stringCalculator.add(numbers);
        assertEquals(number, expectedNumber);
    }
}
