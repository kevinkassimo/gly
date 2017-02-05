package gsys.backend;

import gsys.backend.compiler.CodeGenerator;
import gsys.backend.interpreter.Executor;

public class BackendFactory {
	public static final String OP_COMPILE = "compile";
	public static final String OP_EXECUTE = "execute";
	
	public static Backend createBackend(String operation) throws Exception {
		if (operation.equalsIgnoreCase(OP_COMPILE)) {
			return new CodeGenerator();
		} else if (operation.equalsIgnoreCase(OP_EXECUTE)) {
			return new Executor();
		} else {
			throw new Exception("Backend factory: Invalid operation '" +
								operation + "'");
		}
	}
}