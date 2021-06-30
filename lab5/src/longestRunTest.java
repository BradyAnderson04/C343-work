import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class longestRunTest {

	@Test
	public void test() {
		// ran out of time writing this. Did not want to get late points
		String test1 = longestRun.checkLongest((ArrayList<Integer>)Arrays.asList(5, 1, 3, 6, 5, 6, 2, 3, 5, 3, 5, 3, 1, 4, 1, 2, 1, 2, 6, 5));
		String test2 = longestRun.checkLongest((ArrayList<Integer>) Arrays.asList(1, 3, 1, 2, 6, 5, 2, 6, 2, 2, 2, 4, 2, 4, 3, 1, 6, 1, 1, 2));
	
		
		assertEquals("(5) 1 3 6 5 6 2 3 5 3 5 3 1 4 1 2 1 2 6 5 ", test1);
		assertEquals("1 3 1 2 6 5 2 6 (2 2 2) 4 2 4 3 1 6 1 1 2 ", test2);
	}

}
