public abstract class Node {
    public abstract int maximumDecisions();

    public String classify(Spider spider) {
        throw new UnsupportedOperationException("Subclasses implement classification");
    }

}
