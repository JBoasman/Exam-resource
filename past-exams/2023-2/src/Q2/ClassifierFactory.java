import java.util.*;

public class ClassifierFactory {


    public static Node createClassifier(Set<Spider> possibilities) {
        return build(possibilities, new HashMap<>());
    }

    private static Node build(Set<Spider> spiders, Map<Set<Spider>, Node> memo) {
        if (spiders.size() == 1) return new TerminalNode(spiders.iterator().next().speciesName);
        if (memo.containsKey(spiders)) return memo.get(spiders);
        Node best = null;
        int height = Integer.MAX_VALUE;
        for (Spider.Property property : Spider.Property.values()) {
            Set<Spider> yes = new HashSet<>(), no = new HashSet<>();
            for (Spider spider : spiders) (spider.testProperty(property) ? yes : no).add(spider);
            if (yes.isEmpty() || no.isEmpty()) continue;
            Node left = build(yes, memo), right = build(no, memo);
            if (left == null || right == null) continue;
            Node candidate = new DecisionNode(property, left, right);
            if (candidate.maximumDecisions() < height) { best = candidate; height = best.maximumDecisions(); }
        }
        memo.put(new HashSet<>(spiders), best);
        return best;
    }
}
