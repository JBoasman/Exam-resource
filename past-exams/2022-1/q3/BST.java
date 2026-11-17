import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BST {

	private Node root;

	public BST() {
		this.root = null;
	}

	public void insert(Node node) {
		if (this.root == null) {
			this.root = node;
		} else {
			Node parent = null;
			Node current = this.root;
			while (current != null) {
				if (current.key.compareTo(node.key) < 0) {
					parent = current;
					current = current.right;
				} else if (current.key.compareTo(node.key) > 0) {
					parent = current;
					current = current.left;
				} else {
					break;
				}
			}

			if (parent.key.compareTo(node.key) < 0) {
				parent.right = node;
			} else if (parent.key.compareTo(node.key) > 0) {
				parent.left = node;
			}
		}
	}

	public Node find(String key) {

		Node node = null;

		// TODO
		// ########## YOUR CODE STARTS HERE ##########
		if (root == null) {
			return node;
		}
		node = this.root;
		while (node != null) {
			int cmp = key.compareTo(node.key);
			if (cmp == 0) {
				return node;
			} else if (cmp < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		// ########## YOUR CODE ENDS HERE ##########

		return node;
	}

	public List<Node> invertedPreOrder() {

		List<Node> list = new LinkedList<>();

		// TODO
		// ########## YOUR CODE STARTS HERE ##########

		Stack<Node> stack = new Stack<>();
		if (this.root == null) {
			return list;
		}
		stack.push(root);

		while (!stack.isEmpty()) {
			Node current = stack.pop();
			list.add(current);
			if (current.left != null) {
				stack.push(current.left);
			}
			if (current.right != null) {
				stack.push(current.right);
			}
		}

		// ########## YOUR CODE ENDS HERE ##########

		return list;
	}

}