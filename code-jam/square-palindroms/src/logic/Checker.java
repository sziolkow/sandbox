package logic;

import java.util.HashSet;
import java.util.Set;

public class Checker {
	
	Set<String> palindronsCache = new HashSet<String>(); 

	public boolean isPalindron(String value) {
		if (value == null) {
			return false;
		}
		
		/*if(palindronsCache.contains(value)) {
			return true;
		}*/
		
		for (int i = 0; i < (value.length() / 2); i++) {
			if (value.charAt(i) != value.charAt(value.length()-i-1)) {
				return false;
			} 
		}
		//palindronsCache.add(value);
		return true;
	}
	

}
