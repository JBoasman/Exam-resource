/** Correct immutable AVL example for revision; SampleAVLTree remains the faulty test subject. */
public class ReferenceAVLTree extends AVLTree {
    public ReferenceAVLTree(int value) { super(value); }
    private ReferenceAVLTree(int value, AVLTree left, AVLTree right) { super(value, left, right); }
    @Override protected AVLTree createNode(int value, AVLTree left, AVLTree right) {
        return new ReferenceAVLTree(value, left, right);
    }
    @Override public AVLTree insert(Integer value) {
        if (value == null) throw new IllegalArgumentException("Null key");
        int comparison = value.compareTo(this.value);
        if (comparison == 0) return this;
        AVLTree left = leftNode, right = rightNode;
        if (comparison < 0) left = left == null ? new ReferenceAVLTree(value) : left.insert(value);
        else right = right == null ? new ReferenceAVLTree(value) : right.insert(value);
        AVLTree result = createNode(this.value, left, right);
        if (result.getBalanceFactor() > 1) {
            if (left.getBalanceFactor() < 0) result = createNode(result.value, left.leftRotate(), right);
            return result.rightRotate();
        }
        if (result.getBalanceFactor() < -1) {
            if (right.getBalanceFactor() > 0) result = createNode(result.value, left, right.rightRotate());
            return result.leftRotate();
        }
        return result;
    }
}
