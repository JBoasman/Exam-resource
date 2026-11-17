public class TerminalNode extends Node {
    public final String outcome;
    public TerminalNode(String outcome) {
        this.outcome = outcome;
    }

    @Override
    public int maximumDecisions() {
        return 0;
    }

    @Override
    public String classify(Spider spider) {
        return outcome;
    }

    public String getOutcome(){
        return outcome;
    }



}
