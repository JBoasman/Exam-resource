
# BST Functions Acting on Nodes

## Find Node

    public Node find(String s) {
    int cmp = s.compareTo(this.value);
    
        if (cmp == 0) {
            return this;
        } else if (cmp < 0) {
            return left == null ? null : left.find(s);
        } else {
            return right == null ? null : right.find(s);
        }
    }

## Insert Node

    public Node insert(String s) {
    int cmp = s.compareTo(this.value);
        if (cmp == 0) {
            return this;
        } else if (cmp < 0) {
            if (this.left == null) {
                this.left = new Node(s);
                this.left.parent = this;
                return this.left;
            }
            return this.left.insert(s);
        } else {
            if (this.right == null) {
                this.right = new Node(s);
                this.right.parent = this;
                return this.right;
            }
            return this.right.insert(s);
        }
    }

## Printing values

    public String printOddNodes() {
    
        String output = new String();
    
        if ((this.left != null) ^ (this.right != null)) {
            output = (output + this.value + " ");
        }
        if (this.right != null) {
            output = (output + this.right.printOddNodes());
        }
        if (this.left != null) {
            output = (output + this.left.printOddNodes());
        }
    
        return output;
    }

# BST Functions Acting on Trees

## Find Node V1

public Boolean find(int value) {

		Node current = this.root;

		while (current != null) {
			if (value == current.value) {
				return true;
			} else if (value < current.value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

## Find Node V2
public Node find(String key) {

		Node node = null;
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
		return node;
	}


## Delete Node

    public void delete(int value) {
    Node current = root;

		// Find the target.
		while (current != null && current.value != value) {
			if (value < current.value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		//Value doesnt exist
		if (current == null) {
			return;
		}

		// Two children: copy the successor's value,
		// then make the successor the node to remove.
		if (current.left != null && current.right != null) {
			Node successor = current.right;
			while (successor.left != null) {
				successor = successor.left;
			}

			current.value = successor.value;
			current = successor;
		}

		// Current now has at most one child.
		Node child = current.left != null
				? current.left : current.right;

		if (child != null) {
			child.parent = current.parent;
		}

		if (current.parent == null) {
			root = child;
		} else if (current == current.parent.left) {
			current.parent.left = child;
		} else {
			current.parent.right = child;
		}
	}

## Sum Nodes

    public int sumEvenNodes() {
        return sumEvenNodes(this.root);
    }

	public int sumEvenNodes(Node current) {
		//start your code
		if (current == null) {
			return 0;
		}
		int count = 0;

		if ((current.left != null) && (current.right != null)) {
			count = count + current.value;
		}
		if ((current.left == null) && (current.right == null)) {
			count = count + current.value;
		}
		count = count + sumEvenNodes(current.right) + sumEvenNodes(current.left);

		return count;
	}

## Inverted Preorder

	public List<Node> invertedPreOrder() {

		List<Node> list = new LinkedList<>();

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

		return list;
	}

## Preorder with root skip

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

## Has Next and Next() 
//isEmpty because empty trees are used in place of null
//Looser Tree<Parcel> parents used instead of ParcelBST
//Ensure use of ! when using isEmpty().

        @Override
        public boolean hasNext() {
            return (!this.stack.isEmpty());
        }
        @Override
        public Parcel next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("e");
            }
            Tree<Parcel> nxt = stack.pop();
            if (!nxt.rightNode.isEmpty()) {
                stack.push(nxt.rightNode);
            }
            if (!nxt.leftNode.isEmpty()) {
                stack.push(nxt.leftNode);
            }
            return nxt.value;
        }

## Print Tree with specific requirements
	public String DNAGenerator(Integer key) {
		Node node = find(root, key);

		// The requested key does not exist.
		if (node == null) {
			return "CGTA";
		}

		// Create one builder for the entire traversal.
		StringBuilder output = new StringBuilder();
		printDNA(node, output);

		// No qualifying nodes means null; otherwise return the built string.
		return output.length() == 0 ? null : output.toString();
	}

	private void printDNA(Node node, StringBuilder output) {
		// An absent subtree contributes nothing.
		if (node == null) {
			return;
		}

		// XOR is true when exactly one child exists.
		if ((node.left != null) ^ (node.right != null)) {
			output.append(node.value);
		}

		// Both calls append to the SAME builder.
		// This question allows any traversal order.
		printDNA(node.left, output);
		printDNA(node.right, output);
	}

## Complete Iterator

        public BSTIterator(BST<T> root) {
            if (root != null && root.value != null) {
                stack.push(root);
            }
        }

        /**
         * @return true if there are more elements to iterate over, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return (!stack.isEmpty());
        }

        /**
         * Continue with pre-order traversal and return the next element.
         * <p>
         * Whenever the method is triggered,
         * -  Pop the top node from the stack.
         * -  Push the node's children (if exists) in the correct order.
         * and return the value of the top node.
         * <p>
         * Pushing the children in the correct order ensures that when you pop
         * the next node from the stack, you always get the left child first,
         * maintaining the correct pre-order sequence.
         *
         * @return the next element in the pre-order traversal.
         */
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            BST<T> nxt = stack.pop();
            if (nxt.right != null) {
                stack.push(nxt.right);
            }
            if (nxt.left != null) {
                stack.push(nxt.left);
            }
            return nxt.value;
        }
        public int size() {
            return this.stack.size();
        }
    }

## Level Traversal, returning linked list

	public List<Node> levelTraversal() {
		List<Node> ret = new LinkedList<>();
		Queue<Node> queue = new ArrayDeque<>();
		if (this.root == null) {
			return ret;
		}
		queue.add(this.root);
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			ret.add(current);
			if (current.right != null && current.right.key != null) {
				queue.add(current.right);
			}
			if (current.left != null && current.left.key != null) {
				queue.add(current.left);
			}
		}
		return ret;
	}

## Printing and Labeling tree
public int getLevelAndLabel() {
// TODO - Start your code
int level = 1 + Math.max(
this.left.getLevelAndLabel(),
this.right.getLevelAndLabel()
);
switch (level) {
case 1:
this.root.setLabel("Kid");
break;
case 2:
this.root.setLabel("Parent");
break;
case 3:
this.root.setLabel("Grandparent");
break;
default:
this.root.setLabel("Great-".repeat(level - 3) + "Grandparent");
break;
}
return level;
// TODO - End your code
}


    /**
     * Task C
     */
    @Override
    public String show() {
        // TODO - Start your code
        return show(0);
        // TODO - End your code
    }

    @Override
    public String show(int depth) {
        // TODO - Start your code
        String prefix;
        if (depth == 0) {
            prefix = "";
        } else {
            prefix = "  " + "-".repeat(4 * depth - 2);
        }
        StringBuilder output = new StringBuilder();
        output.append(prefix).append(this.root).append('\n');

        // EmptyTree.show() may return null, so only visit real subtrees.
        if (this.left.root != null) {
            output.append(this.left.show(depth + 1));
        }
        if (this.right.root != null) {
            output.append(this.right.show(depth + 1));
        }
        return output.toString();
        // TODO - End your code
    }

}

## Insert, Ordercheck, Find

    public Tree find(int id) {
    // TODO - Start your code
    if (this.root == null) {
    return null;
    }
    Tree current = this;

        while (current.root != null) {
            if (id == current.root.getId()) {
                return current;
            } else if (id < current.root.getId()) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return null;

    public boolean isOrdered() {
        // TODO - Start your code
        if (this.root == null) {
            return true;
        }
        return orderedHelper(Integer.MAX_VALUE, Integer.MIN_VALUE, this);
        // TODO - End your code
    }

    public boolean orderedHelper(int max, int min, Tree tree) {
        if (tree.root == null) {
        return true;
        }
        int current = tree.root.getId();
        if (current > max || current <= min) {
            return false;
        } else {
            return orderedHelper(current, min, tree.right) && orderedHelper(max, current, tree.left);
        }
    }

    public void insert(int newId) {
        Person toInsert = new Person(newId);
        //Can we assume never handed an EmptyTree because this
        // method acts on a FamilyTree?
        int current = this.root.getId();
        if (newId <= current) {
            if (this.right.root == null) {
                this.right = new FamilyTree(toInsert);
            } else {
                this.right.insert(newId);
            }
        } else {
            if (this.left.root == null) {
                this.left = new FamilyTree(toInsert);
            } else {
                this.left.insert(newId);
            }
        }
    }

## Constructors
    public FamilyTree(Person value) {
        this.root = value;
        this.left = new EmptyTree();
        this.right = new EmptyTree();
    }

    public FamilyTree(Person value, Tree left, Tree right) {
        this.root = value;
        this.left = left;
        this.right = right;
    }

## Recursive Tree property checkers with Helpers
public Boolean testProp1() {
return (checkProp1(this.root));
}

	public boolean checkProp1(Node<T> node) {
		if (node == null) {
			return true;
		} else if (node.colour == Colour.VIOLET) {
			return false;
		} else {
			return checkProp1(node.left) && checkProp1(node.right);
		}
	}

	/**
	 * Implement this method to check the property2. You may define additional
	 * helper methods to complete the task
	 * 
	 * @return
	 */
	public Boolean testProp2() {
		if (this.root == null) {
			return true;
		}
		if (this.root.colour != Colour.PINK) {
			return false;
		}
		return (checkProp2(this.root));
	}

	public boolean checkProp2(Node<T> node) {
		boolean l = true;
		boolean r = true;
		if (node.left == null && node.right == null) {
			if (node.colour != Colour.PINK) {
				return false;
			}
		}
		if (node.left != null) {
			l = checkProp2(node.left);
		}
		if (node.right != null) {
			r = checkProp2(node.right);
		}
		return l && r;
	}

	/**
	 * Implement this method to check the property3. You may define additional
	 * helper methods to complete the task
	 * 
	 * @return
	 */
	public Boolean testProp3() {
		if (checkProp3(this.root) == -1) {
			return false;
		}
		return true;
	}

	public int checkProp3(Node<T> node) {
		if (node == null) {
			return 0;
		}
		int l = checkProp3(node.left);
		int r = checkProp3(node.right);
		if (l == -1 || r == -1 || l != r) {
			return -1;
		}
		if (node.colour == Colour.PINK) {
			return 1 + l;
		}
		return l;

	}

	/**
	 * Implement this method to check the property4. You may define additional
	 * helper methods to complete the task
	 * 
	 * @return
	 */
	public Boolean testProp4() {
		//START YOUR CODE
		return checkProp4(this.root);
		//END YOUR CODE
	}

	private boolean checkProp4(Node<T> node) {
		if (node == null) {
			return true;
		}

		if (node.colour == Colour.MAGENTA) {
			// Neither child may be MAGENTA.
			if ((node.left != null && node.left.colour == Colour.MAGENTA)
					|| (node.right != null && node.right.colour == Colour.MAGENTA)) {
				return false;
			}

			// At least one child must be PURPLE.
			boolean leftPurple = node.left != null && node.left.colour == Colour.PURPLE;
			boolean rightPurple = node.right != null && node.right.colour == Colour.PURPLE;
			if (!leftPurple && !rightPurple) {
				return false;
			}
		}

		// Check the rule throughout both subtrees.
		return checkProp4(node.left) && checkProp4(node.right);
	}
