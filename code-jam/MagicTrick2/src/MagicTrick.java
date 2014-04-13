import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MagicTrick {
	
	private static int selectedCard=0;
	
	public static void main(String[] args) throws IOException {
		FileReader f = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(f);

		FileWriter g = new FileWriter(args[1]);

		BufferedWriter bwr = new BufferedWriter(g);

		int numberOfTests = readLineAsInt(br);

		for (int i = 0; i < numberOfTests; i++) {
			int firstAnswer = readLineAsInt(br);
			int[][] firstCardArray = readArray(br);

			int secondAnswer = readLineAsInt(br);
			int[][] secondCardArray = readArray(br);
			int result = checkQuessGame(firstAnswer, firstCardArray,
					secondAnswer, secondCardArray);
			if (result == 1) {
				bwr.write("Case #" + (i + 1) + ": "
						+ selectedCard);
			} else if (result > 1) {
				bwr.write("Case #" + (i + 1) + ": Bad magician!");
			} else if (result == 0) {
				bwr.write("Case #" + (i + 1) + ": Volunteer cheated!");
			}
			if((i+1)<numberOfTests) {
				bwr.newLine();
			}	
		}

		bwr.close();
		g.close();
		br.close();
		f.close();

	}

	public static int checkQuessGame(int firstAnswer, int[][] firstCardArray,
			int secondAnswer, int[][] secondCardArray) {
		int returnVal = 0;

		int[] firstRow = firstCardArray[firstAnswer - 1];
		int[] secondRow = secondCardArray[secondAnswer - 1];
		Set<Integer> cardSet = new HashSet<Integer>();

		for (int i = 0; i < firstRow.length; i++) {
			cardSet.add(firstRow[i]);
		}
		for (int i = 0; i < secondRow.length; i++) {
			if (cardSet.contains(secondRow[i])) {
				returnVal++;
				selectedCard = secondRow[i];
				continue;
			}
		}

		return returnVal;
	}

	private static int readLineAsInt(BufferedReader br) throws IOException {
		String firstLine = br.readLine();
		return new Integer(firstLine);
	}

	private static int[][] readArray(BufferedReader br) throws IOException {
		String row = null;
		int[][] playfield = new int[4][4];
		byte counter = 0;
		do {
			row = br.readLine();
			playfield[counter] = createRow(row);
			counter++;
		} while (counter < 4);
		return playfield;
	}

	private static int[] createRow(String row) {
		int[] retValue = new int[4];
		String[] elements = row.split(" ");
		int i = 0;
		for (String element : elements) {
			retValue[i] = Integer.valueOf(element);
			i++;
		}
		return retValue;
	}

}