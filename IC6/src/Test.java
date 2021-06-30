import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Taco tacoOne = new Taco(5.99, 12, "Fritto Burrito");
		Taco tacoTwo = new Taco(9.99, 12, "Supreme Burrito");
		Taco tacoThree = new Taco(2.99, 12, "Taco Burrito");
//		System.out.println(one.getPrice());
//		System.out.println(one);
		
		Scoobysnacks scoobyOne = new Scoobysnacks(25.0, 1, "Gummy Fruit Snack");
		Scoobysnacks scoobyTwo = new Scoobysnacks(20.0, 2, "Gummy Snack");
		Scoobysnacks scoobyThree = new Scoobysnacks(15.0, 3, "Fruit Snack");
//		System.out.println(two.getPrice());
//		System.out.println(two);
		
		Socks sockOne = new Socks(5.09, 13, "Gucci Socks");
		Socks sockTwo = new Socks(7.10, 13, "Regular Socks");
		Socks sockThree = new Socks(8.09, 13, "Dad Socks");
//		System.out.println(three.getPrice());
//		System.out.println(three);
		ArrayList<Scannable> temp = new ArrayList<Scannable>();
		temp.add(tacoOne);
		temp.add(scoobyTwo);
		temp.add(sockOne);
		
		Taco[] tempOne = new Taco[3];
		Scoobysnacks[] tempTwo = new Scoobysnacks[3];
		Socks[] tempThree = new Socks[3];
		
		tempOne[0] = tacoOne;
		tempOne[1] = tacoTwo;
		tempOne[2] = tacoThree;
		
		tempTwo[0] = scoobyOne;
		tempTwo[1] = scoobyTwo;
		tempTwo[2] = scoobyThree;
		
		tempThree[0] = sockOne;
		tempThree[1] = sockTwo;
		tempThree[2] = sockThree;
		
		for (Scannable s : temp) {
			System.out.println(s.scanMe());
		}
		System.out.println();
		for (Taco t : tempOne) {
			System.out.println(tempOne[0].compareTo(t));
		}
		System.out.println();
		for (Scoobysnacks s : tempTwo) {
			System.out.println(tempTwo[0].compareTo(s));
		}
		System.out.println();
		for (Socks s : tempThree) {
			System.out.println(tempThree[0].compareTo(s));
		}
		System.out.println();
	}

}
