import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CookieClicker {
	
	
	public static void main(String[] args) throws IOException {
		FileReader f = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(f);

		FileWriter g = new FileWriter(args[1]);

		BufferedWriter bwr = new BufferedWriter(g);

		int numberOfTests = readLineAsInt(br);

		for (int i = 0; i < numberOfTests; i++) {
			
			double[] row = createRow(br);
			double c=row[0];
			double ff=row[1];
			double x=row[2];
			double timeToWin = x/2;
			timeToWin = optimize(timeToWin,c,ff,x);
			String msg = String.format("%.7f", timeToWin);		
			//System.out.println("Case #"+(i+1)+": "+msg);
			bwr.write("Case #"+(i+1)+": "+msg);
			if((i+1)<numberOfTests) {
				bwr.newLine();
			}			
		}

		bwr.close();
		g.close();
		br.close();
		f.close();

	}

	private static double optimize(double timeToWin, double c, double ff,
			double x) {
		double oldTime = timeToWin;
		double restCookies = 0;
		double time = timeToWin;
		for (int i = 0; i < x/c; i++) {
			double timeToBuyAnother = 0;
			double cookies = 2;		
			for (int j=1; j<=i; j++) {
				timeToBuyAnother = timeToBuyAnother + c/cookies;
				cookies = cookies +ff;
				time = timeToBuyAnother + x/cookies;
			}
			if(oldTime<time) {
				return oldTime;
			}
			oldTime = time;
		}
		return time;
	}

	private static int readLineAsInt(BufferedReader br) throws IOException {
		String firstLine = br.readLine();
		return new Integer(firstLine);
	}


	private static double[] createRow(BufferedReader br) throws IOException {
		String row = br.readLine(); 
		double[] retValue = new double[3];
		String[] elements = row.split(" ");
		int i = 0;
		for (String element : elements) {
			retValue[i] = Double.valueOf(element);
			i++;
		}
		return retValue;
	}

}