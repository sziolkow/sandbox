package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<String> readRow(BufferedReader br) throws IOException{
		List<String> row = new ArrayList<String>();
		String rowAsStr = br.readLine();
		String[] values = rowAsStr.split(" ");
		for(String value:values) {
			row.add(value);
		}
		return row;
	}
	

}
