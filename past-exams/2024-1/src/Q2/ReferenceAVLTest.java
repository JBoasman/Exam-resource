import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ReferenceAVLTest {
    @Test public void allFourRotationsPreserveOriginal() {
        for (int[] values : new int[][]{{3,2,1},{1,2,3},{3,1,2},{1,3,2}}) {
            AVLTree original = new ReferenceAVLTree(values[0]);
            AVLTree result = original.insert(values[1]).insert(values[2]);
            assertEquals(List.of(2,1,3), result.preOrder());
            assertEquals(List.of(values[0]), original.preOrder());
            assertTrue(Math.abs(result.getBalanceFactor()) <= 1);
        }
    }
    @Test public void nestedInsertionKeepsEverySubtreeBalanced() {
        AVLTree tree = new ReferenceAVLTree(0);
        for (int value = 1; value <= 100; value++) { tree = tree.insert(value); check(tree, Long.MIN_VALUE, Long.MAX_VALUE); }
        assertEquals(101, tree.preOrder().size());
        assertEquals(tree.preOrder(), tree.insert(0).preOrder());
    }
    private void check(AVLTree tree, long low, long high) {
        if (tree == null) return;
        assertTrue(tree.value > low && tree.value < high);
        assertTrue(Math.abs(tree.getBalanceFactor()) <= 1);
        check(tree.leftNode, low, tree.value); check(tree.rightNode, tree.value, high);
    }
}
