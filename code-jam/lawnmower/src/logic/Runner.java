package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import util.CustomFileReader;

public class Runner {

	public static void main(String[] args) throws IOException {
		FileReader f;
		BufferedReader br;

		f = new FileReader("B-large-practice.in" );
		br = new BufferedReader(f);
		CustomFileReader cfr = new CustomFileReader();
		int numberOfTestCases = cfr.readNumberOfTests(br);
		for (int i = 1; i <= numberOfTestCases; i++) {
			int[] xysize = cfr.readSizeOfField(br);
			int[][] field = cfr.readField(br,xysize[0],xysize[1]);
			GrassField fieldRep =  new GrassField(xysize[0],xysize[1]);
			String strResult = "NO";
			if (fieldRep.checkPattern(field)) {
				strResult = "YES";
			}
			System.out.println("Case #"+i+": "+strResult);				
		}

	}

}
