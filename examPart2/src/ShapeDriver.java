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
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;

public class ShapeDriver extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Timer timer;
	// other instance variables
    private ArrayList<Shape> shapeList;
    // constants
    public final int FRAME_WIDTH = 160;
    public final int FRAME_HEIGHT = 20;
    private int population;
    
    private int sickCount = 0;
    private int healthyCount = population;
    private int recoveredCount = 0;
    
    private ArrayList<Integer> countedList;
    
    public ShapeDriver(int population) {
	    // the second argument to the Timer Constructor takes an ActionListener
	    // the this key word informs the JVM to look inside this class for
	    // the actionPerformed method that must be overridden when
	    // ActionListener is implemented
	    // Every tick of the clock will now run the actionPerformed method
    	this.shapeList = new ArrayList<Shape>();
    	this.setPopulation(population);
    	this.countedList = new ArrayList<Integer>();
        
	    timer = new Timer(1000/60, this);
	    timer.start();
    }

    // Method that must be implemented since the class implements ActionListener
    public void actionPerformed(ActionEvent e) {
	    /*
	     * This method will be responsible for moving the circles and dealing w/ collision events
	     * additionally upon the start of the program it will create as many shapes as there is town population
	     * 
	     * Next the method will need to move shapes accoring to properties dx and dy
	     */
    	Random pointValues = new Random();
    	
    	if(shapeList.size() == 0) {
    		// random new point values
    		for(int i = 0; i < this.getPopulation(); i++) {
    			makeShape();
    			if(sickCount == 0) {
    				shapeList.get(i).setInfected(pointValues.nextBoolean());
    				if(shapeList.get(i).getInfected() == true && i != getPopulation()-1) {
    					incrementSickCount();
    				}
    			} else if(sickCount == 0 && i == getPopulation()-1) {
    				shapeList.get(i).setInfected(true);
    				incrementSickCount();
    			}
    		}
    	}
    	// code to run every time actionPerformed happens
    	
    	/*
    	 * iterate through shapeList moving each object and checking for collisions w/
    	 * first walls and second other circles each collision type will be handeled 
    	 */
    	for(int i = 0; i < shapeList.size(); i++) {	
    		/*
    		 * the next block of code will check if a person is infected and adjust totals
    		 * accordingly. In the case that a person switches to recovered that is handled 
    		 * by the nested if statement
    		 */
    		if(shapeList.get(i).getInfected() == true) {
    			if(shapeList.get(i).getTick() >= 450) {
    				decrementSickCount();
    				incrementRecoveredCount();
    				shapeList.get(i).setRecovered(true);
    				shapeList.get(i).setInfected(false);
    				
    			}
				shapeList.get(i).incrementTick();
			}
			if((shapeList.get(i).getCenterX() + (shapeList.get(i).getWidth()/2)) < 695 && (shapeList.get(i).getCenterX() - (shapeList.get(i).getWidth()/2)) > 5 && (shapeList.get(i).getCenterY() + (shapeList.get(i).getWidth()/2)) < 695 && (shapeList.get(i).getCenterY() - (shapeList.get(i).getWidth()/2)) > 5) {
				shapeList.get(i).moveLocation(shapeList.get(i).getDx(), shapeList.get(i).getDy());
			}else {
				/*
				 * Bugs:
				 * 
				 */
				// out of bounds change direction of the shape
				// going down
				if(shapeList.get(i).getDy() > 0) {
					// right side and left side
					if(shapeList.get(i).getDx() > 0 && shapeList.get(i).getCenterY() < 680) {
						shapeList.get(i).setDx(-1 * shapeList.get(i).getDx());
						shapeList.get(i).setDy(1 * shapeList.get(i).getDy());
					} else if(shapeList.get(i).getDx() < 0 && shapeList.get(i).getCenterY() < 680) {
						shapeList.get(i).setDx(-1 * shapeList.get(i).getDx());
						shapeList.get(i).setDy(1 * shapeList.get(i).getDy());
					}  
					// hitting the bottom
					else {
						shapeList.get(i).setDx(1 * shapeList.get(i).getDx());
						shapeList.get(i).setDy(-1 * shapeList.get(i).getDy());
					}
					
				} 
				// going up
				else if(shapeList.get(i).getDy() < 0) {
					// right side and left side
					if(shapeList.get(i).getDx() > 0 && shapeList.get(i).getCenterY() > 30) {
						shapeList.get(i).setDx(-1 * shapeList.get(i).getDx());
						shapeList.get(i).setDy(1 * shapeList.get(i).getDy());
					} else if(shapeList.get(i).getDx() < 0 && shapeList.get(i).getCenterY() > 30) {
						shapeList.get(i).setDx(-1 * shapeList.get(i).getDx());
						shapeList.get(i).setDy(1 * shapeList.get(i).getDy());
					}
					// hitting the top
					else {
						shapeList.get(i).setDx(1 * shapeList.get(i).getDx());
						shapeList.get(i).setDy(-1 * shapeList.get(i).getDy());
					}
				}
				shapeList.get(i).moveLocation(shapeList.get(i).getDx(), shapeList.get(i).getDy());
			}
			// checking for collisions between circles
			
    		for(int j = 0; j < shapeList.size(); j++){
    			if(!shapeList.isEmpty()) {
	    			if(shapeList.size() >= i && shapeList.size() >= j && isCollision(shapeList.get(i), shapeList.get(j))) {
	    				/*
	    				 * collision w/ other shape has happened
	    				 * Need to... 
	    				 * 1.infect if one of the shapes if infected
	    				 * 2.change the path of both objects due to collision
	    				 * 
	    				 */
	    				// when they collide if one is infected and neither are recovered then both values get set to infected
	    				// I think this simple appraoch will work since tick doesnt get reset and how I handle tick incrementing
	    				if(((shapeList.get(i).getInfected() && !shapeList.get(j).getRecovered()) || (shapeList.get(j).getInfected() && !shapeList.get(i).getRecovered()))) {
	    					shapeList.get(j).setInfected(true);
	    					shapeList.get(i).setInfected(true);
	    					if(!countedList.contains(shapeList.get(i).getId())) {
	    						countedList.add(shapeList.get(i).getId());
	    						incrementSickCount();
	    					}else if(!countedList.contains(shapeList.get(j).getId())) {
	    						countedList.add(shapeList.get(j).getId());
	    						incrementSickCount();
	    					}
	    				}
	    				
	    				// go the opposite direction they were pre collision
	    				shapeList.get(i).setDx(-1 * shapeList.get(i).getDx());
	    				shapeList.get(i).setDy(-1 * shapeList.get(i).getDy());
	    				shapeList.get(j).setDx(-1 * shapeList.get(j).getDx());
	    				shapeList.get(j).setDy(-1 * shapeList.get(j).getDy());
	    				}
    			}
    		}
    	}
		// call repaint
		this.repaint();
	}
    
    public boolean isCollision(Shape s1, Shape s2) {
    	/*
    	 * // check to see if it is the same shape via memory location
    	 */
    	boolean status = false;
    	if(s1 != s2) {
    		// per piaza I am implementing this solution defined below
    		/*
    		 * given the center of both shapes if the distance between them
    		 * is less than the summation of the radius then there is a collision
    		 */
    		Double distance = (Math.sqrt((Math.pow((s1.getCenterX() - s2.getCenterX()), 2.0) + Math.pow((s1.getCenterY() - s2.getCenterY()), 2.0))));
    		if(distance <= s1.getWidth()/2 + s2.getWidth()/2) {
    			status = true;
    		}
    	}
		return status;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        // calling super class paintComponent method
        // background will not be colored otherwise
        /*
	    Invoke the .draw() of the different Shapes here. It should take
	    the Graphics g object as a parameter. Iterate over your data structure
	    holding all the various Shape objects and call their draw() method.
	    additionally i set the direction of each shape here
	    */
        for(Shape s: shapeList) {
        	s.draw(g);
        }
        g.drawString("Sick: " + getSickCount(), 20, 660);
        g.drawString("Healthy: " + getHealthyCount(), 20, 670);
        g.drawString("Recovered: " + getRecoveredCount(), 20, 680);
        
    }

	
    public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	public int getSickCount() {
		return sickCount;
	}
	public void setSickCount(int count) {
		this.sickCount = count;
	}
	public void incrementSickCount() {
		this.sickCount += 1;
	}
	public void decrementSickCount() {
		this.sickCount -= 1;
	}
	
	public void makeShape() {
    	// set random values of shapes here 
		// random new point values
		Random pointValues = new Random();
		// 600 because that is size of jFrame
		Integer x = pointValues.nextInt(600) + 50;
		Integer y = pointValues.nextInt(600) + 50;
		// area 
		Integer Area = 15;
		// I am taking -1 to a power of 0 or 1 which will make it even or not even
		// giving the same magnitude aka speed but a different direction associated w/ circle
		Integer dx = (int) (Math.pow(-1, pointValues.nextInt(2)) * 2);
		Integer dy = (int) (Math.pow(-1, pointValues.nextInt(2)) * 2);
		// randomly create a sick person
	    
    	Circle c = new Circle(x, y, Area, dx, dy);
    	shapeList.add(c);
    }

	public int getRecoveredCount() {
		return recoveredCount;
	}

	public void incrementRecoveredCount() {
		this.recoveredCount += 1;
	}
	public void decrementRecoveredCount() {
		this.recoveredCount -= 1;
	}
	public void setRecoveredCount(int count) {
		this.recoveredCount = count;
	}

	public int getHealthyCount() {
		return healthyCount;
	}

	public void incrementHealthyCount() {
		this.healthyCount += 1;
	}
	public void decrementHealthyCount() {
		this.healthyCount -= 1;
	}
	public void setHealthyCount(int count) {
		this.healthyCount = count;
	}

}