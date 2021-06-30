import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JFrame;

/**
 * @author brady anderson
 *
 * February 11, 2019
 * 
 * audiCirlces class Question number 5
 */

public class audiCircles {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();

        frame.setSize(300, 400);
        frame.setTitle("In Class Assignment 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        audiCircleDrawer component = new audiCircleDrawer();
        frame.add(component);

		frame.setVisible(true);
		
		String zoneID = "America/Los_Angeles";
		TimeZone tz = TimeZone.getTimeZone(zoneID);
		System.out.println((tz.getOffset(Calendar.ZONE_OFFSET / 3600000)));
		System.out.println(tz.getDisplayName(false, TimeZone.LONG));
		System.out.println(tz.useDaylightTime());
	}

}
