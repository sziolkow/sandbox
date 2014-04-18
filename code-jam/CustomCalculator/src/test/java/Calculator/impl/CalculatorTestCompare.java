package Calculator.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.CCalculator;

public class CalculatorTestCompare {

	CCalculator calc = new Calculator();
	@Test
	public void compare1with1() {
		int result = calc.compare("1","1");
		assertEquals(0, result);
	}
	
	@Test
	public void compare2with1() {
		int result = calc.compare("2","1");
		assertEquals(1, result);
	}	

	@Test
	public void compare1with2() {
		int result = calc.compare("1","2");
		assertEquals(2, result);
	}
	
	@Test
	public void compare20with10() {
		int result = calc.compare("20","10");
		assertEquals(1, result);
	}	

	@Test
	public void compare10with20() {
		int result = calc.compare("10","20");
		assertEquals(2, result);
	}

	@Test
	public void compare999with999() {
		int result = calc.compare("999","999");
		assertEquals(0, result);
	}	
}
