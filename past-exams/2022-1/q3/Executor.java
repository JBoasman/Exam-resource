import java.util.LinkedList;
import java.util.List;

public class Executor {

	private final List<Command> commands;

	private final BST memory = new BST();

	public Executor(List<Command> commands) {
		this.commands = commands;
	}

	public List<NodeCopy> execute() {
		List<NodeCopy> results = new LinkedList<>();
		for (Command c : this.commands) {
			if (c instanceof LoadCommand) {
				results.add(load((LoadCommand) c));
			} else if (c instanceof SaveCommand) {
				results.add(save((SaveCommand) c));
			} else if (c instanceof SumCommand) {
				results.add(sum((SumCommand) c));
			}
		}

		return results;
	}

	private NodeCopy load(LoadCommand c) {
        Node node = memory.find(c.getKey());
        return node == null ? null : new NodeCopy(node);
    }

	/**
	 * return the nodecopy of the save command key to be saved into memory
	 * 
	 * @param c
	 * @return
	 */
	private NodeCopy save(SaveCommand c) {
        Node node = memory.find(c.getKey());
        if (node == null) { node = new Node(c.getKey(), c.getValue()); memory.insert(node); }
        else node.value = c.getValue();
        return new NodeCopy(node);
    }

	/**
	 * return the nodecopy of the sum command key to be saved into memory
	 * 
	 * @param c
	 * @return
	 */
	private NodeCopy sum(SumCommand c) {
        String pattern = c.getPattern();
        int wildcard = pattern.indexOf('*'), total = 0;
        for (Node node : memory.invertedPreOrder()) {
            boolean matches = wildcard < 0 ? node.key.equals(pattern)
                : node.key.length() >= pattern.length() - 1 && node.key.startsWith(pattern.substring(0, wildcard)) && node.key.endsWith(pattern.substring(wildcard + 1));
            if (matches) total += node.value;
        }
        return save(new SaveCommand(c.getKey(), total));
    }

	public List<Command> getCommands() {
		return commands;
	}
}
