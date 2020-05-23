package com.tomas.utilities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void testRomanNumberToInteger_IntegerConstructor() {
		RomanNumber roman = new RomanNumber(3);
		assertTrue(roman.toInteger() == 3);
		roman = new RomanNumber(5);
		assertTrue(roman.toInteger() == 5);
	}

	@Test
	void testRomanNumberToString_StringConstructor(){
		RomanNumber roman = new RomanNumber("V");
		assertTrue(roman.toString() == "V");
		roman = new RomanNumber("X");
		assertTrue(roman.toString() == "X");
	}
	
	@Test
	void testRomanNumberToInteger_StringConstructor(){
		RomanNumber roman = new RomanNumber("CCIXIV");
		assertTrue(roman.toInteger() == 244);
		roman = new RomanNumber("XXXIV");
		assertTrue(roman.toInteger() == 34);
	}

	@Test
	void testRomanNumberToString_NumericConstructor(){
		RomanNumber roman = new RomanNumber(10);
		assertTrue(roman.toString().equals("X"));
		roman = new RomanNumber(129);
		assertTrue(roman.toString().equals("CXXIX"));
	}

	@Test
	void testGetRomanNumberFromIntNumber(){
		assertTrue(RomanNumber.getRoman(8).equals("VIII"));
		assertTrue(RomanNumber.getRoman(9).equals("IX"));
		assertTrue(RomanNumber.getRoman(4).equals("IV"));
	}

	@Test
	void testGetLargeRomanNumber(){
		assertTrue(RomanNumber.getRoman(745).equals("DCCXLV"));
		assertTrue(RomanNumber.getRoman(439).equals("CDXXXIX"));
		assertTrue(RomanNumber.getRoman(944).equals("CMXLIV"));
	}
}
