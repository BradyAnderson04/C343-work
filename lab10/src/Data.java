////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Lab8
//  @Author Brady Anderson 
//  Explain: 
//  	This is my data class...this will hold data on each
//		unique string that I want to track
///////////////////////////////////////////////////////////////////////////////////

public class Data implements Comparable<Data> {
	
	private String str;
	private Integer count;
	private Integer length;

	public Data(String str, Integer count) {
		/*
		 * Intialize values of a string with inputs
		 * str - the particular string being represented
		 * count - the number of times the word has been found
		 * length - length of the str input
		 */
		this.str = str;
		this.count = count;
		this.length = str.length();
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public int compareTo(Data compareData) {
		int compareCount = compareData.getCount();
		// descending order
		return compareCount - this.getCount();
	}

}
