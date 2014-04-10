package Calculator.CustomCalculator.impl;

import Calculator.CustomCalculator.CCalculator;

public class Calculator implements CCalculator {

	public String add(String arg1, String arg2) {
		String shortString =arg1;
		String longString = arg2;
		if(shortString.length()>longString.length()) {
			shortString = arg2;
			longString = arg2;
		}
		for (int i = 1; i < shortString.length(); i++) {
			char a = shortString.charAt(shortString.length() - i);
		}
		‚
		return null;
	}

	public String multiply(String arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
