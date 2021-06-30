import java.util.Scanner;


/**
 * @author brady anderson
 *
 * February 11, 2019
 *
 * class for validShuffle Question number 5
 */

public class validShuffle {
	
	/*
	 * Take in 3 strings
	 * 
	 * check if each element of first 2 are in the 3rd string
	 *
	 * return true if true and false otherwise
	 */
	
	public static Boolean isValid(String one, String two, String fin) {
		boolean val = true;
		String f = fin;
		for(int i = 0; i < one.length(); i++) {
			if(f.contains(one.substring(i, i+1))) {
				f.replace(one.substring(i, i+1), "");
			} else {
				val = false;
			}
		}
		for(int i = 0; i < two.length(); i++) {
			if(f.contains(two.substring(i, i+1))) {
				f.replace(two.substring(i, i+1), "");
			} else {
				val = false;
			}
		}
		if(one.length()+two.length() == fin.length() && val) {
			return true;
		} else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Insert 3 strings ex abc def abcdef -> true or abc def abcdad -> false");
		String str1 = in.next();
		String str2 = in.next();
		String str3 = in.next();

		System.out.print(isValid(str1, str2, str3));
	}

}
