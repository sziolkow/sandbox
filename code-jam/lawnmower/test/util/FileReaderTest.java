package util;


import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {
	private FileReader f;
	private BufferedReader br;
	
	@Before
	public void init() throws FileNotFoundException {
		f = new FileReader("B-small-practice.in" );
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
		assertEquals(expectedNumberOfTestCases, new Integer(100));
	}
	
	@Test
	public void readSizeOfField() throws IOException {
		CustomFileReader cfr = new CustomFileReader();
		Integer expectedNumberOfTestCases = cfr.readNumberOfTests(br);
		int[] xysize = cfr.readSizeOfField(br);
        assertEquals(xysize[0],3);
        assertEquals(xysize[1],3);        
	}
	
	@Test
	public void readField() throws IOException{
		CustomFileReader cfr = new CustomFileReader();
		cfr.readNumberOfTests(br);
		int[] xysize = cfr.readSizeOfField(br);
		int[][] expectedValue = new int[3][3];
		expectedValue[0] =new int[] {2,1,2};
		expectedValue[1] =new int[] {1,1,1};
		expectedValue[2] =new int[] {2,1,2};
		
		int[][] fieldFromFile = cfr.readField(br,xysize[0],xysize[1]);
		assertArrayEquals(expectedValue, fieldFromFile);	

	}
	
	@Test 
	public void createLengthList(){
		TreeSet<Integer> lengthList = new TreeSet<Integer>();
		lengthList.add(1);
		lengthList.add(8);
		lengthList.add(2);
		System.out.println(lengthList);
		
	}
	
}
