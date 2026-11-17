

public class MyTokenizer implements Tokenizer {

    private String buffer;		//save text
    private Token currentToken;	//save token extracted from next()

    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToken
     *  **** please do not modify this part ****
     */
    public MyTokenizer(String text) {
    	buffer = text;		// save input text (string)
    	next();		// extracts the first token.
    }

    /**
     *  This function will find and extract a next token from {@code buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() {
        buffer = buffer.trim();
        if (buffer.isEmpty()) { currentToken = null; return; }
        int end = 1;
        char first = buffer.charAt(0);
        Token.Type type;
        if (Character.isLetter(first)) {
            while (end < buffer.length() && Character.isLetter(buffer.charAt(end))) end++;
            String word = buffer.substring(0, end);
            if (word.equals(word.toUpperCase(java.util.Locale.ROOT))) type = Token.Type.UPPER_CASE_WORD;
            else if (word.equals(word.toLowerCase(java.util.Locale.ROOT))) type = Token.Type.LOWER_CASE_WORD;
            else type = end <= 3 ? Token.Type.SHORT_CAMEL_CASE_WORD : Token.Type.LONG_CAMEL_CASE_WORD;
        } else if (Character.isDigit(first)) {
            while (end < buffer.length() && Character.isDigit(buffer.charAt(end))) end++;
            type = Token.Type.INTEGER_NUMBER;
        } else type = Token.Type.NON_ALPHANUMERIC;
        currentToken = new Token(buffer.substring(0, end), type);
        buffer = buffer.substring(end);
    }

    /**
     *  returned the current token extracted by {@code next()}
     *  **** please do not modify this part ****
     *  
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  **** please do not modify this part ****
     *  
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }


}