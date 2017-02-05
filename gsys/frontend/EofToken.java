package gsys.frontend;

//The generic end-of-file token
public class EofToken extends Token {
	public EofToken(Source source) throws Exception {
		super(source);
	}
	
	//Do nothing, not consuming any source char
	protected void extract(Source source) {
		//pass
	}
}