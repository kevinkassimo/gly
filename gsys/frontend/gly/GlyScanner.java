package gsys.frontend.gly;

import gsys.frontend.*;
import static gsys.frontend.Source.EOF;

public class GlyScanner extends Scanner {
	public GlyScanner(Source source) {
		super(source);
	}
	
	protected Token extractToken() throws Exception {
		Token token;
		char currentChar = currentChar();
		if (currentChar == EOF) {
			token = new EofToken(source);
		} else {
			token = new Token(source);
		}
		return token;
	}
}