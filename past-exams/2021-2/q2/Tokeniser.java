public class Tokeniser {

	private String buffer; // save text
	private Token currentToken; // save token extracted from next()

	public Tokeniser(String text) {
		buffer = text; // save input text (string)
		next(); // extracts the first token.
	}

	/**
	 * This function will find and extract a next token from {@code buffer} and save
	 * the token to {@code currentToken}.
	 */
	public void next() {
        buffer = buffer.trim();
        if (buffer.isEmpty()) { currentToken = null; return; }
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("^;|^[^\\s;]+").matcher(buffer);
        if (!m.find()) throw new IllegalArgumentException("Invalid token");
        String value = m.group();
        Token.Type type;
        if (value.equals(";")) type = Token.Type.TERMINATOR;
        else {
            try { type = Token.Type.valueOf(value.toUpperCase(java.util.Locale.ROOT)); }
            catch (IllegalArgumentException e) { type = Token.Type.PARAMETER; }
        }
        currentToken = new Token(type, value);
        buffer = buffer.substring(value.length());
    }

	/**
	 * returned the current token extracted by {@code next()} **** please do not
	 * modify this part ****
	 * 
	 * @return type: Token
	 */
	public Token current() {
		return currentToken;
	}

	/**
	 * check whether there still exists another tokens in the buffer or not ****
	 * please do not modify this part ****
	 * 
	 * @return type: boolean
	 */
	public boolean hasNext() {
		return currentToken != null;
	}

}