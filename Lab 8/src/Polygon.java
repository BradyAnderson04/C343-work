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
// 		creates a polygon
///////////////////////////////////////////////////////////////////////////////////

public class Polygon extends Shape {

	// additional instance variables
	private int sideCount;
	private int[] xList;
	private int[] yList;

	// overloading constructors
	// the three constructors initialize the instance fields
	public Polygon(Color fillColor, Color borderColor, int x, int y, int side, int[] xLi, int[] yLi) {
		super(fillColor, borderColor, x, y);
		xList = xLi;
		yList = yLi;
		sideCount = side;
		setFillColor(fillColor);
		setBorderColor(borderColor);
	}

	// set borderColor to Black since not provided
	public Polygon(Color fillColor, int x, int y, int side, int[] xLi, int[] yLi) {
		super(fillColor, x, y);
		xList = xLi;
		yList = yLi;
		sideCount = side;
		setFillColor(fillColor);
		setBorderColor(Color.black);
	}

	// set fillColor to white and border color to black
	public Polygon(int x, int y, int side, int[] xLi, int[] yLi) {
		super(x, y);
		xList = xLi;
		yList = yLi;
		sideCount = side;
		setFillColor(Color.white);
		setBorderColor(Color.black);
	}

	// getters and setters for instance variables here
	public int getSideCount() {
		return sideCount;
	}

	public void setSideCount(int sides) {
		this.sideCount = sides;
	}

	public int[] getXPoints() {
		return xList;
	}

	public void setXPoints(int[] points) {
		this.xList = points;
	}

	public int[] getYPoints() {
		return yList;
	}

	public void setYPoints(int[] points) {
		this.yList = points;
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

	// formats the output of what an object is
	public String toString() {
		// TODO Auto-generated method stub
		return "This is a polygon. The X Position: " + super.getX() + ",the Y Position: " + super.getY();
	}

	@Override
	void draw(Graphics g) {
		// establish integer list -> maybe subtract 1 here
		int[] xp = new int[this.getSideCount() ];
		int[] yp = new int[this.getSideCount() ];
		// Assign values to the arrays
		for (int i = 0; i < xList.length; i++) {
			xp[i] = xList[i];
			yp[i] = yList[i];
		}
		// used for debugging
//		for (int i = 0; i < xp.length; i++) {
//			System.out.print(xp[i]);
//			System.out.print(" ");
//		}
//
//		System.out.println();
//
//		for (int i = 0; i < yp.length; i++) {
//			System.out.print(yp[i]);
//			System.out.print(" ");
//		}
//		System.out.println();
//		System.out.println();
//		System.out.println();

		// Recover Graphic2d
		Graphics2D g2 = (Graphics2D) g;
		// draw and color
		g2.setColor((this.getFillColor()));
		g2.fillPolygon(xp, yp, this.getSideCount());
		g2.setColor(this.getBorderColor());
		g2.drawPolyline(xp, yp, this.getSideCount());
	}

	// checks if 2 shapes are of the same string output aka exactly the same
	public boolean equals(Shape a, Shape b) {
		if (a.toString().equals(b.toString())) {
			return true;
		} else {
			return false;
		}
	}
}
