import parcel.Parcel;

import java.util.*;

public class ParcelBST extends BinarySearchTree<Parcel> implements Iterable<Parcel>  {

    public ParcelBST(Parcel value, ParcelBST leftNode, ParcelBST rightNode) {
        super(value, leftNode, rightNode);
    }

    public ParcelBST(BinarySearchTree<Parcel> parcelBST) {
        super(parcelBST.value,parcelBST.leftNode,parcelBST.rightNode);
    }

    public ParcelBST(Tree<Parcel> parcelTree) {
        super(parcelTree.value,parcelTree.leftNode,parcelTree.rightNode);
    }

    public ParcelBST(Parcel value) {
        super(value);
    }


    @Override
    public Iterator<Parcel> iterator() {
        return new IteratorPreOrder();
    }

    class IteratorPreOrder implements Iterator<Parcel> {
        // Hint: value, left/right sub-trees can be accessed by:
        //    ParcelBST.this.value    ParcelBST.this.leftNode   ParcelBST.this.rightNode
        // Or equivalently directly:
        //    value   leftNode    rightNode


        // You may add methods and variables here if you wish
        Stack<Tree<Parcel>> stack = new Stack<>();

        public IteratorPreOrder() {
            // You may add code here if you wish
            stack.push(ParcelBST.this);
        }

        @Override
        public boolean hasNext() {
            return (!this.stack.isEmpty());
        }
        @Override
        public Parcel next() {
            if (!hasNext()) {
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
    }
}
