package logic;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class GrassFieldTest {

	@Test
	public void calculateLenghts(){
		GrassField field =  new GrassField(3,3);

		int[][] sampleField = new int[3][3];
		sampleField[0] =new int[] {2,1,2};
		sampleField[1] =new int[] {1,1,1};
		sampleField[2] =new int[] {2,1,2};

		Integer[]expected = new Integer[] {1,2};
		TreeSet<Integer> lengths = field.calculateLengths(sampleField);
		assertArrayEquals(expected,lengths.toArray());
		
	}

	@Test
	public void checkPattern(){
		GrassField field =  new GrassField(3,3);

		int[][] sampleField = new int[3][3];
		sampleField[0] =new int[] {2,1,2};
		sampleField[1] =new int[] {1,1,1};
		sampleField[2] =new int[] {2,1,2};

		assertEquals(true,field.checkPattern(sampleField));
		
	}
	
}
