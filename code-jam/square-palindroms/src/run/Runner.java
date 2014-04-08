package run;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import logic.Checker;
import util.CustomFileReader;

public class Runner {

	static Set<String> squarePalindronsCache = new HashSet<String>();
	
	/**
	 * Main 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		FileReader f = new FileReader("src/res/C-large-practice-2.in" );
		BufferedReader br = new BufferedReader(f);
		
		CustomFileReader cfr =  new CustomFileReader();
		Integer numberOfTests = cfr.readNumberOfTests(br);
		Checker checker = new Checker();
		for (int i = 0; i < numberOfTests; i++) {
			int numberOfPrimesAndSquarPrimes = 0;
			List<String> values = cfr.readRow(br);

			long fromVal = new Long(values.get(0));
			long sqrtFromVal = (long) Math.sqrt(fromVal);
			
			long toVal = new Long(values.get(1));
			long sqrtToVal = (long) Math.sqrt(toVal);
			
			for (long j = sqrtFromVal; j <= sqrtToVal; j++) {
				String candidat = ""+j;
				/*if (squarePalindronsCache.contains(candidat)) {
					numberOfPrimesAndSquarPrimes ++;
					continue;
				}*/
				if (checker.isPalindron(candidat)) {
					long result = j*j;
					
					if((result>=fromVal) && checker.isPalindron(""+result)) {
						numberOfPrimesAndSquarPrimes ++;
						squarePalindronsCache.add(""+result);
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+numberOfPrimesAndSquarPrimes);
		}
		br.close();
		f.close();

	}

	
}
