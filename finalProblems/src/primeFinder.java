import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class primeFinder {

	public static void main(String[] args) {
		while(true) {
			// initialize a set and take user input as input
			Set<Integer> primeFactors = new TreeSet<Integer>();
			Scanner in = new Scanner(System.in);
			// perform input % n for numbers 2 - input -1
			System.out.println("Enter a whole number");
			Integer input = in.nextInt();
			for(int i = 2; i<input; i++) {
				if(input % i == 0) {	// if at any point the result of the calculation is 0 then the number is not prime
					// for any time there is a non prime number found take the prime factors and add them to a set
					primeFactors.add(i);
					// need to do some prime number checking here
					primeFactors.add(input / i);
				}
			}
			// print the set values 
			for(Integer i: primeFactors) {
				System.out.println(i);
			}
			
			
		}
	}

}
