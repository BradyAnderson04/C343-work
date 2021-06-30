import java.util.LinkedList;
import java.util.ListIterator;

////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  ICE8
//  @Author Brady Anderson 
//  Explain: 
//  	populate a linkedin list and perform operations on it
// 			1.set values
//			2.print
//			3.remove
///////////////////////////////////////////////////////////////////////////////////

public class linkedList {
	
	public static LinkedList<String> removeDuplicates(ListIterator<String> input){
		LinkedList<String> output = new LinkedList<>();
		while(input.hasNext()) {
			String value = input.next();
			if(!output.contains(value)) {
				output.add(value);
			}
		}
		return output;
		
	}

	public static void main(String[] args) {
		LinkedList<String> teams = new LinkedList<>();
		// names in a linked list
		teams.addLast("Philedelphia Fusion");
		teams.addLast("Boston Uprising");
		teams.addLast("San Fransico Shock");
		teams.addLast("Shanghai Dragons");
		teams.addLast("Los Angelos Gladiators");
		teams.addLast("London Spitfire");
		teams.addLast("Boston Uprising");
		teams.addLast("Shanghai Dragons");
		teams.addLast("Seoul Dynasty");
		teams.addLast("Dallas Fuel");
		teams.addLast("Toronto Defiant");
		teams.addLast("Philadelphia Fusion");
		teams.addLast("Montreal Rebellion");
		teams.addLast("Dignitas");
		teams.addLast("Cloud9");
		teams.addLast("NRG Esports");
		teams.addLast("Splyce");
		teams.addLast("Dignitas");
		teams.addLast("London Spitfire");
		teams.addLast("Dallas Fuel");
		// print linked list
		System.out.println(teams);
		System.out.println(teams.size());
		// remove duplicates
		ListIterator<String> iterator = teams.listIterator();
		teams = removeDuplicates(iterator);
		// print linked list again
		System.out.println(teams);
	}

}
