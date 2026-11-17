import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

public class RBTreeLevelTraversalTest {
    @Test
    public void emptyTree() {
        assertTrue(new RBTree<Integer, String>().levelTraversal().isEmpty());
    }

    @Test
    public void singleNodeSkipsSentinelChildren() {
        RBTree<Integer, String> tree = new RBTree<>();
        tree.insert(33, "root");
        List<Node> nodes = tree.levelTraversal();
        assertEquals(1, nodes.size());
        assertSame(tree.root, nodes.get(0));
    }

    @Test
    public void visitsLevelsFromRightToLeft() {
        RBTree<Integer, String> tree = new RBTree<>();
        for (int key : new int[]{33, 11, 88, 10, 16, 43}) {
            tree.insert(key, "person");
        }
        List<Object> keys = tree.levelTraversal().stream()
                .map(Node::getKey).collect(Collectors.toList());
        assertEquals(Arrays.asList(33, 88, 11, 43, 16, 10), keys);
    }
}
