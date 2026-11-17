public class Tokeniser {
    private String buffer;
    private Token currentToken;

    public Tokeniser(String input) {
        this.buffer = input.trim();
    }


    /**
     * Task (A)
     * Tokenise the remaining buffer to get the next token.
     * <p>
     * Assign the next token to this.currentToken after it is found, and
     * update the buffer to exclude the tokenised part. Return the
     * next token (i.e., the same as this.currentToken).
     *
     * If the upcoming buffer does not represent a valid next token,
     * assign null to `this.currentToken` and the buffer should remain unchanged.
     * <p>
     * Notes: The tokenisation process should be case-sensitive on the token strings.
     */
    public Token next() {
        // Look ahead; takeNext() below owns removal from the buffer.
        currentToken = null;
        if (buffer.isEmpty()) return null;
        char c = buffer.charAt(0);
        int length = 1;
        TokenType type;
        if (c >= '0' && c <= '9') {
            while (length < buffer.length() && buffer.charAt(length) >= '0' && buffer.charAt(length) <= '9') length++;
            type = TokenType.INT;
        } else if (c >= 'a' && c <= 'z') type = TokenType.VARIABLE;
        else if (c == '+' || c == '-' || c == '*') type = TokenType.OPERATOR;
        else if (c == ';') type = TokenType.EOL;
        else return null;
        currentToken = new Token(type, buffer.substring(0, length));
        return currentToken;
    }

    public Token takeNext() {
        Token token = next();
        if (token != null) buffer = buffer.substring(token.getValue().length()).trim();
        return token;
    }

    public Token current() {
        return this.currentToken;
    }


    public boolean hasNext() {
        return (!this.buffer.isEmpty());
    }

}
