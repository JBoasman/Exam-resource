/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * @author huy.pham
 */
public class Tokeniser {
    private String _buffer;

    public Tokeniser(String buffer) {
        this._buffer = buffer;
    }

    /**
     * Get token at a specified index
     * @param index Index of the character to be tokenised from the buffer
     * @return {@link Token}
     */
    private Token getTokenAt(int index) {
        if (index < 0 || index >= _buffer.length()) return null;
        char c = _buffer.charAt(index);
        if (c < '0' || c > '9') return null;
        return new Token((c - '0') % 2 == 0 ? Token.Type.EVEN_NUMBER : Token.Type.ODD_NUMBER, "" + c);
    }

    /**
     * Return the next token without changing the buffer
     * @return the next token OR null when there is no more token or the next token is invalid.
     */
    public Token next() {
        return getTokenAt(0);
    }

    /**
     * Return the last token without changing the buffer
     * @return the last token OR null when there is no more token or the next token is invalid.
     */
    public Token last() {
        return getTokenAt(_buffer.length() - 1);
    }

    /**
     * Return the next token and remove it from the buffer
     * @return the next token OR null when there is no more token or the next token is invalid.
     */
    public Token takeNext() {
        Token token = next();
        if (token == null)
            return null;

        if (token.originalTokenStr.length() < _buffer.length()) {
            _buffer = _buffer.substring(token.originalTokenStr.length());
        } else {
        	_buffer = "";
        }
        
        return token;
    }

    /**
     * Return the last token and remove it from the buffer
     * @return the last token OR null when there is no more token or the next token is invalid.
     */
    public Token takeLast() {
        Token token = last();
        if (token == null)
            return null;

        if (token.originalTokenStr.length() < _buffer.length()) {
            _buffer = _buffer.substring(0, _buffer.length() - token.originalTokenStr.length());
        } else {
            _buffer = "";
        }

        return token;
    }

    /**
     * @return whether there is another token to parse in the buffer
     */
    public boolean hasNext() {
        return next() != null;
    }

    /**
     * @return True only if the next token is valid
     */
    public boolean isNextOrLastValid() {
        if ((next() == null || last() == null) && !_buffer.isEmpty()) {
            return false;
        }

        return true;
    }
}