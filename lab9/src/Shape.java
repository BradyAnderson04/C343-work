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
	private Point Corner;
	private Point Center;
	
	private Double width;
	private Double length;
	
	private int Age;
	
	private Integer dx;
	private Integer dy;
	 
	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Shape(Color fillColor,Color borderColor, int x, int y, int dx, int dy) {
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.Corner = new Point(x, y);
		this.dx = dx;
		this.dy = dy;
	}
	 
	// set borderColor to Black since not provided     
	public Shape(Color fillColor, int x, int y, int dx, int dy) {
		this.fillColor = fillColor;
		this.borderColor = Color.BLACK;
		this.Corner = new Point(x, y);
		this.dx = dx;
		this.dy = dy;
	}
	
	// set fillColor to white and border color to black     
	public Shape(int x, int y, int dx, int dy) { 
		this.fillColor = Color.WHITE;
		this.borderColor = Color.BLACK;
		this.Corner = new Point(x, y);	
		this.dx = dx;
		this.dy = dy;
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
		return (int) this.Corner.getX();
	}     
	public void setX(Double x) { 
		this.Corner.setLocation(x, this.Corner.getY());
	}    
	public int getY() { 
		return (int) this.Corner.getY();
	}     
	public void setY(Double y) { 
		this.Corner.setLocation(this.Corner.getX(), y);
	}     
	
	public Integer getDx() {
		return dx;
	}

	public void setDx(Integer dx) {
		this.dx = dx;
	}

	public Integer getDy() {
		return dy;
	}

	public void setDy(Integer dy) {
		this.dy = dy;
	}
	
	public void setDirection(int dx, int dy) {
		setDy(dy);
		setDx(dx);
	}
	
	public Point getCenter() {
		return Center;
	}

	public void setCenter(Point center) {
		Center = center;
	}
	
	public int getCenterY() { 
		return (int) this.Center.getY();
	}     
	public void setCenterY(int y) { 
		this.Center.setLocation(this.Center.getX(), y);
	}     
	
	public int getCenterX() { 
		return (int) this.Center.getX();
	}     
	public void setCenterX(int x) { 
		this.Center.setLocation(x, this.Center.getY());
	}  
	
	boolean similarTo(Color c){
		/*
		 * a function that given another color will give if a color is similar to the color of the shape object
		 * I am not implimenting this in my lab code, but i found this on stack overflow and wanted to impliment 
		 * it to see how useful this approximation of similarity was
		 * 
		 * Important is difference in formulas rather than result
		 */
	    double distance = 0.0;
	    if(c.getRed() < 128){
	    	distance = Math.sqrt(2 * Math.pow((getFillColor().getRed() - c.getRed()), 2.0) + 4 * Math.pow((getFillColor().getGreen() - c.getGreen()), 2.0) + 3 * Math.pow((getFillColor().getBlue() - c.getBlue()), 2.0));
	        return distance <= 15;
	    }else{
	    	distance = Math.sqrt( 3 * Math.pow((getFillColor().getRed() - c.getRed()), 2.0) + 4 * Math.pow((getFillColor().getGreen() - c.getGreen()), 2.0) + 2 * Math.pow((getFillColor().getBlue() - c.getBlue()), 2.0));
	        return distance <= 15;
	    }
	}
	
	// if fillColor is white returns true, else returns false      
	public boolean isFilled() { 
		if(getFillColor() == Color.WHITE || getFillColor() == Color.white) {
			return true;
		} else {
			return false;
		}
	}    
	
	public void moveLocation(int dx, int dy) { 
		Double x = (double) getX();
		Double y = (double) getY();
		this.setX((x + dx));
		this.setY((y + dy)); 
		// change center points too
		this.setCenterY((getCenterY() + dy));
		this.setCenterX((getCenterX() + dx));
	}     
//	// abstract classes can be inhereited but can only be defined in the subclass -> doing lab 9
	abstract double getArea();    
	abstract double getPerimeter();    
	
	// draw an object
	abstract void draw(Graphics g);
	
	// additional methods 
	public abstract String toString();
	public abstract boolean equals(Shape a, Shape b);

	public int getAge() {
		return Age;
	}

	public void incrementAge() {
		Age ++;
	}

}

