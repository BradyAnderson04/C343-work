////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Lab8
//  @Author  Brady Anderson
//  Explain: 
//  	Driver program for random shape generator app
//  	NOTE: You are encouraged to experiment and try out various approaches
//  	The comments given here are just guidelines to get you started 
//  	Possibly, this problem can be finished in many ways. 
///////////////////////////////////////////////////////////////////////////////////
 

// oneline of what function does
// what are the arguments -> preconditions
// what is the return value going to be -> postconditions
// use @param @return and other vals
import java.util.ArrayList;
import java.util.Random;
// added for the action listener interface
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

/*
 * Driver program for random shape generator app
 * NOTE: You are encouraged to experiment and try out various approaches
 * The comments given here are just guidelines to get you started 
 * Possibly, this problem can be finished in many ways.
 */
public class ShapeDriver extends JPanel implements ActionListener {

    /**
   * added serial UID due to error w/o
   */
  private static final long serialVersionUID = 1L;
  // constants
    public final int FRAME_WIDTH = 600;
    public final int FRAME_HEIGHT = 600;
    
    // other instance variables
    private ArrayList<Shape> shapeList;
    private int x;
    private int y;
    // shape count ???
	
    public ShapeDriver() {
        super(); 
        // initialize values
        this.shapeList = new ArrayList<Shape>();
        // panel stuff
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        Random rn = new Random();
        // get random color 
        Color myColor = new Color(rn.nextInt(255), rn.nextInt(255), rn.nextInt(255));
        // set JPanel background
		panel.setBackground(myColor);
    }

    @Override
    public void paintComponent(Graphics g) {
    	// init vals for counts
    	int rectCount = 0;
    	int squareCount = 0;
    	int quadCount = 0;
    	int triCount = 0;
    	int circleCount = 0;
    	int ovalCount = 0;
    	int polyCount = 0;
    	int hexCount = 0;
    	int pentCount = 0;
        // calling super class paintComponent method
        // background will not be colored otherwise
        super.paintComponent(g);
        // generate random value
        for( Shape s: shapeList) {
        	// keep track of shapes here
        	if(s instanceof Rectangle && rectCount < 10) {
        		rectCount ++;
        		s.draw(g);
        	} else if(s instanceof Square && squareCount < 10) {
        		squareCount ++;
        		s.draw(g);
        	} else if(s instanceof Quadrilateral && quadCount < 10) {
        		quadCount ++;
        		s.draw(g);
        	} else if(s instanceof Triangle && triCount < 10) {
        		triCount ++;
        		s.draw(g);
        	} else if(s instanceof Oval && ovalCount < 10) {
        		ovalCount ++;
        		s.draw(g);
        	} else if(s instanceof Circle && circleCount < 10) {
        		circleCount ++;
        		s.draw(g);
        	} else if(s instanceof Polygon && polyCount < 10) {
        		polyCount ++;
        		s.draw(g);
        	} else if(s instanceof Hexagon && hexCount < 10) {
        		hexCount ++;
        		s.draw(g);
        	} else if(s instanceof Pentagon && pentCount < 10) {
        		pentCount ++;
        		s.draw(g);
        	}
        	
        }
        /*
          Invoke the .draw() of the different Shapes here. It should take
          the Graphics g object as a parameter. Iterate over your data structure
          holding all the various Shape objects and call their draw() method.
        */
    }
    
	@Override
	public void actionPerformed(ActionEvent e){
		/*
		  This method gets invoked automatically whenever Timer runs out.
		  Purpose of this method should be to do all the randomization
		  such as picking random colors, (x,y) coords, sizes and also
		  deciding which type of shape to draw. Call this.repaint() at
		  the end, so that paintComponent() is invoked.
		  
		  Remember, a specific type of shape (Square, Oval etc) can be repeated
		  only 10 times max.
		*/
		
		// set random values of shapes here 
		// random new point values
		Random pointValues = new Random();
		// 600 because that is size of jFrame
		this.x = pointValues.nextInt(600);
		this.y = pointValues.nextInt(600);
    
		// random new color values, random shape, height, width
		Random color = new Random();
	    Random sh = new Random();
	    Random height = new Random();
	    Random width = new Random();
	    Random randVal = new Random();
	    
	    int shapeType = sh.nextInt(9)+1;
	   
	    // 
	    if(shapeType == 1){
	      // create a circle
	      System.out.println("Circle");
	      shapeList.add(new Circle(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), x, y, height.nextInt(20)));
	    } else if(shapeType == 2){
	      // create an Oval
	      System.out.println("Oval");
	      shapeList.add(new Oval(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), x, y, width.nextInt(20),height.nextInt(20)));
	    } else if(shapeType == 3){
	      // create a quad
	      System.out.println("Quad");
	      shapeList.add(new Quadrilateral(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), x, y, width.nextInt(45),height.nextInt(45)));
	    } else if(shapeType == 4){
	      // create a rect
	      System.out.println("Rect");
	      shapeList.add(new Rectangle(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), x, y, width.nextInt(45),height.nextInt(45)));
	    } else if(shapeType == 5){
	      // create a square
	      System.out.println("Square");
	      shapeList.add(new Square(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), x, y, width.nextInt(45)));
	    } else if(shapeType == 6){
	      // create a triangle
	      System.out.println("Triangle");
	      shapeList.add(new Triangle(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), x, y, width.nextInt(25),height.nextInt(25)));
	    } 
	    else if(shapeType == 7){
	       // create a polygon
	    	System.out.println("Polygon");
	       // random point array
		   int[] randX = new int[7];
		   int[] randY = new int[7];   
		   // first vals
	       randX[0] = this.x;
	       randY[0] = this.y;
	       // generate random values or array
	       for(int i = 1; i < 7; i++) {
	    	   if(i%2 == 0) {
	    		   randX[i] = randX[i-1] + randVal.nextInt(10);
		    	   randY[i] = randY[i-1] + randVal.nextInt(10); 
	    	   } else {
	    		   randX[i] = randX[i-1] - randVal.nextInt(20);
		    	   randY[i] = randY[i-1] - randVal.nextInt(20);   
	    	   }
	       }		
	       shapeList.add(new Polygon(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), randX[0], randY[0], 7, randX,randY));
	     } 
	       else if(shapeType == 8){
	       // create a hexagon
	       System.out.println("Hexagon");
	       // random point array
		   int[] hexX = new int[6];
		   int[] hexY = new int[6];   
		   // first vals
	       hexX[0] = this.x;
	       hexY[0] = this.y;
	       for(int i = 1; i < 6; i++) {
	    	   if(i%2 == 0) {
	    		   hexX[i] = hexX[i-1] + randVal.nextInt(10);
		    	   hexY[i] = hexY[i-1] + randVal.nextInt(10); 
	    	   } else {
	    		   hexX[i] = hexX[i-1] - randVal.nextInt(20);
		    	   hexY[i] = hexY[i-1] - randVal.nextInt(20);   
	    	   }
	       }
	       shapeList.add(new Hexagon(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), hexX[0], hexY[0], 6,hexX,hexY));
	     } 
	       else if(shapeType == 9){
	       // create a pentagon
	       System.out.println("Pentagon");
	       // random point array
	       int[] randX = new int[5];
		   int[] randY = new int[5];   
		   // first vals
	       randX[0] = this.x;
	       randY[0] = this.y;
	       for(int i = 1; i < 5; i++) {
	    	   if(i%2 == 0) {
	    		   randX[i] = randX[i-1] + randVal.nextInt(10);
		    	   randY[i] = randY[i-1] + randVal.nextInt(10); 
	    	   } else {
	    		   randX[i] = randX[i-1] - randVal.nextInt(20);
		    	   randY[i] = randY[i-1] - randVal.nextInt(20);   
	    	   }
	       }
	       shapeList.add(new Pentagon(new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), new Color(color.nextInt(255), color.nextInt(255), color.nextInt(255)), randX[0], randY[0], 5, randX, randY));
	     }
			
		// repaint method for action listener
		this.repaint();
		}
	}