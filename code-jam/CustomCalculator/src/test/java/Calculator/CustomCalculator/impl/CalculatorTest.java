package Calculator.CustomCalculator.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.CustomCalculator.CCalculator;

public class CalculatorTest {
	
	CCalculator calculator = new Calculator();
	
	@Test
	public void addTwoSimplyStrings() {
		String result = calculator.add("10", "10");
		assertEquals("20", result);
	}

}
