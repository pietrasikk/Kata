package org.kata.foobar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FooBarTest {
    FooBar fooBar = new FooBar();

    @Test
    void fizzBuzz_Test() {
        int inputNumber = 2;
        String expected = "2";
        String fizzBuzz = fooBar.fizzBuzz(inputNumber);
        assertEquals(fizzBuzz, expected);
    }

    @Test
    void fizzBuzz_Fizz_Test() {
        int inputNumber = 6;
        String expected = "Fizz";
        String fizzBuzz = fooBar.fizzBuzz(inputNumber);
        assertEquals(fizzBuzz, expected);
    }

    @Test
    void fizzBuzz_Buzz_Test() {
        int inputNumber = 10;
        String expected = "Buzz";
        String fizzBuzz = fooBar.fizzBuzz(inputNumber);
        assertEquals(fizzBuzz, expected);
    }

    @Test
    void fizzBuzz_FizzBuzz_Test() {
        int inputNumber = 15;
        String expected = "FizzBuzz";
        String fizzBuzz = fooBar.fizzBuzz(inputNumber);
        assertEquals(fizzBuzz, expected);
    }
}
