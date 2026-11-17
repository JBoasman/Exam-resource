/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * Question:
 * Write a parse to recognize the language specified by the following grammar:
 * S := () ; S := (S) ; S := SS ;
 */
public class Parser {
	Tokeniser _tokeniser;
    
    public Parser(Tokeniser tokeniser) {
    	_tokeniser = tokeniser;
    }

    /**
	 * @return True if the given tokens conform with the grammar. False, otherwise.
	 */
	public boolean parseExp() {
        int depth = 0;
        boolean seen = false;
        while (_tokeniser.hasNext()) {
            seen = true;
            Token token = _tokeniser.takeNext();
            depth += token.type == Token.Type.LEFT_BRACKET ? 1 : -1;
            if (depth < 0) return false;
        }
        return seen && depth == 0 && _tokeniser.isNextValid();
    }

}
