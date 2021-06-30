import java.util.*;

/**
 * @author brady anderson
 *
 * February 11, 2019
 *
 * roman class function
 */

public class roman {
	
	/*
	 * take in string 
	 * 
	 * process by index -> check for patterns 
	 * 
	 * if pattern recognized add that value of pattern to total
	 * 
	 * remove pattern from string
	 * 
	 * return value when string is empty
	 */
	
	public static int calculateDecimalVal(String roman){
		int fin = 0;
		roman = roman + " ";
		for(int i = 0; i<roman.length(); i++) {
			String current = Character.toString(roman.charAt(i));
			switch(current) {
				case "M":
					fin += 1000;
					break;
				case "D":
					fin += 500;
					break;
				case "C":
					if((Character.toString(roman.charAt(i+1))).equals("D")) {
						fin += 400;
						i++;
					} else if((Character.toString(roman.charAt(i+1))).equals("M")) {
						fin += 900;
						i++;
					} else {
						fin += 100;
					}
					break;
				case "L":
					fin += 50;
					break;
				case "X":
					if(Character.toString(roman.charAt(i+1)).equals("L")) {
						fin += 40;
						i++;
					} else if(Character.toString(roman.charAt(i+1)).equals("C")) {
						fin += 90;
						i++;
					} else {
						fin += 10;
					}
					break;
				case "V":
					fin += 5;
					break;
				case "I":
					if(Character.toString(roman.charAt(i+1)).equals("V")) {
						fin += 4;
						i++;
					} else if(Character.toString(roman.charAt(i+1)).equals("X")) {
						fin += 9;
						i++;
					} else {
						fin += 1;
					}
					break;
				case " ":
					break;
			}
		}	
		
		 return fin;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Insert a roman number between 1 and 4000");
		String roman = in.next();
		
		System.out.println(calculateDecimalVal(roman));
		
	}

}
