package com.tomas.utilities.Entities;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class RomanNumber {
    Integer numericRepresentation;
    String romanRepresentation;
    private static SortedMap<Integer, String> romansBreakepoints;

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
    }

    private static String getRomanNumberFromInteger(Integer number) {
        String result = "";
        for (SortedMap.Entry<Integer, String> breakepoint : romansBreakepoints.entrySet()) {
            Integer key = breakepoint.getKey();
            String romanNumber = breakepoint.getValue();
            while (number >= key) {
                number = number - key;
                result += romanNumber;
            }
        }
        return result;
    }

    public RomanNumber(String roman) {
        romanRepresentation = roman.toUpperCase();
    }

    public RomanNumber(int number) {
        numericRepresentation = number;
        romanRepresentation = getRomanNumberFromInteger(number);
    }

    public int toInteger() {
        return numericRepresentation;
    }

    @Override
    public String toString() {
        return romanRepresentation;
    }

    public static String getRoman(int number) {
        return getRomanNumberFromInteger(number);
    }

}
