import java.util.ArrayList;

public class SearchValue {

	private Integer value;
	private ArrayList<Integer> positions;
	
	public SearchValue(Integer value) {
		this.setValue(value);
		this.positions = new ArrayList<Integer>();
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public ArrayList<Integer> getPositions() {
		return positions;
	}

	public void addPositions(Integer value) {
		this.positions.add(value);
	}

}
