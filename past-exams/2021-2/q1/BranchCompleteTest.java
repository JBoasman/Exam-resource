import org.junit.Test;

import static org.junit.Assert.*;

public class BranchCompleteTest {

	@Test(timeout = 1000)
	public void test() {
        // Cover both outcomes of each short-circuit operand as well as each if.
        assertTrue(BranchComplete.findSomething(-10, -1, -100));
        assertTrue(BranchComplete.findSomething(1, -1, 0));
        assertFalse(BranchComplete.findSomething(-1, -2, 0));
        assertFalse(BranchComplete.findSomething(1, 1, 1));
        assertTrue(BranchComplete.findSomething(2, 3, 1));
        assertFalse(BranchComplete.findSomething(1, 2, 1));
    }
}
