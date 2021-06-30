import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author brady anderson
 *
 * February 11, 2019
 * 
 * roman class jUnit test
 */


public class romanTest {

	@Test
	public void test() {
		int test1 = roman.calculateDecimalVal("CMXXXIX");
		int test2 = roman.calculateDecimalVal("MCMLXXVIII");
				
		assertEquals(939 , test1);
		assertEquals(1978, test2);
	}

}
