import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author brady anderson
 *
 * February 11, 2019
 * 
 * jUnit test for validShuffle class
 */

public class validShuffleTest {

	@Test
	public void test() {
		Boolean test1 = validShuffle.isValid("abc", "def", "adbecf");
		Boolean test2 = validShuffle.isValid("abc", "de", "abcdef");
				
		assertEquals(true, test1);
		assertEquals(false, test2);
	}

}
