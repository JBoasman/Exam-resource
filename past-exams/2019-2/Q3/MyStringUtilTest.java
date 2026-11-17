package utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO: write a minimum number of JUnit test cases (assertEquals) for
 * {@code MyStringUtil.isMixedCase} that is branch complete.
 */
public class MyStringUtilTest {

	@Test
	public void test() {
		//start your code
		//B1 True
		assertFalse(MyStringUtil.isMixedCase(null));
		//B1 False, B2 True
		assertFalse(MyStringUtil.isMixedCase(""));
		//B1 and B2 False
		//B3 True and False, B4 True and False, B5 True and False, B6 True and False
		assertTrue(MyStringUtil.isMixedCase("Both"));
		//Exit Branch True
		assertTrue(MyStringUtil.isMixedCase("aB"));
		assertFalse(MyStringUtil.isMixedCase("a"));
        assertFalse(MyStringUtil.isMixedCase("B"));
        //end your code
	}

}
