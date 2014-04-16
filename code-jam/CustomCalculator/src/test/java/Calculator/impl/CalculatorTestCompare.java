package Calculator.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.CCalculator;

public class CalculatorTestCompare {

	CCalculator calc = new Calculator();
	@Test
	public void compare1with1() {
		int result = calc.compare("1","1");
	}

}
