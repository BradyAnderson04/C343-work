import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab8
//@Author  Brady Anderson
//Explain: 
//		This class will create an oval by inheriting properties from shape
///////////////////////////////////////////////////////////////////////////////////

public class Oval extends Shape{
	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Oval(Color fillColor,Color borderColor, int x, int y, double length, double width) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y);
		 setFillColor(fillColor);
		 setBorderColor(borderColor);
		 setLength(length);
		 setWidth(width);
		 Double change = width/2;
		 setCenter(new Point((x+ change.intValue()), (y+ change.intValue())));
	}
	 
	// set borderColor to Black since not provided     
	public Oval(Color fillColor, int x, int y,double length, double width) {
		super(fillColor, x, y);
		setFillColor(fillColor);
		setBorderColor(Color.black);
		setLength(length);
		setWidth(width);
		Double change = width/2;
		setCenter(new Point((x+ change.intValue()), (y+ change.intValue())));
	}
	
	// set fillColor to white and border color to black     
	public Oval(int x, int y, double length, double width) { 
		super(x, y);
		setFillColor(Color.white);
		setBorderColor(Color.black);
		setLength(length);
		setWidth(width);
		Double change = width/2;
		this.setCenter(new Point((x+ change.intValue()), (y+ change.intValue())));
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
        // other variables
        int width = getWidth().intValue();
        int height = getLength().intValue();
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
