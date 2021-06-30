import java.awt.*;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
// Exam part 2
//@Author  Brady Anderson
//Explain: 
//			creates a shape which is general structure for all other shapes being made
///////////////////////////////////////////////////////////////////////////////////

abstract class Shape {
	// instance variable
	static Integer count = 0;
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
	
	private Boolean infected;
	private Boolean recovered;
	
	private Integer id;
	
	private int tick;
	 
	// overloading constructors 
	// the three constructors initialize the instance fields      
	public Shape(int x, int y, int dx, int dy) {
		this.fillColor = Color.blue;
		this.borderColor = Color.blue;
		this.Corner = new Point(x, y);
		this.dx = dx;
		this.dy = dy;
		this.infected = false;
		this.recovered = false;
		this.tick = 0;
		this.id = count;
		count ++;
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
	
	public int getAge() {
		return Age;
	}
	
	public void setAge(int age) {
		this.Age = age;
	}

	public void incrementAge() {
		Age ++;
	}

	public Boolean getInfected() {
		return infected;
	}

	public void setInfected(Boolean infected) {
		this.infected = infected;
	}

	public Boolean getRecovered() {
		return recovered;
	}

	public void setRecovered(Boolean recovered) {
		this.recovered = recovered;
	}
	
	public void incrementTick() {
		this.tick ++;
	}
	
	public int getTick() {
		return this.tick;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

