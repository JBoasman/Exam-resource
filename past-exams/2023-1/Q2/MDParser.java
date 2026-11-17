package Q2;


public class MDParser {
    MDTokenizer tokenizer;

    public MDParser(MDTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public ListElementsTree parse() {
        ListElementsTree tree = new ListElementsTree();
        java.util.List<ListElementsTree.Node> parents = new java.util.ArrayList<>();
        parents.add(tree.root);
        while (tokenizer.hasNext()) {
            MDToken token = tokenizer.next();
            int level = token.getLevel();
            while (parents.size() > level) parents.remove(parents.size() - 1);
            ListElementsTree.Node child = parents.get(level - 1).insert(token.getContent());
            parents.add(child);
        }
        return tree;
    }


}
