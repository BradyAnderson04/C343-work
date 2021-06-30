import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class sets {
	/*  
	 * given a random integer value pair it w/ a random string value
	 * I use ascii to create random effect
	 * 
	 * from there I prompt user for values and give them the pair
	 * if a pair exists. If not I ask again, if nonexistant again then I will provide 
	 * all valid keys they can choose from
	 */
	
	public static void main(String[] args)   {
		Random rn = new Random();
		Scanner in = new Scanner(System.in);
		
		// create my random map
		Map<Integer, String> asciiMap = new TreeMap<>();
		for(int i = 0; i<30; i++) {
			Integer intVal = rn.nextInt(50);
			int asciiVal = 65 + rn.nextInt(57);
			if(asciiVal > 90 && asciiVal < 97) {
				asciiVal += 6;
			}
			@SuppressWarnings("deprecation")
			String str = new Character((char) asciiVal).toString();
			asciiMap.put(intVal, str);
		}
		
		// user input flow
		boolean status = true;
		int wrong = 0;
		while(status) {
			System.out.println("Provide an integer from 1-50");
			int input = in.nextInt();
			if(asciiMap.containsKey(input)) {
				wrong = 0;
				System.out.println("Key pair: " + asciiMap.get(input));
			}else {
				System.out.println("Not a valid key. Try again...");
				wrong += 1;
				System.out.println(wrong);
				if(wrong >= 2) {
					System.out.println("Here are the viable options");
					for( Integer oneKey : asciiMap.keySet()) {
						System.out.print(oneKey+", ");	
					}
					System.out.println("");
				}
			}
		}
	}
}
