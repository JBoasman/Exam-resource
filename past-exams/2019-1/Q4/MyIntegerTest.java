
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyIntegerTest {

	@Test
	void test() {
		String tooLow = "/"; //5
		String tooHigh = ":"; //60
		String justRight = "123"; //50
		assertThrows(NumberFormatException.class, () -> MyInteger.parseInt(tooLow));
		assertThrows(NumberFormatException.class, () -> MyInteger.parseInt(tooHigh));
		assertEquals(123, MyInteger.parseInt(justRight));


		// TODO: Write a minimum set of test cases that are code complete 
		// for MyInteger.parseInt method.
		// Use assertEquals and assertThrows to test whether the method works as expected. 
		// 
		// All test cases should be included in this method. Do not create another method. 
		// Auto grader will not check the other methods created individually.
		
	}

}
