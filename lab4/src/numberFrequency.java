import java.util.Random;

/**
 * @author brady anderson
 *
 * February 11, 2019
 * 
 * numberFrequency checker Question number 3
 */

public class numberFrequency {
	
	/*
	 * Generate 10 random numbers
	 * 
	 * Give count of each random number in string
	 * 
	 * delete random number with highest frequency - if 2 have same # then delete the smallest of the 2 numbers
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rn = new Random();
		String numbers = "";
		for(int i = 0; i<10; i++) {
			numbers += (rn.nextInt(9)+1) +"";
		}
		// copy list for sanity reasons
		String nums = numbers;
		Integer top = 11;
		Integer myNumber = 0;
		for(int i = 0; i < numbers.length(); i++) {
			System.out.println(i);
			if(((numbers.replace(Integer.toString(i),"")).length()) < top) {
				top = nums.replace(Integer.toString(i), "").length();
				myNumber = i;
			}
		}
		System.out.println("Deleting the Numbers with Max Frequency..");
		System.out.println(numbers.replace(Integer.toString(myNumber), ""));
	}
}
