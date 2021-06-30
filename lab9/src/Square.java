import java.awt.Color;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab8
//@Author  Brady Anderson
//Explain: 
//		creates a square using a lot of inheritance
///////////////////////////////////////////////////////////////////////////////////

public class Square extends Rectangle{

	// additional instance variables
	double sideLength;

	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Square(Color fillColor,Color borderColor, int x, int y, double sideLength, int dx, int dy) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y, sideLength, sideLength,dx, dy);
	}
	 
	// set borderColor to Black since not provided     
	public Square(Color fillColor, int x, int y, double sideLength, int dx, int dy) {
		super(fillColor, x, y, sideLength, sideLength, dx, dy);
	}
	
	// set fillColor to white and border color to black     
	public Square(int x, int y, double sideLength, int dx, int dy) { 
			super(x, y, sideLength, sideLength, dx, dy);
	} 
	
	// other methods here
	public String toString() {
		return super.toString();
		
	}
}
