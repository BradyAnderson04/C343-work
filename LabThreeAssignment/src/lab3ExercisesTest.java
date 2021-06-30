import static org.junit.Assert.*;

import org.junit.Test;

public class lab3ExercisesTest {

	@Test
	public void test() {
		String output = lab3Exercises.formatPhoneNumber("1234567899", true);
		String output1 = lab3Exercises.formatPhoneNumber("1234567899", false);
		String output2= lab3Exercises.grade('A');
		String output3 = lab3Exercises.grade('F');
		String output4 = lab3Exercises.grade('Z');
		String output5 = lab3Exercises.intToHex(1000000);
		String output6 = lab3Exercises.intToHex(348);
		// function formatPhoneNumber jUnit Tests
		assertEquals("(123) 456-7899" , output);
		assertEquals("123-456-7899",output1);
		// function grade jUnit tests
		assertEquals("Your grade is between 93.0 and 100.0" ,output2);
		assertEquals("Your grade is less than 63.0" ,output3);
		assertEquals("Not a valid grade letter", output4);
		// function hexToInt jUnit Tests
		assertEquals("F4240",output5);
		assertEquals("15C", output6);
	}

}
