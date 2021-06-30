import java.util.*;

/**
 * @author brady anderson
 *
 * February 19, 2019
 * 
 * longest run class
 * 
 * this class detects the longest run of same numbers and shows that in output string
 */

public class longestRun {
	
			// iterate through whole string
	
			// check equivalence between the prev and current and generate streak if continues
	
			// mark previous value
			
			// compare end of streak to maxstreak and reset if streak >
			
			// return string with ( ) at indexes around maxstreak
	
	public static String checkLongest(ArrayList<Integer> arg) {
		// Loop through input
		Integer prev = 0;
		Integer maxStreak = 0;
		Integer startIndex = 0;
		Integer endIndex = 1;
		Integer streak = 0;
		String output = "";
		Integer count = 0;
		for(Integer roll : arg ) {
			// Streak start
			if(prev == roll && streak == 0) {
				streak = 2;
			}
			// streak continues
			else if (prev == roll && streak != 0){
				streak ++;
			} 
			// streak ends
			else {
				if(streak > maxStreak) {
					maxStreak = streak;
					startIndex = count - streak;
					endIndex = count;
				}
				streak = 0;
			}
			prev = roll;
			output += Integer.toString(roll)+" ";
			count ++;
		}
		return output.substring(0, startIndex*2) + "(" + output.substring(startIndex*2, endIndex*2-1) + ")" + output.substring(endIndex*2-1);
	}
	
	


	public static void main(String[] args) {
		// generate 20 dice rolls
		Random rand = new Random();
		ArrayList<Integer> randRolls = new ArrayList<Integer>();
		for(int i = 0; i<20; i++) {
			randRolls.add(rand.nextInt(6)+1);
		}
		System.out.println(randRolls);
		// trigger custom class
		System.out.println(checkLongest(randRolls));
	}

}
