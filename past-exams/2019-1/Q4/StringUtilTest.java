import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilTest {

	@Test
	void test() {
		//Failing first branch
		String failFirstBranch = "J";
		assertEquals("J", StringUtil.collapseNewlines(failFirstBranch));
		String noNewLine = "Apple\n\nApple\nApple";
		assertEquals("Apple\nApple\nApple", StringUtil.collapseNewlines(noNewLine));
		//Due to the way the method works,this will explore every different part of each branch? So this is full branch coverrage?
	}
}
