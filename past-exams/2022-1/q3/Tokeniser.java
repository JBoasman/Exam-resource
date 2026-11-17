public class Tokeniser {

	private String buffer;
	private Token currentToken;

	public Tokeniser(String text) {
		buffer = text;
		next();
	}

	public void next() {
        int start = 0;
        while (start < buffer.length() && !Character.isLetterOrDigit(buffer.charAt(start)) && buffer.charAt(start) != '*' && buffer.charAt(start) != ';') start++;
        buffer = buffer.substring(start);
        if (buffer.isEmpty()) { currentToken = null; return; }
        int end = 0;
        if (buffer.charAt(0) == ';') end = 1;
        else while (end < buffer.length() && (Character.isLetterOrDigit(buffer.charAt(end)) || buffer.charAt(end) == '*')) end++;
        String value = buffer.substring(0, end);
        Token.Type type;
        if (value.equals(";")) type = Token.Type.TERMINATOR;
        else {
            try { type = Token.Type.valueOf(value.toUpperCase(java.util.Locale.ROOT)); }
            catch (IllegalArgumentException e) { type = Token.Type.PARAMETER; }
        }
        currentToken = new Token(type, value);
        buffer = buffer.substring(end);
    }

	public Token current() {
		return currentToken;
	}

	public boolean hasNext() {
		return currentToken != null;
	}

}