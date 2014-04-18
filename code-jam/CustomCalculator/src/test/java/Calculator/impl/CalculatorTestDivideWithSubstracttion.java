package Calculator.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.CCalculator;

public class CalculatorTestDivideWithSubstracttion {
	CCalculator calculator = new Calculator();
	
	@Test
	public void divide2by2() {
		String result = calculator.divideWithSubstracttion("2", "2");
		assertEquals("1", result);
	}

	@Test
	public void divide500by2() {
		String result = calculator.divideWithSubstracttion("500", "2");
		assertEquals("250", result);
	}	
}
