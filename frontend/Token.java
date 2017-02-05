package gly.frontend;

public class Token {
	protected TokenType type; //language-specific
	protected String text;
	protected Object value;
	protected Source source;
	protected int lineNum;
	protected int position;
	
	public Token(Source source) {
		this.source = source;
		this.lineNum = source.getLineNum();
		this.position = source.getPosition();
		
		extract();
	}
	
	protected void extract() throws Exception {
		text = Character.toString(currentChar());
		value = null;
		nextChar();
	}
	
	protected char currentChar() throws Exception {
		return source.currentChar();
	}
	
	protected char nextChar() throws Exception {
		return source.nextChar();
	}
	
	protected char peekChar() throws Exception {
		return source.peekChar();
	}
}