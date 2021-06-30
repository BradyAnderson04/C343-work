import java.awt.*;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab8
//@Author  Brady Anderson
//Explain: 
//			creates a shape which is general structure for all other shapes being made
///////////////////////////////////////////////////////////////////////////////////

abstract class Shape {
	// instance variables
	private Color fillColor;    
	private Color borderColor;    
//	private Boolean isFilled;    
	private Point Location;
	
	private Double width;
	private Double length;
	 
	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Shape(Color fillColor,Color borderColor, int x, int y) {
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.Location = new Point(x, y);
	}
	 
	// set borderColor to Black since not provided     
	public Shape(Color fillColor, int x, int y) {
		this.fillColor = fillColor;
		this.borderColor = Color.BLACK;
		this.Location = new Point(x, y);
	}
	
	// set fillColor to white and border color to black     
	public Shape(int x, int y) { 
		this.fillColor = Color.WHITE;
		this.borderColor = Color.BLACK;
		this.Location = new Point(x, y);	
	} 
	
    // will fill the shape with some random image. You can select any image for larger shapes    
	// getters and setters
	public void setFillColor(Color c) { 
		fillColor = c;
	}    
	public Color getFillColor() { 
		return fillColor;
	}    
	public void setBorderColor(Color c) { 
		borderColor = c;
	}    
	public Color getBorderColor() { 
		return borderColor;
	}
	public void setLocation(Point pt) { 
		Location = pt;
	}   
	public Point getLocation() { 
		return Location;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	// Note:  subclasses of Shape do not inherent private members so we need methods the subclasses      
	// can use to get the x and y values from the private Point instance field    
	public int getX() { 
		return (int) this.Location.getX();
	}     
	public void setX(int x) { 
		this.Location.setLocation(x, this.Location.getY());
	}    
	public int getY() { 
		return (int) this.Location.getY();
	}     
	public void setY(int y) { 
		this.Location.setLocation(this.Location.getX(), y);
	}     
	
	// if fillColor is white returns true, else returns false      
	public boolean isFilled() { 
		if(getFillColor() == Color.WHITE || getFillColor() == Color.white) {
			return true;
		} else {
			return false;
		}
	}    
	// moves location by dx and dy -> unused rn
//	private void moveLocation(int dx, int dy) { 
//		this.setX((getX() + dx));
//		this.setY((getY() + dy)); 
//	}     
//	// abstract classes can be inhereited but can only be defined in the subclass -> doing lab 9
	abstract double getArea();    
	abstract double getPerimeter();    
	
	// draw an object
	abstract void draw(Graphics g);
	
	// additional methods 
	public abstract String toString();
	public abstract boolean equals(Shape a, Shape b);

}

