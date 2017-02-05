package gsys.backend.interpreter;

import gsys.backend.*;
import gsys.intermediate.ICode;
import gsys.intermediate.SymTab;
import gsys.message.*;

public class Executor extends Backend {
	public void process(ICode iCode, SymTab symTab) throws Exception {
		long startTime = System.currentTimeMillis();
		float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
		int executionCount = 0;
		int runtimeErrors = 0;
		
		sendMessage(new Message(MessageType.INTERPRETER_SUMMARY, new Number[]{executionCount, runtimeErrors, elapsedTime}));
	}
}