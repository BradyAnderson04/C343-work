////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Lab8
//  @Author Brady Anderson 
//  Explain: 
//  	Simple practice in recursion...will reverse a string 
//		iteratively and recurssively to compare how they look
//		and work
///////////////////////////////////////////////////////////////////////////////////
public class Part1 {

	public String iterateReverse(String text) {
		/*
		 * iteratively reverse a string
		 * by reveres looping through a string creating an output
		 * string from the input string
		 */
		String output = "";
		for(int i = text.length(); i > 0; i--) {
			output += text.substring(i-1, i);
		}
		return output;
	}
	
	public String recurssiveReverse(String text) {
		/*
		 * recursively reverse a string
		 * will return a character at a time adding the current character
		 * after the next one effectively reversing it
		 */
		if(text.length() == 1) {
			return text.substring(0,1);
		}else {
			return recurssiveReverse(text.substring(1)) + text.substring(0,1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part1 temp = new Part1();
		System.out.println(temp.recurssiveReverse("Happy day!"));
		
		System.out.println(temp.iterateReverse("Happy day!"));
		
	}
}
