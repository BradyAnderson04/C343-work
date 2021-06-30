import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JComponent;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab 6
//@Author  Brady Anderson
//Explain: 
//	creates triangles to be drawn on a JFrame

// makeup lab for week 6
///////////////////////////////////////////////////////////////////////////////////

public class checkerBoardDrawer extends JComponent {

	private static final long serialVersionUID = 1L;
	Integer size = 0;
	public checkerBoardDrawer(int i) {
		size = i;
	}

	public void paintComponent(Graphics g) {
		System.out.println(size);
		int count = 0;
        // Recover Graphic2d
        Graphics2D g2 = (Graphics2D) g;
        for(int y = 0; y < size*8; y += size) {
        	for(int x = 0; x < size*8; x+=size) {
        		// color rules
        		System.out.println(x);
        		if((count % 2) == 0) {
        			g2.setColor(Color.BLACK);
        			System.out.println("Hello");
        		} else {
        			g2.setColor(Color.RED);
        			System.out.println("World");
        		}
        		// Triangle coordinates!
        		int[] x1 = {x, x, x+size, x};
        		int[] y1 = {y, y+size, y+size, y};
        		int[] x2 = {x, x+size, x+size, x};
        		int[] y2 = {y, y, y+size, y};
        		// setting up triangle objects
        		Polygon triangle = new Polygon(x1, y1, 3);
        		Polygon triangle2 = new Polygon(x2, y2, 3);
        		// function to draw triangles
        		g2.draw(triangle);
        		g2.draw(triangle2);
        		g2.fillPolygon(triangle);
        		g2.fillPolygon(triangle2);
        		count ++;
        	}
        	count ++;
        }      
	}
}