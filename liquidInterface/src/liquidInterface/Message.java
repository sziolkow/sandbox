package liquidInterface;

public class Message implements IMessage{
	
	private MessageType messageType;
	
	public Message(MessageType requestType) {
		super();
		this.messageType = requestType;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

}
