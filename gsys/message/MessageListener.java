package gsys.message;

public interface MessageListener {
	//call to receive a message
	public void messageReceived(Message message);
}