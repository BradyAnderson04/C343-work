import static org.junit.Assert.*;

import org.junit.Test;

public class shapeTest {

	@Test
	public void test() {
		// test structures
		int[] a = {200, 210, 220, 230, 240};
		int[] b = {200, 210, 220, 230, 240};
		int[] c = {200, 210, 220, 230};
		int[] d = {200, 210, 220, 230};
		int[] e = {200, 210, 220, 230, 240, 250, 260, 270};
		int[] f = {200, 210, 220, 230, 240, 250, 260, 270};
		// test poly, quad, oval, tri, pent, hex, rect, circ, square
		// create test objects
		Polygon test1 = new Polygon(200, 200, 12, e ,f);
		Quadrilateral test2 = new Quadrilateral(200, 200, 20, 20);
		Oval test3 = new Oval(200, 200, 20, 20);
		Triangle test4 = new Triangle(200, 200, 20, 20);
		Pentagon test5 = new Pentagon(200, 200, 5, c ,d);
		Hexagon test6 = new Hexagon(200, 200, 6, a ,b);
		Rectangle test7 = new Rectangle(200, 200, 20, 20);
		Circle test8 = new Circle(200, 200, 20);
		Square test9 = new Square(200, 200, 20);
		
		// actual tests here
		assertEquals("This is a polygon. The X Position: 200,the Y Position: 200", test1.toString());
		assertEquals(false ,test1.equals(test1, test2));
		assertEquals(true ,test1.equals(test1, test1));
		
		assertEquals("This is a class Quadrilateral. The X Position: 200,the Y Position: 200. The width of the object is: 20.0, while the length of the object is: 20.0" ,test2.toString());
		assertEquals(false ,test2.equals(test2, test1));
		assertEquals(true ,test1.equals(test2, test2));
		
		assertEquals("This is a class Oval. The X Position: 200,the Y Position: 200. The width of the object is: 20.0, while the length of the object is: 20.0" ,test3.toString());
		assertEquals(false ,test1.equals(test3, test2));
		assertEquals(true ,test1.equals(test3, test3));
		
		assertEquals("This is a class Triangle. The X Position: 200,the Y Position: 200. The width of the object is: 20.0, while the length of the object is: 20.0",test4.toString());
		assertEquals(false ,test1.equals(test4, test2));
		assertEquals(true ,test1.equals(test4, test4));
		
		assertEquals("This is a polygon. The X Position: 200,the Y Position: 200", test5.toString());
		assertEquals(false ,test1.equals(test5, test2));
		assertEquals(true ,test1.equals(test5, test5));
		
		assertEquals("This is a class Hexagon. The X Position: 200,the Y Position: 200. The width of the object is: null, while the length of the object is: null" ,test6.toString());
		assertEquals(false ,test1.equals(test6, test2));
		assertEquals(true ,test1.equals(test6, test6));
		
		assertEquals("This is a class Rectangle. The X Position: 200,the Y Position: 200. The width of the object is: 20.0, while the length of the object is: 20.0" ,test7.toString());
		assertEquals(false ,test1.equals(test7, test2));
		assertEquals(true ,test1.equals(test7, test7));
		
		assertEquals( "This is a class Circle. The X Position: 200,the Y Position: 200. The width of the object is: 20.0, while the length of the object is: 20.0",test8.toString());
		assertEquals(false ,test1.equals(test8, test2));
		assertEquals(true ,test1.equals(test8, test8));
		
		assertEquals("This is a class Square. The X Position: 200,the Y Position: 200. The width of the object is: 20.0, while the length of the object is: 20.0" ,test9.toString());
		assertEquals(false ,test1.equals(test9, test2));
		assertEquals(true ,test1.equals(test9, test9));
		
	}

}
