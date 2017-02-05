package gly.frontend;

import gly.intermediate.ICode;
import gly.intermediate.SymTab;

import gly.message.*;


public abstract class Parser implements MessageProducer {
	protected static SymTab symTab; //generated symbol table
	protected static MessageHandler messageHandler; //message handler delegate
	
	static {
		symTab = null;
		messageHandler = new MessageHandler();
	}
	
	protected Scanner scanner; //scanner for this parser
	protected ICode iCode; //intermediate code
	
	//Constructor
	protected Parser(Scanner scanner) {
		this.scanner = scanner;
		this.iCode = null;
	}
	
	//parse a source program
	//to be implemented
	public abstract void parse() throws Exception;
	
	//number of syntax errors
	//to be implemented
	public abstract int getErrorCount();
	
	//shorthand
	public Token currentToken() {
		return scanner.currentToken();
	}
	
	//shorthand
	public Token nextToken() throws Exception {
		return scanner.nextToken();
	}
	
	
	//LISTENER
	public void addMessageListener(MessageListener listener) {
		messageHandler.addListener(listener);
	}
	public void removeMessageListener(MessageListener listener) {
		messageHandler.removeListener(listener);
	}
	public void sendMessage(Message message) {
		messageHandler.sendMessage(message);
	}
}