public class DecisionNode extends Node {
    private final Spider.Property testsFor;
    private final Node yesOutcome, noOutcome;
    public DecisionNode(Spider.Property testsFor, Node yesOutcome, Node noOutcome) {
        this.testsFor = testsFor;
        this.yesOutcome = yesOutcome;
        this.noOutcome = noOutcome;
    }

    @Override
    public int maximumDecisions() {
        return Math.max(yesOutcome.maximumDecisions(), noOutcome.maximumDecisions()) + 1;
    }

    @Override
    public String classify(Spider spider) {
        return (spider.testProperty(testsFor) ? yesOutcome : noOutcome).classify(spider);
    }


    @Override
    public String toString() {
        return describe(this, "").stripTrailing();
    }




    private static String describe(Node node, String indent) {
        if (node instanceof TerminalNode terminal) return terminal.outcome + "\n";
        DecisionNode decision = (DecisionNode) node;
        return Spider.propertyToString(decision.testsFor) + "?\n"
            + indent + "| Yes: " + describe(decision.yesOutcome, indent + "| ")
            + indent + "| No: " + describe(decision.noOutcome, indent + "| ");
    }
}
