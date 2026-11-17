/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * @author huy.pham
 */
public class Parser {
	private Tokenizer _tokenizer;
	private Screen _screen;

	public Parser(Tokenizer tokenizer, Screen screen) {
		_tokenizer = tokenizer;
		_screen = screen;
	}

    /**
     * This should parse all the tokens, turn the pointer and mark its visited positions for
     * every move.
     *
     * If there is no more token, this should return the current screen
     *
     * @return a screen object containing pointer's trace information.
     * @throws Exception
     */
    public Screen parse() throws OutOfScreenException {
        while (_tokenizer.hasNext()) {
            Token token = _tokenizer.takeNext();
            Pointer p = _screen.pointer;
            switch (token.type) {
                case LEFT: p.turnLeft(); break;
                case RIGHT: p.turnRight(); break;
                case PENUP: p.isPenDown = false; break;
                case PENDOWN: p.isPenDown = true; _screen.markVisistedPos(p.position); break;
                default:
                    int dx = p.direction == Direction.Downward ? 1 : p.direction == Direction.Upward ? -1 : 0;
                    int dy = p.direction == Direction.Right ? 1 : p.direction == Direction.Left ? -1 : 0;
                    if (token.type == Token.Type.BACK) { dx = -dx; dy = -dy; }
                    int steps = token.value;

                    for (int i = 0; i < steps; i++) {
                        int x = p.position.x + dx, y = p.position.y + dy;
                        if (x < 0 || x >= _screen.noOfRows || y < 0 || y >= _screen.noOfColumns) throw new OutOfScreenException();
                        p.position = new Position(x, y);
                        if (p.isPenDown) _screen.markVisistedPos(p.position);
                    }
            }

        }
        return _screen;
    }
}
