package org.kata.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String DOT = ".";
    private static final String COMMA = ",";
    private static final String SPLIT_DOT = "\\.";
    private static final String NEW_LINE = "\n";

    public float add(String... numbers) {
        List<String> list = convertArrayToList(numbers);
        String delimiter = list.get(0);
        float result = 0;
        try {
            Float.parseFloat(getReplace(delimiter));
            result = calculate(result, list);
        } catch (NumberFormatException exception) {
            String values = list.get(1);
            result = calculate(result, List.of(values.split(delimiter)));
        }
        return result;
    }

    private static List<String> convertArrayToList(String[] numbers) {
        List<String> list = new ArrayList<>();
        for (String number : numbers) {
            String[] split = number.split(NEW_LINE);
            list.addAll(List.of(split));
        }
        return list;
    }

    private static float calculate(float result, List<String> list) {
        for (String number : list) {
            String stringNumber = getReplace(number);
            if (checkIfNumberIsNullAndBlank(stringNumber)) continue;
            checkIfNumberIsValid(stringNumber);
            float parsedNumber = parseNumber(stringNumber);
            if (parsedNumber > 1000) continue;
            result += parsedNumber;
        }
        return result;
    }

    private static float parseNumber(String string) {
        float number = Float.parseFloat(string);
        if (number < 0) throw new IllegalArgumentException("Negative number(s) not allowed");
        return number;
    }

    private static void checkIfNumberIsValid(String string) {
        if (string.contains(DOT) && (splitByDot(string).length == 1))
            throw new IllegalArgumentException();
    }

    private static String[] splitByDot(String string) {
        return string.split(SPLIT_DOT);
    }

    private static boolean checkIfNumberIsNullAndBlank(String string) {
        return string != null && string.isBlank();
    }

    private static String getReplace(String string) {
        return string.replace(COMMA, DOT);
    }
}
