package logic;

public class Converter {

	public int[][] convertToXPerspektive(String[][] arrayToConvert) {
		return convertToOneState(arrayToConvert,"X");
	}

	public int[][] convertToOPerspektive(String[][] arrayToConvert) {
		return convertToOneState(arrayToConvert,"O");
	}
	
	private int[][] convertToOneState(String[][] arrayToConvert, String player) {
		int[][] retArray = new int[4][4];
		for (int i = 0; i < arrayToConvert.length; i++) {
			for (int j = 0; j < arrayToConvert.length; j++) {
				if (arrayToConvert[i][j].equals(player) || arrayToConvert[i][j].equals("T")){
					retArray[i][j] = 1; 
				} else {
					retArray[i][j] = 0;
				}
			}
		}
		return retArray;
	}

}
