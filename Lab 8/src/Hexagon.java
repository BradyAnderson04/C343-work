import java.awt.Color;

public class Hexagon extends Polygon{

	// additional instance variables

	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Hexagon(Color fillColor,Color borderColor, int x, int y, int side, int[] xList, int[] yList) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y, 6, xList, yList);
	}
	 
	// set borderColor to Black since not provided     
	public Hexagon(Color fillColor, int x, int y, int side, int[] xList, int[] yList) {
		super(fillColor, x, y, 6, xList, yList);
	}
	
	// set fillColor to white and border color to black     
	public Hexagon(int x, int y, int side, int[] xList, int[] yList) { 
			super(x, y, 6, xList, yList);
	} 
	
	// impliment other methods here
	// checks if 2 shapes are of the same string output aka exactly the same
	public boolean equals(Shape a, Shape b) {
		if(a.toString().equals(b.toString())) {
			return true;
		} else {
			return false;
		}
	}

	// formats the output of what an object is
	public String toString() {
		// TODO Auto-generated method stub
		return "This is a " + this.getClass() + ". The X Position: " + super.getX() + ",the Y Position: " + super.getY() + ". The width of the object is: " + super.getWidth() +", while the length of the object is: "+ super.getLength();
	}
}
