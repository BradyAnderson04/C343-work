import java.awt.Color;

public class Circle extends Oval{

	// additional instance variables

	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Circle(Color fillColor,Color borderColor, int x, int y,double diameter, int dx, int dy) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y, diameter, diameter, dx, dy);
	}
	 
	// set borderColor to Black since not provided     
	public Circle(Color fillColor, int x, int y, double diameter, int dx, int dy) {
		super(fillColor, x, y, diameter, diameter, dx, dy);
	}
	
	// set fillColor to white and border color to black     
	public Circle(int x, int y, double diameter, int dx, int dy) { 
			super(x, y, diameter, diameter, dx, dy);
	} 

	// formats the output of what an object is
	public String toString() {
		return super.toString();
	}
}
