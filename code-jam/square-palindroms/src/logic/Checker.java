package logic;

public class Checker {

	public boolean isPalindron(Integer value) {
		if (value == null) {
			return false;
		}
		
		String strValue = value.toString();
		for (int i = 0; i < (strValue.length() / 2); i++) {
			if (strValue.charAt(i) != strValue.charAt(strValue.length()-i-1)) {
				return false;
			} 
		}
		return true;
	}

}
