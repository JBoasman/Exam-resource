/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * Question:
 * Write a parse to recognize the language specified by the following grammar:
 * X := 1 | 3 | 5 | 7 | 9 ; Y := 0 | 2 | 4 | 6 | 8 ; X := YX ; Y := XY ; S := X | Y ;
 *
 * @author huy.pham
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
        // X := odd | Y X; Y := even | X Y. Chart parsing avoids left recursion.
        java.util.List<Token.Type> tokens = new java.util.ArrayList<>();
        while (_tokeniser.hasNext()) tokens.add(_tokeniser.takeNext().type);
        if (!_tokeniser.isNextOrLastValid() || tokens.isEmpty()) return false;
        int n = tokens.size();
        boolean[][] x = new boolean[n][n + 1], y = new boolean[n][n + 1];
        for (int i = 0; i < n; i++) {
            x[i][i + 1] = tokens.get(i) == Token.Type.ODD_NUMBER;
            y[i][i + 1] = tokens.get(i) == Token.Type.EVEN_NUMBER;
        }
        for (int len = 2; len <= n; len++)
            for (int i = 0; i + len <= n; i++)
                for (int k = i + 1; k < i + len; k++) {
                    x[i][i + len] |= y[i][k] && x[k][i + len];
                    y[i][i + len] |= x[i][k] && y[k][i + len];
                }
        return x[0][n] || y[0][n];
    }

}
