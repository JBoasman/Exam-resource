import java.util.LinkedList;
import java.util.List;

public class Parser {

	private final Tokeniser tokeniser;

	public Parser(Tokeniser tokeniser) {
		this.tokeniser = tokeniser;
	}

	public List<Command> parseCmds() {
        List<Command> commands = new LinkedList<>();
        while (tokeniser.hasNext()) {
            Token.Type action = tokeniser.current().getType(); tokeniser.next();
            if (action != Token.Type.LOAD && action != Token.Type.SAVE) throw new IllegalArgumentException("Expected LOAD or SAVE");
            String key = require(Token.Type.PARAMETER);
            require(action == Token.Type.LOAD ? Token.Type.FROM : Token.Type.TO);
            String file = require(Token.Type.PARAMETER);
            require(Token.Type.TERMINATOR);
            commands.add(action == Token.Type.LOAD ? new LoadCommand(key, file) : new SaveCommand(key, file));
        }
        return commands;
    }
    private String require(Token.Type type) {
        if (!tokeniser.hasNext() || tokeniser.current().getType() != type) throw new IllegalArgumentException("Expected " + type);
        String value = tokeniser.current().getValue(); tokeniser.next(); return value;
    }
}
