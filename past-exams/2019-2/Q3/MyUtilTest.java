package utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO: write a minimum number of JUnit test cases (assertEquals) for
 * {@code MyUtil.parseDouble} that is code complete.
 * 
 * @author dongwoo
 *
 */
public class MyUtilTest {

	@Test
	public void test() {
		//start your code
		//True
		assertEquals(0, (int) MyUtil.parseDouble(null));
		//False, False, True
		assertEquals(0, (int) MyUtil.parseDouble("NoNumber"));
		//False, True, False
		assertEquals(123.456, MyUtil.parseDouble("abc123.456efg"), 0.000001);
		//end your code
	}

}
