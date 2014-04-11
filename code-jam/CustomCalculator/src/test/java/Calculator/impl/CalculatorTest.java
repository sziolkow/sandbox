package Calculator.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.CCalculator;

public class CalculatorTest {

	CCalculator calculator = new Calculator();

	@Test
	public void addTwoStringsSameLength() {
		String result = calculator.add("410", "310");
		System.out.println(result);
		assertEquals("720", result);
	}

	@Test
	public void addTwoStringsDifferentLength() {
		String result = calculator.add("1310", "310");
		System.out.println(result);
		assertEquals("1620", result);
	}

	@Test
	public void addTwoStringsSameLengthwithTransposition() {
		String result = calculator.add("450", "350");
		System.out.println(result);
		assertEquals("800", result);
	}

	@Test
	public void addTwoStringsDifferentLengthwithTransposition() {
		String result = calculator.add("1450", "350");
		System.out.println(result);
		assertEquals("1800", result);
	}

	@Test
	public void multiplyBasicNumbers() {
		String result = calculator.multiply("4", "3");
		System.out.println(result);
		assertEquals("12", result);		
	}

	@Test
	public void multiply21x1() {
		String result = calculator.multiply("21", "1");
		System.out.println(result);
		assertEquals("21", result);		
	}
	
	@Test
	public void multiply999x9() {
		String result = calculator.multiply("999", "9");
		System.out.println(result);
		assertEquals("8991", result);		
	}

	@Test
	public void multiply12x12() {
		String result = calculator.multiply("12", "12");
		System.out.println(result);
		assertEquals("144", result);		
	}

}
