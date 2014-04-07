package checker;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Checker;

public class CheckerTest {
	
	@Test
	public void isPalindromForPalindronEvenLength() {
		Checker checker = new Checker();
		assertTrue(checker.isPalindron("112211"));
	}

	@Test
	public void isPalindromForPalindronOddLength() {
		Checker checker = new Checker();
		assertTrue(checker.isPalindron("1125211"));
	}
	
	@Test
	public void isPalindromForNonPalindronEvenLength() {
		Checker checker = new Checker();
		assertFalse(checker.isPalindron("11221166"));
	}

	@Test
	public void isPalindromForNonPalindronOddLength() {
		Checker checker = new Checker();
		assertFalse(checker.isPalindron("11252116"));
	}	
}
