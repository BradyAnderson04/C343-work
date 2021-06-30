import java.awt.Color;

public class Circle extends Oval{

	// additional instance variables

	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Circle(Color fillColor,Color borderColor, int x, int y,double diameter) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y, diameter, diameter);
	}
	 
	// set borderColor to Black since not provided     
	public Circle(Color fillColor, int x, int y, double diameter) {
		super(fillColor, x, y, diameter, diameter);
	}
	
	// set fillColor to white and border color to black     
	public Circle(int x, int y, double diameter) { 
			super(x, y, diameter, diameter);
	} 

	// formats the output of what an object is
	public String toString() {
		return super.toString();
	}
}
