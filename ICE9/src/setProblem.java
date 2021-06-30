import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  ICE8
//  @Author Brady Anderson 
//  Explain: 
//  	given a list find unique values using a set
// 			1.create list w/ values
//			2.find unique values
//			3.print
///////////////////////////////////////////////////////////////////////////////////


public class setProblem {

	public static void main(String[] args) {
		Set<String> teams = new HashSet<>();
		// names in a linked list
		teams.add("Philedelphia Fusion");
		teams.add("Boston Uprising");
		teams.add("San Fransico Shock");
		teams.add("Shanghai Dragons");
		teams.add("Los Angelos Gladiators");
		teams.add("London Spitfire");
		teams.add("Boston Uprising");
		teams.add("Shanghai Dragons");
		teams.add("Seoul Dynasty");
		teams.add("Dallas Fuel");
		teams.add("Toronto Defiant");
		teams.add("Philadelphia Fusion");
		teams.add("Montreal Rebellion");
		teams.add("Dignitas");
		teams.add("Cloud9");
		teams.add("NRG Esports");
		teams.add("Splyce");
		teams.add("Dignitas");
		teams.add("London Spitfire");
		teams.add("Dallas Fuel");
		
		System.out.println(teams);
		// remove duplicates
		Iterator<String> iterator = teams.iterator();
		System.out.println(iterator.next());
		iterator.remove();
		System.out.println(teams);
		
	}
	
}
