package org.sziolkow.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExampleServiceTests {

	private ExampleService service = new ExampleService();
	
	/**
	 * Tests if the spring configuration is accessible.
	 * @throws Exception
	 */
	@Test	
	public void readOnce() throws Exception {
		assertEquals("Hello world!", service.getMessage());
	}

}