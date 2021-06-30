////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Lab8
//  @Author Brady Anderson 
//  Explain: 
//  	Creates the shapes whenever H key is pressed
//		Additionally every step checks for collisoins
//		and based off shape properties does different actions
///////////////////////////////////////////////////////////////////////////////////


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class ShapeDriver extends JPanel implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	private Timer timer;
	// other instance variables
    private ArrayList<Shape> shapeList;
    // constants
    public final int FRAME_WIDTH = 160;
    public final int FRAME_HEIGHT = 20;
    
    public ShapeDriver() {
	    // the second argument to the Timer Constructor takes an ActionListener
	    // the this key word informs the JVM to look inside this class for
	    // the actionPerformed method that must be overridden when
	    // ActionListener is implemented
	    // Every tick of the clock will now run the actionPerformed method
    	this.shapeList = new ArrayList<Shape>();
    	// panel stuff
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        //  JPanel stuff
        JLabel label = new JLabel("Press H to create shapes!");
        panel.add(label);
        add(panel);
        setVisible(true);

        panel.addKeyListener(this);
        panel.setFocusable(true);
	    timer = new Timer(1000/60, this);
	    timer.start();
    }

    // Method that must be implemented since the class implements ActionListener
    public void actionPerformed(ActionEvent e) {
	    // move each Shape
	    // check if each Shape is in bounds, and delete if it touches the borders
    	for(int i = 0; i < shapeList.size(); i++) {	    	
			shapeList.get(i).incrementAge();
			// check if Shape is Circle or Square
    	    // if it is a Circle or Square, check if it collides with Shape of same type
			// location not chaning when code is executed
			if(shapeList.get(i).getAge() > 10) {
				if(shapeList.get(i) instanceof Square && shapeList.get(i).getCenterX() + (shapeList.get(i).getWidth()/2) <= 600 && shapeList.get(i).getCenterX() - (shapeList.get(i).getWidth()/2) >= 0 && shapeList.get(i).getCenterY() + (shapeList.get(i).getWidth()/2) <= 600 && shapeList.get(i).getCenterY() - (shapeList.get(i).getWidth()/2) >= 0) {
					shapeList.get(i).moveLocation(shapeList.get(i).getDx(), shapeList.get(i).getDy());
				} else if(shapeList.get(i) instanceof Circle && shapeList.get(i).getCenterX() + (shapeList.get(i).getWidth()/2) <= 600 && shapeList.get(i).getCenterX() - (shapeList.get(i).getWidth()/2) >= 0 && shapeList.get(i).getCenterY() + (shapeList.get(i).getWidth()/2) <= 600 && shapeList.get(i).getCenterY() - (shapeList.get(i).getWidth()/2) >= 0) {
					shapeList.get(i).moveLocation(shapeList.get(i).getDx(), shapeList.get(i).getDy());
				}else {
					// out of bounds delete the shape 
					shapeList.remove(shapeList.get(i));
					if(i > 0) {
						i--;
					}		
				}
			}
			// checking for collisions
			
    		for(int j = 0; j < shapeList.size(); j++){
    			if(!shapeList.isEmpty()) {
    			if(shapeList.size() >= i && shapeList.size() >= j && isCollision(shapeList.get(i), shapeList.get(j))) {
    				// if the Shape collides with a Shape of same color,
    	    	    // create a new Shape with twice the area of the larger Shape and direction of smaller Shape
    	    	    // if the Shapes have the same area, then the area should still be doubled
    	    	    // and select direction of one of the Shapes for the new Shape
    				/*
    				 * I am using the similar to method I defined in the shape class which based off hue color
    				 * along with some other factors will give you a high reliability if colors are similar
    				 * the number i chose in this method as my bound was one that upon calculating results
    				 * was very close in r g b values allowing for a maximum color difference of 15 collectively
    				 */
    				if(shapeList.get(i).similarTo(shapeList.get(j).getFillColor())) {
    					Double area = findSmaller(shapeList.get(i), shapeList.get(j));
    					Shape larger = findLarger(shapeList.get(i), shapeList.get(j));
    					String shapeType = (shapeList.get(i) instanceof Square) ? "Square" : "Cirlce";
    					makeShape(shapeType, area, larger.getDx(),larger.getDy());
    					System.out.println(shapeList.get(i));
    					shapeList.remove(i);
    					System.out.println(shapeList.get(i));
    					// I am removing j -1 because I already removed the i index making everything be moved back 1 index
    					shapeList.remove(j-1);
    					j--;
    				} else {
    					// if it collides with Shape of same type but different color, 
    		    	    // delete the shape with smaller Area
    		    	    // if the Shapes have the same area, delete one or the other but not both
    					@SuppressWarnings("unused")
						Shape task = (shapeList.get(i).getArea() > shapeList.get(j).getArea()) ? shapeList.remove(j) : shapeList.remove(i);
    				}
    			}
    		}
    	}
	}
		// call repaint
		this.repaint();
	}
    
    public boolean isCollision(Shape s1, Shape s2) {
    	/*
    	 * A function that given 2 shapes will check for any overlap/collision of 2 shapes
    	 * additionally will only work if the 2 shapes are of the same instance type 
    	 * 
    	 * To detect collisions I am checking 4 points and if further accuracy is needed I 
    	 * will test an additional 4 points. The initial 4 points will be t / b / L / R
    	 * the additional points will be diagnals 
    	 * 
    	 * Additionally I am checking opposing sides for overlap / collision due to 
    	 * only opposing sides should be checked for collision
    	 * 
    	 * // check to see if it is the same shape via memory location
    	 */
    	boolean status = false;
    	if(s1.getClass() == s2.getClass() && s1 != s2) {
    		// per piaza I am implementing this solution defined below
    		/*
    		 * given the center of both shapes if the distance between them
    		 * is less than the summation of the radius then there is a collision
    		 */
    		Double distance = (Math.sqrt((Math.pow((s1.getCenterX() - s2.getCenterX()), 2.0) + Math.pow((s1.getCenterY() - s2.getCenterY()), 2.0))));
    		if(distance <= s1.getWidth() + s2.getWidth()) {
    			status = true;
    		}
    	}
		return status;
    }
    
    public Double findSmaller(Shape s1, Shape s2) {
    	return (s1.getArea()<s2.getArea()) ? s1.getAge() : s2.getArea(); 	
    }
    
    public Shape findLarger(Shape s1, Shape s2) {
    	return (s1.getArea()>s2.getArea()) ? s1 : s2; 	
    }
    
    public void makeShape(String shapeType, double Area, int dx, int dy) {
    	// set random values of shapes here 
		// random new point values
		Random pointValues = new Random();
		// 600 because that is size of jFrame
		Integer x = pointValues.nextInt(500) + 50;
		Integer y = pointValues.nextInt(500) + 50;
    
		// random new color values, random shape, height, width
		Random color = new Random();
	    
	    if(shapeType.equals("Square")) {
	    	Square s = new Square(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), x, y, Area+15, dx, dy);
	    	shapeList.add(s);
	    } else if(shapeType.equals("Cirlce")) {
	    	Circle c = new Circle(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), x, y, Area+15, dx, dy);
	    	shapeList.add(c);
	    }
	    shapeList.get(shapeList.size()-1).setDirection(dx, dy);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        // calling super class paintComponent method
        // background will not be colored otherwise
        super.paintComponent(g);
        /*
	    Invoke the .draw() of the different Shapes here. It should take
	    the Graphics g object as a parameter. Iterate over your data structure
	    holding all the various Shape objects and call their draw() method.
	    additionally i set the direction of each shape here
	    */
        for(Shape s: shapeList) {
        	if(s instanceof Square) {
        		Square sq = (Square) s;
        		sq.draw(g);
        	} else {
        		Circle c = (Circle) s;
        		c.draw(g);
        	}
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
	    /*
	    This method will be invoked whenever a key is pressed.
	    For this method, you will need to determine if the H key is pressed, and
	    if it is, create a new random Shape and add it to your data structure that holds
	    all the Shapes.
	    */
	    Random shpe = new Random();
	    Random height = new Random();
	    Random locChange = new Random();
	    int shapeType = shpe.nextInt(2)+1;
	    
    	if(e.getKeyCode() == KeyEvent.VK_H) {
    		if(shapeType == 1) {
    			// create a square
    			makeShape("Square", height.nextInt(20), locChange.nextInt(20)-10,locChange.nextInt(20)-10);
    		} else if (shapeType == 2){
    			// create a circle
    			makeShape("Cirlce", height.nextInt(20), locChange.nextInt(20)-10,locChange.nextInt(20)-10);
    		}
    	}
    	// Time delay here....
//    	try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// 
//			e1.printStackTrace();
//		}
    }

    //No implementation is needed for this lab assignment.
    @Override
    public void keyReleased(KeyEvent e) {}


    //No implementation is needed for this lab assignment.
    @Override
    public void keyTyped(KeyEvent e) {}
}

