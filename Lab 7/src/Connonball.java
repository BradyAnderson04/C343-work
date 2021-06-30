import java.util.*;
import java.awt.*;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Final Project
//@Author  Brady Anderson
//Explain: 
//		Define a cannonball in a format that is easy to visualize
///////////////////////////////////////////////////////////////////////////////////


public class Connonball {
	// instance variables
	// x / y positions
	Double xPos;
	Double yPos;
	// x / y velocity
	Double xVelocity;
	Double yVelocity;
	// Constants 
	final Double GRAVITY = 9.81;
	// locations (x, y) tuples in an arrayList
	ArrayList<Double> position = new ArrayList<Double>();

	// constructor -> initializing x and y values
	public Connonball(double xPosition) {
		// Initialize x to xPosition and y to 0
		xPos = xPosition;
		yPos = 0.0;
	}
	
	// take in a change in time and move an object to the point it would be after that change in time
	// using current values and then updating the values to what they would be at the new point
	public void move(double deltaSize) {
		// change x and y positions -> calculations shown
		xPos = xPos + xVelocity * deltaSize;
		yPos = yPos + yVelocity * deltaSize - ((GRAVITY * Math.pow(deltaSize, 2.0)) / 2);
		// update x and y velocity -> y is effected by gravity , xVelocity not mentioned because is unchanged
		yVelocity = yVelocity - GRAVITY * deltaSize;
	}
	
	// change currentPoint object to have current x and y position values -> return currentPoint object
	public Point getLocation() {
		Point currentPoint = new Point(0,0);
		// point object w/ current x and y position rounded to nearest integer
		currentPoint.setLocation(Math.round(xPos), Math.round(yPos));
		return currentPoint;
	}
	
	// With a specific alpha, double, and delta sec simulate the path of the Cannon ball 
	// Using previously defined methods we can get the values of the points and return
	// an array of point objects
	public ArrayList<Point> shoot(double alpha, double v, double deltaSec){
		// create arrayList with point objects
		ArrayList<Point> positions = new ArrayList<Point>();
		yVelocity = v * Math.sin(alpha);
		xVelocity = v * Math.cos(alpha);
		// call move to simulate path of cannon ball -> round to get an approximate example time interval may not line up
		while(yPos >= 0) {
			// move the cannon ball to next position
			move(deltaSec);
			// add current point data to array
			positions.add(this.getLocation());
		}
		// after yPos is 0 add final point
		return positions;	
	}
}
