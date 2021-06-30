import java.util.Scanner;

import javax.swing.JFrame;


////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab 6
//@Author  Brady Anderson
//Explain: 
//views a simple checkerboard out of a bunch of triangles 
//that for what appears to be squares

// makeup lab for week 6
///////////////////////////////////////////////////////////////////////////////////


public class checkerBoard {
	/**
	 * take user input on the siez of the JFrame
	 * adding scanner to make some interaction and variation of board
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Please insert an Integer");
		int size = in.nextInt();
		JFrame frame = new JFrame();
		JFrame frame1 = new JFrame();
		// setting up canvas
        frame.setSize(8 * size, 8 *size + 20);
        frame.setTitle("Checker Board 1!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // visualize other file
        checkerBoardDrawer component = new checkerBoardDrawer(size);
        frame.add(component);
		frame.setVisible(true);
		// setting up 2nd canvas 
		frame1.setSize(8 * (size * 3), 8 *(size * 3) + 20);
        frame1.setTitle("Checker Board 2!");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// checker board 2
		checkerBoardDrawer component1 = new checkerBoardDrawer(size*3);
		frame1.add(component1);
		frame1.setVisible(true);
	}

}