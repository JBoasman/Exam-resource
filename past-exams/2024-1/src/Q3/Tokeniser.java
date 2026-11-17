public class Tokeniser {
    private String buffer;
    private InputToken currentToken;

    public Tokeniser(String input) {
        this.buffer = input;
        this.next();
    }

    public InputToken getCurrentToken() {
        return this.currentToken;
    }


    /**
     * Task (A)
     * Tokenise the remaining buffer to get the next token.
     * <p>
     * Assign the next token to this.currentToken after it is found, and
     * update the buffer to exclude the tokenised part. Otherwise, if there
     * is not a valid next token, this.currentToken should be null and the
     * buffer should remain unchanged.
     * <p>
     * Notes:
     *   -  The tokenisation process should be case-insensitive on the token strings.
     */
    public void next() {
        buffer = buffer.replaceFirst("^ +", "");
        currentToken = null;
        if (buffer.isEmpty()) return;
        int length = 0;
        for (TokenType type : new TokenType[]{TokenType.UNDO, TokenType.REDO, TokenType.CAPITALISE, TokenType.SEPARATOR}) {
            if (buffer.regionMatches(true, 0, type.getStr(), 0, type.getStr().length())) {
                currentToken = new InputToken(type); length = type.getStr().length(); break;
            }
        }
        if (currentToken == null && Character.isDigit(buffer.charAt(0))) {
            while (length < buffer.length() && Character.isDigit(buffer.charAt(length))) length++;
            try {
                int value = Integer.parseInt(buffer.substring(0, length));
                if (value < 1000) currentToken = new InputToken(TokenType.OCCURRENCES, value);
            } catch (NumberFormatException e) { return; }
        }
        if (currentToken == null && ((buffer.charAt(0) >= 'a' && buffer.charAt(0) <= 'z') || (buffer.charAt(0) >= 'A' && buffer.charAt(0) <= 'Z'))) {
            currentToken = new InputToken(TokenType.TYPE); length = 1;
        }
        if (currentToken != null) buffer = buffer.substring(length);
    }


    public boolean isEmpty() {
        return this.buffer.isEmpty();
    }


}
