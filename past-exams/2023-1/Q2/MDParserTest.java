package Q2;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class MDParserTest {
    @Test public void indentationDeterminesParentsAndPreorder() {
        ListElementsTree tree = new MDParser(new MDTokenizer("- A\n    1. B\n        - C\n    - D\n- E\n\n")).parse();
        assertEquals(List.of("A", "B", "C", "D", "E"), tree.preOrderWalk());
        assertEquals(2, tree.root.getChildren().size());
        assertEquals(2, tree.root.getChildren().get(0).getChildren().size());
        assertEquals("C", tree.root.getChildren().get(0).getChildren().get(0).getChildren().get(0).getValue());
    }
    @Test public void blankInputHasNoListItems() {
        assertTrue(new MDParser(new MDTokenizer("  \n")).parse().preOrderWalk().isEmpty());
    }
}
