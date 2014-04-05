package util;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {
	private FileReader f;
	private BufferedReader br;
	
	@Before
	public void init() throws FileNotFoundException {
		f = new FileReader("test/res/C-small-practice.in" );
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
	public void readLine() throws IOException {
		CustomFileReader cfr = new CustomFileReader();
		Integer expectedNumberOfTestCases = cfr.readNumberOfTests(br);

		List<Integer>row = cfr.readRow(br);

		List<Integer> expectedRow = new ArrayList<Integer>();
		expectedRow.add(new Integer(1));
		expectedRow.add(new Integer(4));		
		
		assertEquals(expectedRow, row);
	}
	
	

}
