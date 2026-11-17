/**
 * A concrete implementation of tree.
 *
 * Ordered in a right-to-left manner based on the id of nodes.
 * During insertion, a new node with a greater ID should go to the left sub-tree,
 * whereas nodes with a smaller or equal ID goes to the right.
 */
public class FamilyTree extends Tree {

    /**
     * Task A
     */
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


    /**
     * Task B
     */
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

        // TODO - End your code
    }

    public boolean isOrdered() {
        // TODO - Start your code
        if (this.root == null) {
            return true;
        }
        return orderedHelper(Long.MAX_VALUE, Long.MIN_VALUE, this);
        // TODO - End your code
    }

    public boolean orderedHelper(long max, long min, Tree tree) {
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


    /**
     * Label the nodes in the tree by its family role.
     *
     * Family role for a node is assigned relative to its youngest descendant.
     *
     * The labeling follows a bottom-up approach where:
     * - Leaf nodes (deepest non-empty nodes) are at level 1 and are labelled as "Kid".
     * - Their direct parents are at level 2 and labelled as "Parent".
     * - The next level up is labelled "Grandparent" (level 3).
     * - Subsequent levels continue with "Great-Grandparent" (level 4), "Great-Great-Grandparent" (level 5), and so on.
     *
     * @return the level of the current node.
     */
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
