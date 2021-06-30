import static org.junit.Assert.*;

import org.junit.Test;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Final Project
//@Author  Brady Anderson
//Explain: 
//		test my polar complex objects
///////////////////////////////////////////////////////////////////////////////////

public class PolarComplexTest {

	@Test
	public void test() {
		// testObjects
		PolarComplex testObject = new PolarComplex(2.0, 1.2);
		PolarComplex testObject2 = new PolarComplex(2.0, 1.2);
		PolarComplex testObject3 = new PolarComplex(3.0, .9);
		
		// tests to run
		String testToString = testObject.toString();
		PolarComplex testGetConjugate = testObject.getConjugate();
		PolarComplex testGetPolarComplex = testObject.getPolarComplex();
		StandardComplex testGetStandardComplex = testObject.getStandardComplex();
		Boolean testIsEqual = testObject.isEqual(testObject2);
		Boolean testIsEqual2 = testObject.isEqual(testObject3);
		PolarComplex testAdd = testObject.add(testObject2);
		PolarComplex testAdd1 = testObject.add(testObject3);
		PolarComplex testSubtract = testObject.subtract(testObject2);
		PolarComplex testSubtract1 = testObject.subtract(testObject3);
		PolarComplex testMultiply = testObject.multiply(testObject2);
		PolarComplex testMultiply1 = testObject.multiply(testObject3);
		PolarComplex testDivide = testObject.divide(testObject2);
		PolarComplex testDivide1 = testObject.divide(testObject3);
		
		// testing area -> converting output to string
		assertEquals("2.0( cos1.2 + i sin1.2)", testToString);
		assertEquals("2.0( cos-1.2 + i sin-1.2)", testGetConjugate.toString());
		assertEquals("2.0( cos1.2 + i sin1.2)", testGetPolarComplex.toString());
		assertEquals("0.7247155089533472+ 1.8640781719344526i", testGetStandardComplex.toString());
		assertEquals(true ,testIsEqual);
		assertEquals(false, testIsEqual2);
		assertEquals("1.4494310179066945( cos3.728156343868905 + i sin3.728156343868905)",testAdd.toString());
		assertEquals("2.5895454137653404( cos4.214058900816903 + i sin4.214058900816903)",testAdd1.toString());
		assertEquals("0.0( cos0.0 + i sin0.0)",testSubtract.toString());
		assertEquals("-1.140114395858646( cos-0.4859025569479978 + i sin-0.4859025569479978)",testSubtract1.toString());
		assertEquals("-0.8257137921847928( cos1.876138930019811 + i sin1.876138930019811)",testMultiply.toString());
		assertEquals("-2.124717566353394( cos4.827659873507885 + i sin4.827659873507885)",testMultiply1.toString());
		assertEquals("1.0( cos0.0 + i sin0.0)",testDivide.toString());
		assertEquals("0.6368909927504041( cos0.19701347110755962 + i sin0.19701347110755962)",testDivide1.toString());
	}

}
