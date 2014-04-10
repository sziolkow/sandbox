package Calculator.impl;

import Calculator.CCalculator;

public class Calculator implements CCalculator {

	@Override
	public String add(String arg1, String arg2) {
		String shortString = arg1;
		String longString = arg2;
		if (shortString.length() > longString.length()) {
			shortString = arg2;
			longString = arg1;
		}

		StringBuffer result = new StringBuffer();
		int transposition = 0;
		for (int i = 1; i <= shortString.length(); i++) {
			char a = shortString.charAt(shortString.length() - i);
			char b = longString.charAt(longString.length() - i);
			int partResult = Character.getNumericValue(a)
					+ Character.getNumericValue(b) + transposition;
			transposition = 0;
			if (partResult >= 10) {
				partResult = partResult - 10;
				transposition = 1;
			}

			result.append(partResult);
		}

		if (longString.length() - shortString.length() > 0) {
			result.append(longString.subSequence(0, longString.length()
					- shortString.length()));
		}

		return result.reverse().toString();
	}

	@Override
	public String multiply(String arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
