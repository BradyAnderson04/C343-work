import static org.junit.Assert.*;
import org.junit.Test;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Final Project
//@Author  Brady Anderson
//Explain: 
//		Test all operations of my standard complex number
///////////////////////////////////////////////////////////////////////////////////

public class StandardComplexTest {

	@Test
	public void test() {
		// testObjects
		StandardComplex testObject = new StandardComplex(2.0, 4.0);
		StandardComplex testObject2 = new StandardComplex(2.0, 4.0);
		StandardComplex testObject3 = new StandardComplex(3.0, 4.0);
		
		// tests to run
		String testToString = testObject.toString();
		StandardComplex testGetConjugate = testObject.getConjugate();
		PolarComplex testGetPolarComplex = testObject.getPolarComplex();
		StandardComplex testGetStandardComplex = testObject.getStandardComplex();
		Boolean testIsEqual = testObject.isEqual(testObject2);
		Boolean testIsEqual2 = testObject.isEqual(testObject3);
		StandardComplex testAdd = testObject.add(testObject2);
		StandardComplex testAdd1 = testObject.add(testObject3);
		StandardComplex testSubtract = testObject.subtract(testObject2);
		StandardComplex testSubtract1 = testObject.subtract(testObject3);
		StandardComplex testMultiply = testObject.multiply(testObject2);
		StandardComplex testMultiply1 = testObject.multiply(testObject3);
		StandardComplex testDivide = testObject.divide(testObject2);
		StandardComplex testDivide1 = testObject.divide(testObject3);
//		
		// testing area -> converting output to string
		// purpose of jUnit is to check for side effects in code
		assertEquals("2.0+ 4.0i", testToString);
		assertEquals("2.0+ -4.0i", testGetConjugate.toString());
		assertEquals("4.47213595499958( cos1.1071487177940904 + i sin1.1071487177940904)", testGetPolarComplex.toString());
		assertEquals("2.0+ 4.0i", testGetStandardComplex.toString());
		assertEquals(true ,testIsEqual);
		assertEquals(false, testIsEqual2);
		assertEquals("4.0+ 8.0i",testAdd.toString());
		assertEquals("5.0+ 8.0i",testAdd1.toString());
		assertEquals("0.0+ 0.0i",testSubtract.toString());
		assertEquals("-1.0+ 0.0i",testSubtract1.toString());
		assertEquals("-12.0+ 16.0i",testMultiply.toString());
		assertEquals("-10.0+ 20.0i",testMultiply1.toString());
		assertEquals("1.0+ 0.8i",testDivide.toString());
		assertEquals("0.88+ 0.8i",testDivide1.toString());
	}

}
