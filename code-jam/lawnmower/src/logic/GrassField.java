package logic;

import java.util.Iterator;
import java.util.TreeSet;

public class GrassField {

	public TreeSet<Integer> calculateLengths(int[][] sampleField) {
		TreeSet<Integer> lenghts =  new TreeSet<Integer>();
		for (int i = 0; i < sampleField.length; i++) {
			for (int j = 0; j < sampleField[i].length; j++) {
				lenghts.add(sampleField[i][j]);
			}
		}
		return lenghts;
	}
	
	public boolean checkPattern(int[][] field) {
		boolean proper = true;

		System.out.println(field.length);
		System.out.println(field[0].length);
		
		for (Iterator<Integer> lengths = calculateLengths(field).descendingIterator(); lengths.hasNext();) {
			Integer length = (Integer) lengths.next();
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[0].length; j++) {
					if(field[i][j]==length) {
						boolean accessViaRow = checkAccessViaRow(field, i, length);
						boolean accessViaColumn = checkAccessViaColumn(field, j, length);
						if(!accessViaColumn && !accessViaRow) {
							proper = false;
							break;
						}
					}
				}
				if (proper == false) {
					break;
				}
			}
		}

		return proper;
	}

	private boolean checkAccessViaColumn(int[][] field, int indexy, int len) {
		boolean retVal = true;
		for (int i = 0; i < field[0].length; i++) {
			if(field[i][indexy]>len) {
				return false;
			}
		}
		return retVal;
	}

	private boolean checkAccessViaRow(int[][] field, int indexx, int len) {
		boolean retVal = true;
		for (int i = 0; i < field.length; i++) {
			if(field[indexx][i]>len) {
				return false;
			}
		}
		return retVal;
	}
	

}
