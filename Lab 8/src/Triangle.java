import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab8
//@Author  Brady Anderson
//Explain: 
//			creates a triangle
///////////////////////////////////////////////////////////////////////////////////

public class Triangle extends Shape{

	// additional instance variables

	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Triangle(Color fillColor,Color borderColor, int x, int y, double width, double length) {
		// is this how I chain constructor?
		 super(fillColor, borderColor, x, y);
		 setFillColor(fillColor);
		 setBorderColor(borderColor);
		 super.setLength(length);
		 super.setWidth(width);
		 System.out.println("hello I am a triangle");
	}
	 
	// set borderColor to Black since not provided     
	public Triangle(Color fillColor, int x, int y, double width, double length) {
		super(fillColor, x, y);
		setFillColor(fillColor);
		setBorderColor(Color.black);
		super.setLength(length);
		super.setWidth(width);
	}
	
	// set fillColor to white and border color to black     
	public Triangle(int x, int y, double width, double length) { 
		super(x, y);
		setFillColor(Color.white);
		setBorderColor(Color.black);
		super.setLength(length);
		super.setWidth(width);
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
        Random rn = new Random();
        // generate triangle points
        int[] x = {getX(), getX()+rn.nextInt(20), (getX() + rn.nextInt(20)), getX()}; 
        int[] y = {getY(), getY() - rn.nextInt(20), getY() - rn.nextInt(20), getY()}; 
        // Draw it now and fill w/ color
        g2.setColor(getFillColor());
        g2.fillPolygon(x, y, 3);
        g2.setColor(getBorderColor());
        g2.drawPolygon(x, y, 3);
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
		return "This is a " + this.getClass() + ". The X Position: " + super.getX() + ",the Y Position: " + super.getY() + ". The width of the object is: " + super.getWidth() +", while the length of the object is: "+ super.getLength();
	}

}
