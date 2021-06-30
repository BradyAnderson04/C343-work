import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab8
//@Author  Brady Anderson
//Explain: 
//		creaets a quadrilateral
///////////////////////////////////////////////////////////////////////////////////
import java.awt.Point;

public class Quadrilateral extends Shape{
	
	// additional instance variables

	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Quadrilateral(Color fillColor,Color borderColor, int x, int y, double width, double length, int dx, int dy) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y, dx, dy);
		 setFillColor(fillColor);
		 setBorderColor(borderColor);
		 setLength(length);
		 setWidth(width);
		 Double change = width/2;
		 this.setCenter(new Point((x+ change.intValue()), (y+ change.intValue())));
	}
	 
	// set borderColor to Black since not provided     
	public Quadrilateral(Color fillColor, int x, int y, double width, double length, int dx, int dy) {
		super(fillColor, x, y, dx, dy);
		setFillColor(fillColor);
		setBorderColor(Color.black);
		setLength(length);
		setWidth(width);
		Double change = width/2;
		this.setCenter(new Point((x+ change.intValue()), (y+ change.intValue())));
	}
	
	// set fillColor to white and border color to black     
	public Quadrilateral(int x, int y, double width, double length, int dx, int dy) { 
		super(x, y, dx, dy);
		setFillColor(Color.white);
		setBorderColor(Color.black);
		setLength(length);
		setWidth(width);
		Double change = width/2;
		this.setCenter(new Point((x+ change.intValue()), (y+ change.intValue())));
	} 

	double getArea() {
		return getWidth() * getLength();
	}

	double getPerimeter() {
		return 2 * getWidth() + 2 * getLength();
	}
	
	void draw(Graphics g) {
		// Recover Graphic2d
        Graphics2D g2 = (Graphics2D) g;
        // other variables
        int width = getWidth().intValue();
        int height = getLength().intValue();
        // Draw it now
        g2.setColor(getFillColor());
        g2.fillRect(getX(), getY(), width, height);
        g2.setColor(getBorderColor());
        g2.drawRect(getX(), getY(), width, height);
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
		return "This is a "+ this.getClass() + ". The X Position: " + super.getX() + ",the Y Position: " + super.getY() + ". The width of the object is: " + super.getWidth() +", while the length of the object is: "+ super.getLength();
	}
}
