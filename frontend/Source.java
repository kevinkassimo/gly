package gly.frontend;

import java.io.BufferedReader;
import java.io.IOException;

public class Source {
	public static final char EOL = '\n';
	public static final char EOF = (char) 0;
	
	private static final int READ_START_FILE_POS = -2;
	private static final int READ_BEFORE_LINE_POS = -1;
	
	private BufferedReader reader; //reader for source
	private String line; //source line
	private int lineNum; //line number
	private int currentPos; //source line position
	
	public Source(BufferedReader reader) throws IOException {
		this.lineNum = 0;
		this.currentPos = -2 //read the first source line
		this.reader = reader;
	}
	
	public int getLineNum() {
		return lineNum;
	}
	public int getPosition() {
		return currentPos;
	}
	
	public char currentChar() throws Exception {
		if (currentPos == -2) { //start read file
			readLine();
			return nextChar();
		} else if (line == null) { //end read file
			return EOF;
		} else if ((currentPos == -1) || (currentPos == line.length())) { //end of line
			return EOL;
		} else if (currentPos > line.length()) { //exceed end of line
			readline();
			return nextChar();
		} else { //normal
			return line.charAt(currentPos);
		}
	}
	
	public char nextChar() throws Exception {
		currentPos++;
		return currentChar();
	}
	
	public char peekChar() throws Exception {
		currentChar(); //avoid invalid position
		if (line == null) {
			return EOF;
		}
		
		int nextPos = currentPos + 1;
		return nextPos < line.length() ? line.charAt(nextPos) : EOL;
	}
	
	public void readline() throws IOException {
		line = reader.readLine();
		currentPos = -1;
		
		if (line != null) {
			lineNum++;
		}
	}
	
	public void close() throws Exception {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				throw ex;
			}
		}
	}
}