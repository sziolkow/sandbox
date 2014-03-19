package org.sziolkow.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExampleServiceTests {

	private ExampleService service = new ExampleService();
	
	@Test
	public void testReadOnce() throws Exception {
		assertEquals("Hello world!", service.getMessage());
	}

}
