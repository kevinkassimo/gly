package gsys.backend.compiler;

import gsys.backend.*;
import gsys.intermediate.ICode;
import gsys.intermediate.SymTab;
import gsys.message.*;

public class CodeGenerator extends Backend {
	public void process(ICode iCode, SymTab symTab) throws Exception {
		long startTime = System.currentTimeMillis();
		float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
		int instructionCount = 0;
		sendMessage(new Message(MessageType.COMPILER_SUMMARY, new Number[]{instructionCount, elapsedTime}));
	}
}