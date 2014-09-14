package liquidInterface;

public class Terminal{
	
	public IResult sends(IMessage message) {
		//Do somethnng with the message
		IResult result = new Result(message, message, this);
		return result;
	}
	
    Terminal initialize(TerminalDetails terminalDetails) {
    	return this;
    }

}
