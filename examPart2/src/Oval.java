import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
// Exam Part 2
//@Author  Brady Anderson
//Explain: 
//		This class will create an oval by inheriting properties from shape
///////////////////////////////////////////////////////////////////////////////////

public class Oval extends Shape{
	
	
	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Oval(int x, int y, double length, double width, int dx, int dy) {
		// is this how I chain constructor?
		 super(x, y, dx, dy);
		 setLength(length);
		 setWidth(width);
		 Double change = width/2;
		 this.setCenter(new Point((x+ change.intValue()), (y+ change.intValue())));
	}
	 
	double getArea() {
		return Math.PI * Math.pow(getLength(), 2);
	}

	double getPerimeter() {
		return 2 * Math.PI * getLength();
	}

	void draw(Graphics g) {
		// Recover Graphic2d
        Graphics2D g2 = (Graphics2D) g;
        // other variables
        int width = getWidth().intValue();
        int height = getLength().intValue();
        // set color type if infected or recovered
        if(getInfected()) {
        	// once infected a tick should increment every time it is drawn aka every time the
        	// action event is triggered
        	this.setFillColor(Color.green);
        } else if(getRecovered()) {
        	// after 17.5 seconds the person get's recovered
        	this.setFillColor(Color.pink);
        }
        // Draw it now
        g2.setColor(getFillColor());
        g2.fillOval(getX(), getY(), width, height);
        g2.setColor(getBorderColor());
        g2.drawOval(getX(), getY(), width, height);
	}
	
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
		return "This is a "+ this.getClass() +". The X Position: " + super.getX() + ",the Y Position: " + super.getY() + ". The width of the object is: " + super.getWidth() +", while the length of the object is: "+ super.getLength();
	}

}
