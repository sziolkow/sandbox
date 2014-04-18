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
		char a='0';
		char b='0';
	
		for (int i = 1; i <= longString.length(); i++) {
			a='0';
			if ((shortString.length() - i)>=0) {
			   a = shortString.charAt(shortString.length() - i);
			}
			b = longString.charAt(longString.length() - i);
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

		return result.reverse().toString(); 
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

	@Override
	public String substract(String arg1, String arg2) {
		StringBuffer result = new StringBuffer();
		char number1, number2;
		byte transposition = 0;
		for (int i = 1; i <= arg1.length(); i++) {
			number2 = '0';
			if(arg2.length()-i>=0) { 
				number2 = arg2.charAt(arg2.length() - i);
			}
			number1 = arg1.charAt(arg1.length() - i);
			
			int sub = Character.getNumericValue(number1)
					- Character.getNumericValue(number2) - transposition;
			
			transposition = 0;
			if (sub < 0) {
				sub = sub +10;
				transposition = 1;
			} 
			result.append(sub);
		}
		String resultAsStr = deleteLeadingNulls(result.reverse().toString());
		
		return resultAsStr;
	}

	private String deleteLeadingNulls(String arg1) {
		StringBuffer result = new StringBuffer();
		int index = 0;
		int number;
		do {
			number = Character.getNumericValue(arg1.charAt(index));
			index ++;
		} while ((number == 0) && (index < arg1.length()));
		result.append(arg1.substring(index-1));
		return result.toString();
	}

	@Override
	public String divide(String arg1, String arg2) {
		int divider = Integer.valueOf(arg2); 
		StringBuffer buf = new StringBuffer();
		int rest = 0; 
		for(int i = 0; i<arg1.length(); i++) {
			int number = 10*rest + Character.getNumericValue(arg1.charAt(i));
			int divRes = number/divider;
			rest = number - (divRes*divider);
			buf.append(divRes);
		}
		return deleteLeadingNulls(buf.toString());
	}

	@Override
	public int compare(String arg1, String arg2) {
		if (arg1.length() != arg2.length()) {
			if (arg1.length() > arg2.length()) {
				return 1;
			}
			return 2;
		}
		if (arg1.compareTo(arg2)==0) {
			return 0;
		}
		for (int i = 0; i < arg1.length(); i++) {
			int a1 =Character.getNumericValue(arg1.charAt(i));
			int a2 =Character.getNumericValue(arg2.charAt(i));
			if (a1 != a2) {
				if (a1 > a2) {
					return 1;
				}
				return 2;
			}
		}
		return 0;
	}

	@Override
	public String divideWithSubstracttion(String arg1, String arg2) {
		// Result = m*arg1 + q
		String q = arg1;
		String m = "0";
		while(compare(q,"0")==1) {
			q = substract(q,arg2);
			m = add(m,"1");			
		}		
		return m;
	}

}
