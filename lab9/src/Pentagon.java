import java.awt.Color;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab8
//@Author  Brady Anderson
//Explain: 
//		create a pentagon shape
///////////////////////////////////////////////////////////////////////////////////

public class Pentagon extends Polygon{

	// additional instance variables

		// overloading constructors 
		// the three constructors initialize the instance fields      
		public Pentagon(Color fillColor,Color borderColor, int x, int y, int side, int[] xList, int[] yList) {
			// is this how I chain constructor?
			 super(fillColor, borderColor, x, y, 5, xList, yList);
		}
		 
		// set borderColor to Black since not provided     
		public Pentagon(Color fillColor, int x, int y, int side, int[] xList, int[] yList) {
			super(fillColor, x, y, 5, xList, yList);
		}
		
		// set fillColor to white and border color to black     
		public Pentagon(int x, int y, int side, int[] xList, int[] yList) { 
				super(x, y, 5, xList, yList);
		} 
		
		// other methods below
}
