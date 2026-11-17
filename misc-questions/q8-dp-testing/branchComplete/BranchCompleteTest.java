import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BranchCompleteTest {

	@Test
	public void test() {

		// TODO
		// START YOUR CODE
		// HINT: assertEquals(result, BranchComplete.findSomething(a, b, c, d));
		//True, True, True
		assertEquals("Test1",-10, BranchComplete.findSomething(-10, 10, 0, 0));
		//False, True, False
		assertEquals("Test3",0, BranchComplete.findSomething(0, 20, 0, 0));
		//False, False-True
		assertEquals("Test4",10, BranchComplete.findSomething(10, 10, 0, 0));
		//False, False-False-True
		assertEquals("Test5",20, BranchComplete.findSomething(20, 10, 20, 20));
		assertEquals(1, BranchComplete.findSomething(0, -1, 0, 0));
        assertEquals(1, BranchComplete.findSomething(0, 0, -1, 0));
        assertEquals(0, BranchComplete.findSomething(0, 0, 0, -1));
        // END YOUR CODE
	}
}
