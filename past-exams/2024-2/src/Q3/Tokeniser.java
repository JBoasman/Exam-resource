public class Tokeniser {
    private String buffer;
    private GitToken currentToken;

    public Tokeniser(String input) {
        this.buffer = input;
        this.next();
    }

    public GitToken getCurrentToken() {
        return this.currentToken;
    }


    /**
     * Task (A)
     * Tokenise the remaining buffer to get the next token.
     * <p>
     * Assign the next token to this.currentToken after it is found, and
     * update the buffer to exclude the tokenised part.
     * If the upcoming buffer does not represent a valid next token,
     * assign null to `this.currentToken` and the buffer should remain unchanged.
     * <p>
     * Notes: The tokenisation process should be case-sensitive on the token strings.
     */
    public GitToken next() {
        buffer = buffer.stripLeading();
        currentToken = null;
        if (buffer.isEmpty()) return null;
        int end = 0;
        if (buffer.charAt(0) == ';') end = 1;
        else while (end < buffer.length() && buffer.charAt(end) != ' ' && buffer.charAt(end) != ';') end++;
        String word = buffer.substring(0, end);
        if (word.startsWith(".")) currentToken = new GitToken(GitTokenType.PATH, word);
        else {
            for (GitTokenType type : GitTokenType.values()) if (type != GitTokenType.PATH && type.getStr().equals(word)) currentToken = new GitToken(type);
        }
        if (currentToken != null) buffer = buffer.substring(end);
        return currentToken;
    }

    public boolean hasNext() {
        return (this.currentToken != null);
    }

    public boolean isEmpty() {
        return this.buffer.isEmpty();
    }

}
