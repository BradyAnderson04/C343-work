import java.util.Scanner;

/**
 * @author brady anderson
 *
 * February 11, 2019
 * 
 * menu class Question number 2
 */

public class menu {
	
	/*
	 * Display Menu Options 
	 * 
	 * Take user input (option and size)
	 * 
	 * execute certain option upon selection
	 * 
	 * Patterns with size 5 are shown below.
	 * 
	 * A. 1 2 3 4 5   
	 *     2 3 4 5    
	 *      3 4 5     
	 *       4 5      
	 *        5     
	 *       4 5    
	 *      3 4 5   
	 *     2 3 4 5  
	 *    1 2 3 4 5 
	 *    
	 *    B.     *   
	 *          * *   
	 *         *   *     
	 *        *     *
	 *       ********* 
	 *       
	 *    C.     *    
	 *          * *   
	 *         *   *  
	 *        *     * 
	 *       *       *  
	 *        *     *   
	 *         *   *    
	 *          * *     
	 *           *    
	 *           
	 *           Example Menu:  
	 *           	A.Pattern 1
	 *           	B.Pattern 2
	 *           	C.Pattern 3
	 *           	E.Exit
	 */

	public static String patternOne(int a) {
		for(int i=0; i<a; i++) {
			String value = "";
			for(int j=0; j<a+1; j++) {
				if(j >= i) {
					value += (j + " ");
				}
			}
			System.out.println(" ".repeat(i) + value);
		}
		System.out.println(" ".repeat(a)+ a);
		for(int i=a-1; i>0; i--) {
			String value = "";
			for(int j=0; j<a+1; j++) {
				if(j >= i) {
					value += (j + " ");
				}
			}
			System.out.println(" ".repeat(i) + value);
		}
		
		System.out.println();
		
		return " ";
	}
	
	public static String patternTwo(int a) {
		System.out.println(" ".repeat(a)+"*");
		for(int i = 0; i < a-1; i++) {
			System.out.println(" ".repeat(a-1-i)+"*"+" ".repeat(i*2+1)+"*");
			
		}
		System.out.println("*".repeat((a*2)+1));
		return " ";
	}
	
	public static String patternThree(int a) {
		System.out.println(" ".repeat(a+1)+"*");
		for(int i = 0; i< a-1; i++) {
			System.out.println(" ".repeat(a-i) + "*"+" ".repeat(i*2+1)+"*");
		}
		for(int i = a-3; i > -1; i--) {
			System.out.println(" ".repeat(a-i) + "*"+" ".repeat(i*2+1)+"*");
		}
		System.out.println(" ".repeat(a+1)+"*");
		return " ";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("A.Pattern 1");
			System.out.println("B.Pattern 2");
			System.out.println("C.Pattern 3");
			System.out.println("E.Exit");
			Scanner in = new Scanner(System.in);
			System.out.println("Insert a value (A, B, or C) and an integer ex: A 20");
			String val = in.next();
			Integer num = in.nextInt();
			
			if("A".equals(val)) {
				menu.patternOne(num);
			}else if(("B".equals(val))){
				menu.patternTwo(num);
			} else if(("C".equals(val))){
				menu.patternThree(num);
			}else {
				break;
			}
			
		}
	}

}
