package liquidInterface;

public class Result implements IResult{
	
	private IMessage requestMsg;

	private IMessage responseMsg;

	private Terminal terminal;
	
	public Result(IMessage request, IMessage response, Terminal aTerminal) {
		requestMsg=request;
		responseMsg=response;
		terminal = aTerminal;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	@Override
	public IResult checkResponce() {
		// TODO do some checks
		return this;
	}

	public IMessage getRequestMsg() {
		return requestMsg;
	}

	public void setRequestMsg(IMessage requestMsg) {
		this.requestMsg = requestMsg;
	}

	public IMessage getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(IMessage responseMsg) {
		this.responseMsg = responseMsg;
	}

	@Override
	public IResult checkDatabase() {
		// TODO Do some checks
		return this;
	}

}
