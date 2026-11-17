import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Fill in the items below with your UID and name:
 * @author:
 * @UID:
 */
public class BSTBranchCompleteTest {
	@Test(timeout=1000)
	public void test() {
		
		BranchComplete bc = new BranchComplete();

		// START YOUR CODE
		//False, --, False
		assertEquals(0, bc.DNATreeCalc(1, 1, 1));
		//True, False, True
		assertEquals(208, bc.DNATreeCalc(209, 210, 0));
		//True, True, False
		assertEquals(417, bc.DNATreeCalc(209, 1, -208));
		// END YOUR CODE
	}
}
