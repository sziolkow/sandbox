package Calculator.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.CCalculator;

public class CalculatorTestDivide {

	CCalculator calculator = new Calculator();
	
	@Test
	public void divide2by1() {
		String result =calculator.divide("2","1");
		assertEquals("2", result);
	}

	@Test
	public void divide20by5() {
		String result =calculator.divide("20","5");
		assertEquals("4", result);
	}

	@Test
	public void divide2000by5() {
		String result =calculator.divide("2000","5");
		assertEquals("400", result);
	}	

	@Test
	public void divide7by2() {
		String result =calculator.divide("7","2");
		assertEquals("3", result);
	}
	
	@Test
	public void divide100by10() {
		String result =calculator.divide("100","10");
		assertEquals("10", result);
	}
	
	@Test
	public void divide174by174() {
		String result =calculator.divide("174","174");
		assertEquals("1", result);
	}
}
