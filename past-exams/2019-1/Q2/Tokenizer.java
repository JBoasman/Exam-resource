/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 */
public class Tokenizer {
    private String _buffer;
    private final char COMMAND_SEPARATOR = ';'; 
    
    public Tokenizer(String buffer) {
        this._buffer = buffer;
    }
    
    /**
     * @return the next token
     */
    private Token next() {
        _buffer = _buffer.trim();
        if (_buffer.isEmpty()) return null;
        int end = _buffer.indexOf(';');
        String command = (end < 0 ? _buffer : _buffer.substring(0, end)).trim();
        String[] parts = command.split("[()\\s]+");
        Token.Type type = Token.Type.valueOf(parts[0]);
        Token token = parts.length == 1 ? new Token(type) : new Token(type, command, Integer.parseInt(parts[1]));
        return token;
    }

    /**
     * Return the next token and remove it from the buffer
     * @return the next token
     */
    public Token takeNext() {
        Token token = next();
        if (token != null) {
            int end = _buffer.indexOf(';');
            _buffer = end < 0 ? "" : _buffer.substring(end + 1);
        }
        return token;
    }

    /**
     * @return whether there is another token to parse in the buffer
     */
    public boolean hasNext() {
        return next() != null;
    }
   
}