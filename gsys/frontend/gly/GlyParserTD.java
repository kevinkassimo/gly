package gsys.frontend.gly;

import gsys.frontend.*;
import gsys.message.*;

public class GlyParserTD extends Parser {
	public GlyParserTD(Scanner scanner) {
		super(scanner);
	}
	
	public void parse() throws Exception {
		Token token;
		long startTime = System.currentTimeMillis();
		
		//infinite loop if token is NOT EofToken (end)
		while (!((token = nextToken()) instanceof EofToken)) {
			//pass for now
		}
		
		float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
		sendMessage(new Message(MessageType.PARSER_SUMMARY, new Number[]{token.getLineNumber(), getErrorCount(), elapsedTime}));
	}
	
	public int getErrorCount() {
		return 0;
	}
}