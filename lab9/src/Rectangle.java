import java.awt.Color;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab8
//@Author  Brady Anderson
//Explain: 
// 		creates a recantangle
///////////////////////////////////////////////////////////////////////////////////

public class Rectangle extends Quadrilateral{

	// additional instance variables

	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Rectangle(Color fillColor,Color borderColor, int x, int y, double width, double length, int dx, int dy) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y, width, length, dx, dy);
	}
	 
	// set borderColor to Black since not provided     
	public Rectangle(Color fillColor, int x, int y, double width, double length, int dx, int dy) {
		super(fillColor, x, y, width, length, dx, dy);
		setWidth(width);
		setLength(length);
	}
	
	// set fillColor to white and border color to black     
	public Rectangle(int x, int y, double width, double length, int dx, int dy) { 
		super(x, y, width, length, dx, dy);
		setWidth(width);
		setLength(length);
	}

	// other methods here
	public String toString() {
		return super.toString();
		
	}
}
