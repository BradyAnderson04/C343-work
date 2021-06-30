import static org.junit.Assert.*;

import org.junit.Test;

public class Part1Test {

	@Test
	public void test() {
		// create test objects
		Part1 test1 = new Part1();
		
		assertEquals("The shortest distances from starting point to end point:\n" + 
				"c3: 7\n" + 
				"c4: 4\n" + 
				"c5: 1\n" + 
				"c6: 4\n" + 
				"c7: 7\n" + 
				"c8: 10\n" + 
				"c1: 0\n" + 
				"c2: 3", test1);
	}

}
