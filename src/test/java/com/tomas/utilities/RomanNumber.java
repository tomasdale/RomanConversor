package com.tomas.utilities;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class RomanNumber {
    Integer numericRepresentation;
    String romanRepresentation;
    private static SortedMap<Integer, String> romansBreakepoints;
    private static SortedMap<Integer, String> calculatedNumbers;

    static {
        romansBreakepoints = new TreeMap<>(Collections.reverseOrder());
        romansBreakepoints.put(1000, "M");
        romansBreakepoints.put(900, "CM");
        romansBreakepoints.put(500, "D");
        romansBreakepoints.put(400, "CD");
        romansBreakepoints.put(100, "C");
        romansBreakepoints.put(90, "XC");
        romansBreakepoints.put(50, "L");
        romansBreakepoints.put(40, "XL");
        romansBreakepoints.put(10, "X");
        romansBreakepoints.put(9, "IX");
        romansBreakepoints.put(5, "V");
        romansBreakepoints.put(4, "IV");
        romansBreakepoints.put(1, "I");
        calculatedNumbers = new TreeMap<>(romansBreakepoints);
    }

    private static String getRomanNumberFromValue(int number) {
        String result = calculatedNumbers.get(number);
        if (result == null) {
            result = calculateRomanRepresentation(number);
            calculatedNumbers.put(number, result);
        }
        return result;
    }

    private static String calculateRomanRepresentation(int number) {
        String result = "";
        for (SortedMap.Entry<Integer, String> breakepoint : romansBreakepoints.entrySet()) {
            Integer key = breakepoint.getKey();
            String value = breakepoint.getValue();
            while (number >= key) {
                number = number - key;
                result += value;
            }
        }
        return result;
    }

    public RomanNumber(String roman) {
        romanRepresentation = roman.toUpperCase();
    }

    public RomanNumber(int number) {
        numericRepresentation = number;
        romanRepresentation = getRomanNumberFromValue(number);
    }

    public int toInteger() {
        return numericRepresentation;
    }

    @Override
    public String toString() {
        return romanRepresentation;
    }

    public static String getRoman(int number) {
        return getRomanNumberFromValue(number);
    }

}
