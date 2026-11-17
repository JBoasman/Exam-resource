import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 */
public class BST {	
	Node root;

	/**
	 * Node class
	 */
	public class Node {
		String value;
		Node parent;
		Node left;
		Node right;

		public Node(String value) {
			this.value = value;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

		/**
		 * @param s
		 * @return the node that has the given value.
		 */
	    public Node find(String s) {
			int cmp = s.compareTo(this.value);
			if (cmp == 0) {
				return this; //this node was a match
			} else if (cmp < 0) {
				if (this.left == null) {
					return null;
				} else {
					return this.left.find(s);
				}
			} else {
				if (this.right == null) {
					return null;
				} else {
					return this.right.find(s);
				}
			}
	    }


		/**
		 * Insert a new node into the tree
		 * @param s
		 * @return {@link Node}
		 */
		//Putting duplicates to the right of a node.
		public Node insert(String s) {
			int cmp = s.compareTo(this.value);
			if (cmp < 0) {
				if (this.left == null) {
					this.left = new Node(s);
					this.left.parent = this;
					return this.left;
				} else {
					return this.left.insert(s);
				}
			} else {
				if (this.right == null) {
					this.right = new Node(s);
					this.right.parent = this;
					return this.right;
				} else {
					return this.right.insert(s);
				}
			}
		}
		
		/**
		 * @return pre-order traversal of the nodes that have odd number of children.
		 */
		public String printOddNodes() {

            String output = new String();

			if ((this.left != null) ^ (this.right != null)) {
				output = (output + this.value + " ");
			}
			if (this.left != null) {
				output = (output + this.left.printOddNodes());
			}
			if (this.right != null) {
				output = (output + this.right.printOddNodes());
			}

			return output;
		}
	}

	public String printOddNodes() {
		return root.printOddNodes();
	}
	
	public BST() {
		root = null;
	}

	public Node insert(String value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		return root.insert(value);
	}
	
	public Node find(String s) {
		if (root == null) {
			return null;
		}
		
		return root.find(s);
	}
}