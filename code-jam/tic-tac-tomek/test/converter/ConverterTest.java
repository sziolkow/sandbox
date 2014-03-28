package converter;

import static org.junit.Assert.*;
import logic.Converter;

import org.junit.Test;

public class ConverterTest {

	Converter converter = new Converter();
	
	@Test
	public void convertArrayToXPerspektive() {
		String[][] arrayToConvert =  new String[4][4];
		
		arrayToConvert[0] =new String[] {".","X",".","O"};
		arrayToConvert[1] =new String[] {".",".","O","O"};
		arrayToConvert[2] =new String[] {".",".",".","."};
		arrayToConvert[3] =new String[] {".","X","T","X"};
		
		int[][] xArray = converter.convertToXPerspektive(arrayToConvert);
		int[][] arrayExpected =  new int[4][4];
		
		arrayExpected[0] =new int[] {0,1,0,0};
		arrayExpected[1] =new int[] {0,0,0,0};
		arrayExpected[2] =new int[] {0,0,0,0};
		arrayExpected[3] =new int[] {0,1,1,1};
		
		assertArrayEquals(arrayExpected, xArray);
	}

}
