import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Final Project
//@Author  Brady Anderson
//Explain: 
//		Draw the canonball on  a jcomponent
///////////////////////////////////////////////////////////////////////////////////

public class DrawCannonball extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Point> pointsList = new ArrayList<Point>();
	
	public DrawCannonball(ArrayList<Point> path) {
		pointsList = path;
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		System.out.println(pointsList.size());
		for(int i = 0; i < pointsList.size(); i++) {
			// get the x and y values
			Integer x = (int) Math.round(pointsList.get(i).getX());
			Integer y = getHeight() - (int) Math.round(pointsList.get(i).getY());
			// add x and reverse y value to jFrame
			g2.setPaint(Color.black);
			g2.drawOval(x, y, 5,5 );
		}
	}
	
	public static void main(String[] args) {	
        // get input w/ scanner class
        Scanner in = new Scanner(System.in);
		System.out.println("All inputs are double type.");
		// starting X position
		System.out.println("Enter a starting x position in x.x format.");
		Double startingX = in.nextDouble();
		// Launch Angle
		System.out.println("Enter the launch angle in radians.");
		Double alpha = in.nextDouble();
		// Launch Velocity
		System.out.println("Enter the launch velocity.");
		Double initialVelocity = in.nextDouble();
		// Time interval
		System.out.println("Enter a time interval.");
		Double timeDelta = in.nextDouble();

		// create Cannon ball object
		Connonball cannon = new Connonball(startingX);
		
		// ArrayList to store stuff
		ArrayList<Point> path = new ArrayList<Point>(10);
		// Test shoot method here
		path.addAll(cannon.shoot(alpha, initialVelocity, timeDelta));
		// JFrame stuff here
		JFrame frame = new JFrame();
		// setting up canvas
        frame.setSize(800, 600);
        frame.setTitle("INCOMING!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // actually draw component
        DrawCannonball component = new DrawCannonball(path);
        frame.add(component);
		frame.setVisible(true);
		
		in.close();
	}
}
