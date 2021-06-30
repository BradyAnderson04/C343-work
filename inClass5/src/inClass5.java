import java.util.*;


/**
 * @author brady anderson
 *
 * February 11, 2019
 * 
 * In Class Assignment Number 5
 */

public class inClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean val = true;
		Double max = 0.0;
		Double second = 0.0;
		Integer secondIndex = 0;
		int count = 0;
		while(val) {
			Scanner in = new Scanner(System.in);
			System.out.println("Insert a double value");
			Double num = in.nextDouble();
			if(num > max) {
				second = max;
				max = num;
			} else if (num < max && num > second) {
				secondIndex = count;
			} else if (num == -1) {
				System.out.println("Invalid Input");
				System.out.println(secondIndex);
				break;
			}
			count ++;
		}
	}

}
