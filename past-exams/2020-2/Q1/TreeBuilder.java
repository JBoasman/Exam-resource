
import java.util.List;

public class TreeBuilder {

    public RBTree<Integer, List<String>> build(String text) {
        RBTree<Integer, List<String>> tree = new RBTree<>();
        MyTokenizer tokenizer = new MyTokenizer(text);
        while (tokenizer.hasNext()) {
            Token token = tokenizer.current();
            if (token.getType() == Token.Type.UPPER_CASE_WORD) {
                List<String> words = tree.getData(token.getLength());
                if (words == null) {
                    words = new java.util.ArrayList<>();
                    tree.insert(token.getLength(), words);
                }
                if (!words.contains(token.getValue())) words.add(token.getValue());
            }
            tokenizer.next();
        }
        return tree;
    }




}
