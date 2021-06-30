import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

/**
 * @author brady anderson
 *
 * February 11, 2019
 * 
 * audiCircles drawer -> support class for Question 5
 */

public class audiCircleDrawer extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
        // Recover Graphic2d
        Graphics2D g2 = (Graphics2D) g;

        // Make Rectangle and Circle object and Draw
        Ellipse2D.Double circle  = new Ellipse2D.Double(15,15,60,60);
        Ellipse2D.Double circle1 = new Ellipse2D.Double(55,15,60,60);
        Ellipse2D.Double circle2 = new Ellipse2D.Double(95,15,60,60);
        Ellipse2D.Double circle3 = new Ellipse2D.Double(135,15,60,60);
        
		// draw a box
        g2.setColor(Color.RED);
        g2.draw(circle1);
        g2.setColor(Color.BLUE);
        g2.draw(circle2);
        g2.setColor(Color.CYAN);
        g2.draw(circle);
        g2.setColor(Color.MAGENTA);
        g2.draw(circle3);
    }
}
