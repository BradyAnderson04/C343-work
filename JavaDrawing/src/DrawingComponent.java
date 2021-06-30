import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

/*
A component that draws a box
*/


public class DrawingComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
        // Recover Graphic2d
        Graphics2D g2 = (Graphics2D) g;

        // Make Rectangle and Circle object and Draw
        Ellipse2D.Double circle = new Ellipse2D.Double(15, 15, 30, 30);
        Rectangle box = new Rectangle(25,25,10,10);
        Rectangle box2 = new Rectangle(10, 10, 40, 40);
        
        // draw a box
        g2.draw(box);
        g2.draw(box2);
        g2.draw(circle);
    }
}
