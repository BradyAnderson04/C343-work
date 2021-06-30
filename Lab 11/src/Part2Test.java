import static org.junit.Assert.*;

import org.junit.Test;

public class Part2Test {

	@Test
	public void test() {
		// create test objects
		Portfolio test = new Portfolio("Test");
		test.buyStock("Google", 50, 250);
		String test1 = test.sellStock("Google", 20, 300);
		
		assertEquals("Hey Test, you made 1000.0 Dollars!", test1);
	}
}
