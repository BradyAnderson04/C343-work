import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class City {
	
	private Boolean visited;
	private String name;
	private Map<String, Integer> connections;

	public City(String name, ArrayList<String> cities, ArrayList<Integer> distances) {
		this.setName(name);
		connections = new TreeMap<String, Integer>();
		for(int i = 0; i < cities.size(); i++) {
			connections.put(cities.get(i), distances.get(i));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}
	
	public Map<String, Integer> getConnections(){
		return connections;
	}

}
