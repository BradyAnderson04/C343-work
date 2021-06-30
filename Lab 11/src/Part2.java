import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab8
//@Author Brady Anderson 
//Explain: 
//	allows user to buy and sell stocks 
//  this isn't a very real system so takes
//	in stock name, quantity, price
///////////////////////////////////////////////////////////////////////////////////

public class Part2 {

	public static void main(String[] args) {
		Portfolio myStocks = new Portfolio("Brady");
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("What do you want to do, buy or sell stocks? Enter quit to leave.");
			String input = in.next();
			if(input.toLowerCase().equals("buy")) {
				System.out.println("Which stock do you want to buy?");
				String stock = in.next();
				
				System.out.println("How much stock do you want to buy?");
				Integer quantity = in.nextInt();
				
				System.out.println("How much does that one cost again?");
				Double cost = in.nextDouble();
				System.out.println(cost);
				
				myStocks.buyStock(stock, quantity, cost);
				System.out.println("Executing Buy of " + quantity.toString() + " shares of " + stock + " at " + cost.toString() + " dollars per share." );
			} 
			else if(input.toLowerCase().equals("sell")) {
				System.out.println("Which stock do you want to sell?");
				String stock = in.next();
				
				System.out.println("How much shares of stock do you want to sell?");
				Integer quantity = in.nextInt();
				
				if(myStocks.getStocks().get(stock).peek().getTotalBought() < quantity ) {
					System.out.println("You do not have enough stock bought.");
					
				} else {
					System.out.println("How many dollars does that one cost again?");
					Double cost = in.nextDouble();

					System.out.println(myStocks.sellStock(stock, quantity, cost));
				}
			} 
			else if(input.toLowerCase().equals("quit")) {
				break;
			} 
			else {
				System.out.println("Command Not recognized, try typing quit, buy, or sell!");
			}
		}
		System.out.println("Pleasure doing business w/ you mate ;)");
		in.close();
	}

}
