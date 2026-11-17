import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * You are given a java class called Something, which has a method called
 * someMethod. Please implement a minimum number of test cases for testing `someMethod`
 * that are branch complete within `someMethod`. Write your test case(s) in test() method in
 * `SomethingTest.java`. You are not allowed to alter the signatures of the given
 * methods and the package structures of the given classes. Please upload the
 * `SomethingTest.java` file to Wattle for marking.
 *
 *
 * @author nanwang
 *
 */
public class SomethingTest {

	@Test
	public void test() {
		// Implement your test cases
		// START YOUR CODE

		//False, Skip, True
		assertEquals(47, Something.someMethod(10, 10, 31, 16));

		//True, True, False
		assertEquals(138, Something.someMethod(36, 36, 15, 30));

		//True, False, False
		assertEquals(108, Something.someMethod(72, 36, 2, 1));

		// END YOUR CODE
	}
}
