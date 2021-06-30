/**
 * 
 */

/**
 * @author bradyanderson


 *
 */
import java.util.Scanner;
import java.lang.*;

public class lab3Exercises{
    public static int my1089Puzzle(int myInput) {
        // initialize variables
        String input = Integer.toString(myInput);
        // take input from user and reverse
        String inputReverse = "";
        for (int i = input.length(); i > input.length() - 3; i--) {
            inputReverse += input.substring(i-1, i);
        }
        // Subtract Input - reverse
        int difference = myInput - Integer.parseInt(inputReverse);
        // reverse difference
        String differenceReverse = "";
        for (int i = Integer.toString(difference).length(); i > Integer.toString(difference).length() - 3; i--) {
            differenceReverse += Integer.toString(difference).substring(i-1, i);
        }
        // return sum
        int sum = Integer.parseInt(differenceReverse) + Integer.parseInt(inputReverse);
        return sum;
    }

    public static String formatPhoneNumber(final String myNumber, final boolean option) {
        // dictate between true or false
        if (option) {
            // format based off preference w/ (***) ***-****
            return "(" + myNumber.substring(0, 3) + ") " + myNumber.substring(3, 6) + "-" + myNumber.substring(6);
        } else if (!option) {
            // format based off preference w/ ***-***-****
            return myNumber.substring(0, 3) + "-" + myNumber.substring(3, 6) + "-" + myNumber.substring(6);
        } else {
            return "";
        }
    }

    public static String numbersList() {
        // Initialize variables
        String numList = "";
        // impliment scanner class with while loop
        Scanner NumberInput = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter a Number");
        while(true){
            if(NumberInput.hasNextInt()){
                int num = NumberInput.nextInt();
                System.out.println("Enter a Number");
                // add value to comma seperated list of string (no duplicates)
                if(num > 5 && num < 19 && ! numList.contains(Integer.toString(num))){
                    numList += Integer.toString(num) + ", ";
                } else if(! numList.contains(Integer.toString(num))){     // if our of range notify user to pick correct value
                    System.out.println("Enter a Number in the range 5 - 19");
                    numList += Integer.toString(num) + ", ";
                }
            } else {        // if wrong type exit loop
                break;
            }
            
        }
        NumberInput.close();    // close scanner object
        // return list of comma seperated numbers in string of user implimented numbers
        return numList.substring(0, (numList.length() -2));
    }

    public static String grade(char letter) {
        // take letter grade and match w/ appropiate grade range
        if(letter == 'A'){
            return "Your grade is between 93.0 and 100.0";
        } else if(letter == 'B'){
            return "Your grade is betweeen 83.0 and 92.99";
        } else if(letter == 'C'){
            return "Your grade is between 73.0 and 82.99";
        } else if(letter == 'D'){
            return "Your grade is between 63.0 and 72.99";
        } else if(letter == 'F'){
            return "Your grade is less than 63.0";
        } else{
            return "Not a valid grade letter";
        }
    }

    public static String intToHex(int n) {
        // initialize vars
        String hexString = "";
        int nextNum = n;
        // Implement recursion to do at any size
        while(nextNum != 0){
            // take remainder and add that value to hex
            String[] hexes = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
            hexString += hexes[nextNum % 16];
            // integer division to get next value of nextNum
            nextNum /= 16;
        }
        String hexOutput = "";
        for (int i = hexString.length(); i > 0; i--) {
            hexOutput += hexString.substring(i-1, i);
        }
        return hexOutput;
    }

    public static void main(String[] args) {
         Scanner NumberInput = new Scanner(System.in);  // Create a Scanner object
         System.out.println("Enter a Number with 3+ digits");
         int number = NumberInput.nextInt();
        // scanner to get user input
         System.out.println(my1089Puzzle(number));
        // J unit tests for B
        System.out.println(formatPhoneNumber("8048521484", false));
        // jUnit tests for C
         System.out.println(numbersList());
        // jUnit tests for D
        System.out.println(grade('A'));
        // jUnit tests for E
        System.out.println(intToHex(6000392));
        // NumberInput.close();
    }
}



/*
a.Give the type and value for each of the following expressions: 
i.7.8 > 78 
false

ii.12+13+19+21
65

iii. 2.3+5.7+7.1
15.1

iv. 2+4+”24”
624

b.Without compiling/running the code, give the value printed by each of the following code fragments. 
Now compile/run and see if your answer was correct. Report the output and whether you were initially correct: 

i.The following code is using Newton’s Method to calculate the square root of a number
double t = 9.0;
while (Math.abs(t – 9.0/t) > .001) {
    t = (9.0/t + t) / 2.0;
} 
System.out.println(t);

the program will print 3

The program actually printed 3.00009155413138

ii.System.out.printf(“%03d”,7); 

the program will print 007

The program actually printed 007

iii.String s = “Bye Bye Bye”
s = s.replace(‘y’, ‘e’);
System.out.println(s);

The program will print Bee Bee Bee

The program actually prints Bee Bee Bee


*/
