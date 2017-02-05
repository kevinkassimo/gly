package gly.message;

public interface MessageProducer {
	//Add a listener to the listener list
	public void addMessageListener(MessageListener listener);
	
	//Remove a listener from the list
	public void removeMessageListener(MessageListener listener);
	
	//notify listeners
	public void sendMessage(Message message);
}