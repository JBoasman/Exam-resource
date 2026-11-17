package Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListElementsTree {
    Node root;

    public ListElementsTree() {
        this.root = new Node(MDTokenType.LIST_ROOT.toString());
    }

    public Node insert(MDToken child) {
        return this.root.insert(child.getContent());
    }

    public List<String> preOrderWalk() {

        List<String> list = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        if (this.root == null) {
            return list;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current != this.root) {
                list.add(current.value);
            }
            List<Node> children = current.getChildren();
            int index = children.size() - 1;
            while (index >= 0) {
                stack.push(children.get(index)); //index of list retrieval
                index--;
            }
        }

        return list;
    }




    /** Note: this method is created for testing ONLY. It should not be used in your submissions. */
    public ListElementsTree(String rootValue, List<String> childrenValues) {
        this.root = new Node(rootValue);
        for (String childValue : childrenValues) {
            Node child = new Node(childValue);
            this.root.children.add(child);
        }
    }

    /** Note: this method is created for testing ONLY. It should not be used in your submissions. */
    public Node insertTree(ListElementsTree tree) {
        this.root.children.add(tree.root);
        return tree.root;
    }



    /**
     * Node
     */
    public class Node {
        private String value;
        private List<Node> children;

        public Node(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }


        public Node insert(String value) {
            Node child = new Node(value);
            children.add(child);
            return child;
        }


        public List<Node> getChildren() {
            return children;
        }

        public String getValue() {
            return value;
        }

    }


}
