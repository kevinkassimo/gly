package gsys.frontend;

public class Token {
	protected TokenType type; //language-specific
	protected String text; //token text
	protected Object value; //token value, e.g. 3.1415926
	protected Source source; //source file
	protected int lineNum; //token line number
	protected int position; //token position
	
	public TokenType getType(){
		return type;
	}
	public String getText() {
		return text;
	}
	public Object getValue() {
		return value;
	}
	public int getLineNumber() {
		return lineNum;
	}
	public int getPosition() {
		return position;
	}
	
	//Construct token based on current source info
	public Token(Source source) throws Exception {
		this.source = source;
		this.lineNum = source.getLineNum();
		this.position = source.getPosition();
		
		extract();
	}
	
	//actually construct the token
	protected void extract() throws Exception {
		text = Character.toString(currentChar());
		value = null;
		nextChar();
	}
	
	//shorthand
	protected char currentChar() throws Exception {
		return source.currentChar();
	}
	
	//shorthand
	protected char nextChar() throws Exception {
		return source.nextChar();
	}
	
	//shorthand
	protected char peekChar() throws Exception {
		return source.peekChar();
	}
}