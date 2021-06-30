import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.KeyStroke;

public class ICESeven extends JComponent implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//For me, it is better to initiate some data when creating the fields
	//So that you will not encounter null exceptions later
	private String cityOfBirth = "";
	private String name = "";
	private int xLoc = 0;
	private int yLoc = 0;
		
		// you might need another field at here

	public ICESeven(int xLoc, int yLoc) throws Exception {
		// initiate x and y location as input x and y location
		// reading file
		File input = new File("c:\\Users\\bradyanderson\\eclipse-workspace\\ice7\\input.txt");
		Scanner reader = new Scanner(input);
		this.setName(reader.next());
		this.setCityOfBirth(reader.next());
		reader.close();
		
		this.setxLoc(xLoc);
		this.setyLoc(yLoc);
	   // You can choose to store the new data to file directly in here
	   // Or you can create a function to do that
	}
	
	public void paintComponent(Graphics g, int value) {    
        // Recover Graphic2d
        Graphics2D g2 = (Graphics2D) g;
			// print the text you want to draw at here    
			if(value == 1) {
				// c is pressed
				String drawing = this.getCityOfBirth();
				g2.drawString(drawing, this.getxLoc(), this.getyLoc());
				
			} else if(value == 2) {
				// n is pressed
				String drawing = this.getName();
				g2.drawString(drawing, this.getxLoc(), this.getyLoc());
				
			} else if(value == 3) {
				// b is pressed
				g2.drawString("Bye", this.getxLoc(), this.getyLoc());
			}
		}    

	public static void main(String[] args) throws Exception {
		// Test Object
		ICESeven test = new ICESeven(150, 150);
		// pass the path to the file as a parameter 
//	    File myFile = new File("input.txt");
		JFrame frame = new JFrame("In Class Assignment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().add (new DirectionPanel());
		frame.pack();
		frame.setSize(450, 450);
		// key listener being used here
//		frame.addKeyListener(new KeyAdapter() {
//		public void keyPressed(KeyEvent e){
//			// pressed b
//		    if(){
//		     
//		    } 
//		    // pressed c
//		    else if() {
//		    	
//		    } 
//		    // pressed n
//		    else if() {
//		    	
//		    }
//		  }
//		});
		frame.setVisible(true);
		
		// write output file
		try {
			FileWriter writer = new FileWriter("C:\\Users\\bradyanderson\\eclipse-workspace\\ice7\\ouput.txt");
			writer.write(test.getCityOfBirth());
			writer.write(test.getName());
			writer.close();
			System.out.println("Successfully wrote to file");
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	  } 

	public String getCityOfBirth() {
		return cityOfBirth;
	}

	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String names) {
		this.name = names;
	}

	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

}
