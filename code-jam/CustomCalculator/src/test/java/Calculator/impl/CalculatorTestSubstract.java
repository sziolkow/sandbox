package Calculator.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.CCalculator;

public class CalculatorTestSubstract {

	CCalculator calculator = new Calculator();
	
	@Test
	public void substract2and2() {
		String result = calculator.substract("2","2");
		assertEquals("0",result);
	}

	@Test
	public void substract200and100() {
		String result = calculator.substract("200","100");
		assertEquals("100",result);
	}
	
	@Test
	public void substract100and100() {
		String result = calculator.substract("100","100");
		assertEquals("0",result);
	}
	
	@Test
	public void substract20and9() {
		String result = calculator.substract("29","9");
		assertEquals("20",result);
	}	

	@Test
	public void substract25and8() {
		String result = calculator.substract("25","8");
		assertEquals("17",result);
	}
	
	@Test
	public void substract125and99() {
		String result = calculator.substract("125","99");
		assertEquals("26",result);
	}	
}
