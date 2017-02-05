package gsys.backend;

import gsys.intermediate.ICode;
import gsys.intermediate.SymTab;
import gsys.message.*;

public abstract class Backend implements MessageProducer {
	//handler delegate
	protected static MessageHandler messageHandler;
	
	static {
		messageHandler = new MessageHandler();
	}
	
	protected SymTab symTab;
	protected ICode iCode;
	
	public ICode getICode() {
		return iCode;
	}
	public SymTab getSymTab() {
		return symTab;
	}
	public MessageHandler getMessageHandler() {
		return messageHandler;
	}
	
	
	//process intermediate code
	public abstract void process(ICode iCode, SymTab symTab) throws Exception;

	
	public void sendMessage(Message message) {
		messageHandler.sendMessage(message);
	}
	public void addMessageListener(MessageListener listener) {
		messageHandler.addListener(listener);
	}
	public void removeMessageListener(MessageListener listener) {
		messageHandler.removeListener(listener);
	}
}