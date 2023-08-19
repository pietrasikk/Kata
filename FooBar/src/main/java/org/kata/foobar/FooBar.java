package org.kata.foobar;

class FooBar {
    public String fizzBuzz(int inputNumber) {
        if (inputNumber % 3 == 0 && inputNumber % 5 == 0) return "FizzBuzz";
        if (inputNumber % 5 == 0) return "Buzz";
        if (inputNumber % 3 == 0) return "Fizz";
        else return String.valueOf(inputNumber);
    }
}
