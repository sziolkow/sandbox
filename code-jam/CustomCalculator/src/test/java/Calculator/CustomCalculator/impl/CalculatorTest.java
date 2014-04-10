package Calculator.CustomCalculator.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.CustomCalculator.CCalculator;

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

}
