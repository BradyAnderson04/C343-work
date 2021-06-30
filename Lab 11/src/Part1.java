import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab8
//@Author Brady Anderson 
//Explain: 
//	This simulates a map of cities 
//  and finds the cheapest/shortest route between cities	
//	
///////////////////////////////////////////////////////////////////////////////////

public class Part1 {
	
	static Map<String, City> cityData = new HashMap<String, City>();
	
	public static void readData() {
		try {
			File input = new File("graph.txt");
			Scanner reader = new Scanner(input);
			while(reader.hasNextLine()) {
				// create city and add to list
				String lineData = reader.nextLine();
				String city = lineData.split(" ")[0];
				String[] cityList = lineData.split(" ")[1].split(",");
				String[] distanceString = lineData.split(" ")[2].split(",");
				ArrayList<Integer> distances = new ArrayList<Integer>();
				ArrayList<String> cities = new ArrayList<String>();
				int i = 0;
				for(String s: distanceString) {
					distances.add((Integer.valueOf(s)));
					cities.add(cityList[i]);
					i++;
				}
				cityData.put(city ,new City(city, cities, distances));
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// set up our data structures
		PriorityQueue<DistanceTo> distances = new PriorityQueue<>();
		Map<String, Integer> shortestKnownDistance = new HashMap<String, Integer>();
		
		
		// initialize the cityList
		readData();
		
		System.out.println("What city are you starting from?");
		if(in.hasNext()) {
			String start = in.next();
			DistanceTo startDistance = new DistanceTo(start, 0);
			distances.add(startDistance);
		}
		
		while(!distances.isEmpty()) {
			// while there are still stuff in the priority queue we need to deal w/ it
			DistanceTo start = distances.poll();
			if(!shortestKnownDistance.containsKey(start.getTarget())) {
				// put value in the map
				shortestKnownDistance.put(start.getTarget(), start.getDistance());
				// add values to the queue that are connected to our city
				Map<String, Integer> connections = cityData.get(start.getTarget()).getConnections();
				// get the key and value of map and then add them to priority queue as a distanceTo object
				for (Entry<String, Integer> entry : connections.entrySet()) {
				    distances.add(new DistanceTo(entry.getKey(), start.getDistance() + entry.getValue()));
				} 
			} // key exists but shorter path is found
			else if(shortestKnownDistance.containsKey(start.getTarget())) {
				if(start.getDistance() < shortestKnownDistance.get(start.getTarget())) {
					shortestKnownDistance.replace(start.getTarget(), start.getDistance());
				}
			}
		}
		System.out.println("The shortest distances from starting point to end point:");
		for (Entry<String, Integer> entry : shortestKnownDistance.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		};
		
		in.close();
	}
}
