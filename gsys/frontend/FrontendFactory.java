package gsys.frontend;

import gsys.frontend.gly.*;

public class FrontendFactory {
	public static final String LANG_GLY = "gly";
	
	public static final String TYPE_TOP_DOWN = "top-down";
	
	public static Parser createParser(String language, String type, Source source) throws Exception {
		if (language.equalsIgnoreCase(LANG_GLY) && type.equalsIgnoreCase(TYPE_TOP_DOWN)) {
			Scanner scanner = new GlyScanner(source);
			return new GlyParserTD(scanner);
		} else {
			if (!language.equalsIgnoreCase(LANG_GLY)) {
				throw new Exception("Parser factory: Invalid language '" + language + "'");
			} else {
				throw new Exception("Parser factory: Invalid type '" + type + "'");
			}
		}
	}
}