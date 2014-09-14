package liquidInterface;

import org.junit.Test;

public class TestTerminal {

	@Test
	public void test() {
		MessageType requestType = null;
		Terminal terminal = new Terminal();
		terminal.initialize(new TerminalDetails()).
				 sends(new Message(requestType)).
		         checkResponce().
		         getTerminal().
		         sends(new Message(requestType)).
		         checkResponce();
		         //...
	}

}
