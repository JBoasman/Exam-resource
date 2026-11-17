import org.junit.Test;
import static org.junit.Assert.*;
public class ParserEdgeTest {
    @Test public void rejectsIncompleteAndInvalidExpressions() {
        for (String input : new String[]{"", ";", "x+", "3 4", "x;;y", "X", "x@", "1+;", "999999999999999999999"})
            assertNull(input, new Parser(new Tokeniser(input)).parse());
    }
    @Test public void followsRightRecursiveGrammarRatherThanConventionalPrecedence() {
        assertEquals("(3 SUBTRACT (2 SUBTRACT 1))", new Parser(new Tokeniser("3-2-1")).parse().show());
        assertEquals("x; y", new Parser(new Tokeniser("x;y;")).parse().show());
    }
}
