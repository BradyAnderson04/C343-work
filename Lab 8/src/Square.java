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
	public Square(Color fillColor,Color borderColor, int x, int y, double sideLength) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y, sideLength, sideLength);
	}
	 
	// set borderColor to Black since not provided     
	public Square(Color fillColor, int x, int y, double sideLength) {
		super(fillColor, x, y, sideLength, sideLength);
	}
	
	// set fillColor to white and border color to black     
	public Square(int x, int y, double sideLength) { 
			super(x, y, sideLength, sideLength);
	} 
	
	// other methods here
	public String toString() {
		return super.toString();
		
	}
}
