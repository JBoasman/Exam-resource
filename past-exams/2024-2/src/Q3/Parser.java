import java.util.ArrayList;
import java.util.List;


public class Parser {
    Tokeniser tokeniser;

    public Parser() {
    }

    public Parser(Tokeniser tokeniser) {
        this.tokeniser = tokeniser;
    }


    /**
     * Task (B)
     * Parse the tokens and create git commands.
     */
    public List<GitCommand> parse() {
        List<GitCommand> commands = new ArrayList<>();
        while (tokeniser.hasNext()) {
            if (tokeniser.getCurrentToken().getType() != GitTokenType.GIT) return null;
            tokeniser.next();
            if (!tokeniser.hasNext()) return null;
            GitTokenType action = tokeniser.getCurrentToken().getType(); tokeniser.next();
            GitCommand command;
            if (action == GitTokenType.ADD) {
                if (!tokeniser.hasNext() || tokeniser.getCurrentToken().getType() != GitTokenType.PATH) return null;
                command = new GitCommand(GitCommand.GitCommandType.GIT_ADD, tokeniser.getCurrentToken().getValue()); tokeniser.next();
            } else if (action == GitTokenType.COMMIT) command = new GitCommand(GitCommand.GitCommandType.GIT_COMMIT);
            else if (action == GitTokenType.PUSH) command = new GitCommand(GitCommand.GitCommandType.GIT_PUSH);
            else return null;
            if (!tokeniser.hasNext() || tokeniser.getCurrentToken().getType() != GitTokenType.SEPARATOR) return null;
            commands.add(command); tokeniser.next();
        }
        return tokeniser.isEmpty() ? commands : null;
    }



}
