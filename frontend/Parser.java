package gly.frontend

import gly.intermediate.ICode;
import gly.intermediate.SymTab;


public abstract class Parser {
	protected static SymTab symTab; //generated symbol table
	
	static {
		symTab = null;
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
}