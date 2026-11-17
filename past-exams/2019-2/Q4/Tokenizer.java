package parser;
/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 * @author dongwoo
 */
public class Tokenizer {
    private String _buffer;
    private final char COMMAND_SEPARATOR = ';'; 
    private Token current;
    
    public Tokenizer(String buffer) {
        this._buffer = buffer;
        this.next();
    }
    
    /**
     *  Extract the next token from {@code _buffer}
     */
    public void next() {
        _buffer = _buffer.trim();
        if (_buffer.isEmpty()) { current = null; return; }
        int end = _buffer.indexOf(';');
        String command = (end < 0 ? _buffer : _buffer.substring(0, end)).trim();
        String[] parts = command.split("[()\\s]+");
        Token.Type type = Token.Type.valueOf(parts[0]);
        Token token = parts.length == 1 ? new Token(type) : new Token(type, command, Integer.parseInt(parts[1]));
        current = token;
        _buffer = end < 0 ? "" : _buffer.substring(end + 1);
    }
    

    /**
     * Return the token in {@code _current}
     * @return the next token
     */
    public Token current() {
        return current;
    }

    /**
     * @return whether there is another token in {@code _current}
     */
    public boolean hasNext() {
        if(current == null){
            return false;
        }
        return true;
    }

}