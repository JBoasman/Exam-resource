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
            Token.Type type = tokeniser.current().getType(); tokeniser.next();
            String parameter = take();
            if (type == Token.Type.LOAD) commands.add(new LoadCommand(parameter));
            else {
                take(); // TO
                String key = take();
                commands.add(type == Token.Type.SAVE ? new SaveCommand(key, Integer.parseInt(parameter)) : new SumCommand(parameter, key));
            }
            take(); // terminator
        }
        return commands;
    }
    private String take() {
        if (!tokeniser.hasNext()) throw new IllegalArgumentException("Unexpected end");
        String value = tokeniser.current().getValue(); tokeniser.next(); return value;
    }
}
