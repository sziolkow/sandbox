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
		
		if (transposition >0) {
			result.append(transposition);
		}
		
		for (int j = 1; j <=( longString.length() - shortString.length()); j++) {
			char a = longString.charAt(longString.length() - shortString.length() - j);
			result.append(a);
		}

		result = result.reverse(); 

		return result.toString();
	}

	@Override
	public String multiply(String arg1, String arg2) {
		String shortString = arg1;
		String longString = arg2;
		if (shortString.length() > longString.length()) {
			shortString = arg2;
			longString = arg1;
		}		
		StringBuffer resultInnerLoop = new StringBuffer();
		StringBuffer resultOutterLoop = new StringBuffer("0");
		int innerPartResult;
		int transposition = 0;
		
		String newResult;
		
		
		for (int i = 1; i <= shortString.length(); i++) {
			char a = shortString.charAt(shortString.length() - i);
			resultInnerLoop = new StringBuffer();
			
			for (int j = 1; j <= longString.length(); j++) {
				char b = longString.charAt(longString.length() - j);
				innerPartResult = Character.getNumericValue(a)
						* Character.getNumericValue(b)+transposition;
				transposition = 0;
				if(innerPartResult >= 10) {
					transposition = innerPartResult / 10 ;
					innerPartResult = innerPartResult - (transposition * 10);
				}
				resultInnerLoop.append(innerPartResult);				
			}
			if (transposition>0) {
				resultInnerLoop.append(transposition);
			}
			
			resultInnerLoop = resultInnerLoop.reverse();
			for (int j = 1; j < i; j++) {
				resultInnerLoop.append("0");
			} 
			resultOutterLoop = new StringBuffer( add(resultOutterLoop.toString(), resultInnerLoop.toString()));
		}
		return resultOutterLoop.toString();
	}

}
