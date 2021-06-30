// Recurssive and iterative implementation of factorial 

/*
 * Recurssive
 * 
 * fac(5) = 5*4*3*2*1
 * fac(4) = 4*3*2*1
 * 
 * fac(n) = n*(n-1)
 */

/*
 * Iterative
 * 
 * fac(5) = 5*4*3*2*1
 * 
 * loop i to 5 
 * multiply i*total
 */
public class Factorial {
	
	public static int RecursiveFactorial(int n) {
		int answer = 1;
		if(n == 1) {
			return 1;
		} else {
			answer = n * RecursiveFactorial(n-1);
		}
		return answer;
	}

	public static int IterativeFactorial(int n) {
		int answer = 1;
		for(int i = 1; i<n+1; i++) {
			answer *= i;
		}
		return answer;
	}
	
	public static int fibonachi(int n) {
		System.out.println(n);
		if(n <= 2) {
			return 1;
		} else {
			return fibonachi(n-1) + fibonachi(n-2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IterativeFactorial(5));
		System.out.println(RecursiveFactorial(5));
		System.out.println(fibonachi(9));
	}

}
