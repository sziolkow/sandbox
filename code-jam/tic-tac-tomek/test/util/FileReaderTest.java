package util;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {
	private FileReader f;
	private BufferedReader br;
	
	@Before
	public void init() throws FileNotFoundException {
		f = new FileReader("A-small-practice.in" );
		br = new BufferedReader(f);
	}
	
	@After
	public void clean() throws IOException {
		br.close();
		f.close();
	}
	
	@Test
	public void readNumberOfTests() throws IOException {
		CustomFileReader cfr = new CustomFileReader();
		Integer expectedNumberOfTestCases = cfr.readNumberOfTests(br);
		assertEquals(expectedNumberOfTestCases, new Integer(10));
	}
	
	@Test
	public void readArray() throws IOException {
		String[][] expectedValue = new String[4][4];
		expectedValue[0] =new String[] {".","X",".","O"};
		expectedValue[1] =new String[] {".",".","O","O"};
		expectedValue[2] =new String[] {".",".",".","."};
		expectedValue[3] =new String[] {".","X","T","X"};
	
		CustomFileReader cfr = new CustomFileReader();
		String[][] arrayFromFile = cfr.readArray(br);
		assertArrayEquals(expectedValue, arrayFromFile);	
	}

	@Test
	public void readSecondArray() throws IOException {
		String[][] expectedValue = new String[4][4];
		expectedValue[0] =new String[] {"X","O","X","X"};
		expectedValue[1] =new String[] {"X","O","X","X"};
		expectedValue[2] =new String[] {"T","X","O","O"};
		expectedValue[3] =new String[] {"O","O","O","X"};

		CustomFileReader cfr = new CustomFileReader();
		String[][] arrayFromFile = cfr.readArray(br);
		//second Array
		arrayFromFile = cfr.readArray(br);
		assertArrayEquals(expectedValue, arrayFromFile);	
	}
}
