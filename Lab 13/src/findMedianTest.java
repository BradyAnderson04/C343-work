import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class findMedianTest {

	@Test
	public void test() {
		// test data setup
		ArrayList<Integer> data = new ArrayList<Integer>();
		ArrayList<Integer> data1 = new ArrayList<Integer>();
		data.add(8);
		data.add(5);
		data.add(2);
		data.add(1);
		data.add(3);
		data.add(7);
		data.add(9);
		for(int i = 0; i < 10001; i++) {
			data1.add(i);
		}
		// test objects
		findMedian testObject = new findMedian(data);
		findMedian testObject1 = new findMedian(data1);
		
		// tests setup
		Integer test = testObject.select(testObject.getList().size()/2, 0, testObject.getList().size());
		Double test1 = testObject.simpleMedian();
		
		Integer test2 = testObject1.select(testObject1.getList().size()/2, 0, testObject1.getList().size());
		Double test3 = testObject1.simpleMedian();
		
		// tests
		assertTrue(5 == test);
		assertTrue(5.0 == test1);
		
		assertTrue(5000   == test2);
		assertTrue(5000.0 == test3);
	}

}
