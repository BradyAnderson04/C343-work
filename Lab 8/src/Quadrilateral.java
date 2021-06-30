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

public class Quadrilateral extends Shape{
	
	// additional instance variables

	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Quadrilateral(Color fillColor,Color borderColor, int x, int y, double width, double length) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y);
		 setFillColor(fillColor);
		 setBorderColor(borderColor);
		 setLength(length);
		 setWidth(width);
	}
	 
	// set borderColor to Black since not provided     
	public Quadrilateral(Color fillColor, int x, int y, double width, double length) {
		super(fillColor, x, y);
		setFillColor(fillColor);
		setBorderColor(Color.black);
		setLength(length);
		setWidth(width);
	}
	
	// set fillColor to white and border color to black     
	public Quadrilateral(int x, int y, double width, double length) { 
		super(x, y);
		setFillColor(Color.white);
		setBorderColor(Color.black);
		setLength(length);
		setWidth(width);
	} 

	// do not need to impliment -> part of next lab
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	void draw(Graphics g) {
		// Recover Graphic2d
        Graphics2D g2 = (Graphics2D) g;
        // Make object and fill
        Quadrilateral quad = new Quadrilateral(getFillColor(), getBorderColor(), getX(), getY(), getWidth(), getLength());
        // other variables
        int width = quad.getWidth().intValue();
        int height = quad.getLength().intValue();
        // Draw it now
        g2.setColor(getFillColor());
        g2.fillRect(getX(), getY(), width, height);
        g2.setColor(getBorderColor());
        g2.drawRect(quad.getX(), quad.getY(), width, height);
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
