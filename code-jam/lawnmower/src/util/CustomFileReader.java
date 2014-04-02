package util;

import java.io.BufferedReader;
import java.io.IOException;

public class CustomFileReader {
	
	public Integer readNumberOfTests(BufferedReader br) throws IOException {
		String firstLine = br.readLine();
		return new Integer(firstLine);
	}
	
	public String readLine(BufferedReader br) throws IOException {
		return br.readLine();
	}
	
	public String[][] readArray(BufferedReader br) throws IOException {
		String row = null;
		String[][] playfield = new String [4][4];
		boolean startArray = false;
		byte counter = 0;
		do {
			row = br.readLine();
			if (row == null) {
				break;
			} 
			
			if (row.length() == 4 && startArray == false) {
				startArray = true;
			}
			
			if (startArray && row.length() != 4 && counter<4) {
				throw new IllegalArgumentException("Bad definition");
			}
			
			if (row.length() == 4) {
				playfield[counter] = createRow(row);
				counter ++;
			}
			
		}
		while (counter <4);
		return playfield;
	}

	private String[] createRow(String row) {
		String[] retValue = new String[4];
		for (int i = 0; i < retValue.length; i++) {
			retValue[i] = ""+row.charAt(i);
		}
		return retValue;
	}
	
	public int[] readSizeOfField(BufferedReader br) throws IOException {
		int[] xysize = new int[2];
		String row = br.readLine();
		String[] elements =  row.split(" ");
		xysize[0] = new Integer (elements[0]);
		xysize[1] = new Integer (elements[1]);
		return xysize;
	}

	public int[][] readField(BufferedReader br, int rows, int columns) throws IOException {
		int[][] field = new int[rows][columns];		
		for (int i = 0; i < rows; i++) {
			String row = br.readLine();
			String[] elements =  row.split(" ");
			for (int j = 0; j < elements.length; j++) {
				field[i][j]=new Integer(elements[j]);
			}
		}
		return field;
	}

}
