import java.awt.Rectangle;
import java.util.*;

/*
A component that takes a superclass rectangle and makes a square subclass 
*/

/**
 * @author bradyanderson
 *
 */
public class Square extends Rectangle {
	// initialize values of Sqaure class -> for getters and setters
	private int side = 0;
	private int x = 0;
	private int y = 0;

	// constructor -> this will basically get properties from rectangle constructor
	public Square(int x, int y, int side) {
		// constructor - get properties from superclass
		super(x, y, side, side);
	}
	
	// find area of a square
	public double getArea() {
		// since a square width == height
		double area = getWidth() * getWidth();
		return area;
	}
	
	// print out details of the square -> overwrites the rectangle toString method
	public String toString() {
		// X Y Length Area
		return "X-value: " + getX() + getWidth()/2 +", Y-value: " + getY() + getHeight()/2 +", Length: "+ getWidth() + ", Area: " + getArea();
	}
	
	// test code here -> see if desired output achieved
	public static void main(String[] args) {
		// ArrayList of square class and random to generate random squares
		ArrayList<Square> squares = new ArrayList<Square>();
		Random rn = new Random();
		
		// generate random squares here
		for(int i = 0; i<5; i++) {
			Square s = new Square(rn.nextInt(30), rn.nextInt(30), rn.nextInt(10));
			squares.add(s);
		}
		// testing here
		for(int j = 0; j<5; j++) {
			System.out.println(squares.get(j).toString());
		}
	}
}
