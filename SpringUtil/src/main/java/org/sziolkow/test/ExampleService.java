package org.sziolkow.test;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;


/**
 * {@link Service} with hard-coded input data.
 */
@Component
public class ExampleService implements Service {
	
	/**
	 * Reads next record from input
	 */
	public String getMessage() {
		return "Hello world!";	
	}

	  public static void main(String[] argc) {
		  GenericXmlApplicationContext ctx =  new GenericXmlApplicationContext();
		 //s ctx.load("classpath:app-context.xml");
		  
	  }
}
