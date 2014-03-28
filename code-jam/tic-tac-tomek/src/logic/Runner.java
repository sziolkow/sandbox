package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import util.CustomFileReader;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		FileReader f = new FileReader("A-large-practice.in");
		BufferedReader br = new BufferedReader(f);
		
		CustomFileReader cfr =  new CustomFileReader();
		Integer numberOfTests = cfr.readNumberOfTests(br);
		Converter conv =  new Converter();
		PositionChecker checker = new PositionChecker();
		
		for (int i = 0; i < numberOfTests; i++) {
			String[][] textArray = cfr.readArray(br);
			int[][] numbers = conv.convertToXPerspektive(textArray);
			Result result1 = checker.checkGame(numbers);
			numbers = conv.convertToOPerspektive(textArray);
			Result result2 = checker.checkGame(numbers);
			Result result = calculateResults(result1, result2);
			System.out.println(result);
		}
		br.close();
		f.close();

	}

	private static Result calculateResults(Result result1, Result result2) {
		if (result1.equals(Result.DRAWN) && result2.equals(Result.DRAWN)) {
			return Result.DRAWN;
		}
		if (result1.equals(Result.WON) && result2.equals(Result.DRAWN)) {
			return Result.XWON;
		}
		if (result1.equals(Result.DRAWN) && result2.equals(Result.WON)) {
			return Result.OWON;
		}
		if (result1.equals(Result.WON) && result2.equals(Result.WON)) {
			return Result.DRAWN;
		}
		return null;
	}

}
