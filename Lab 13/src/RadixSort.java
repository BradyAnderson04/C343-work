import java.util.ArrayList;
import java.util.Random;

public class RadixSort {

	private ArrayList<Integer> data;
	
	public RadixSort(ArrayList<Integer> input) {
		// create various size test data w/ predictable testing in mind
		setData(input);
	}
	
	private Integer getDigitCount(Integer number) {
		Integer count = 0;
		while(number / Math.pow(10, count) >= 1) {
			count ++;
		}
		return count;
	}
	
	private Integer findMaxDigits() {
		Integer maxDecimal = 0;
		for(int i = 0; i < data.size(); i++) {
			if(getDigitCount(data.get(i)) > maxDecimal) {
				maxDecimal = getDigitCount(data.get(i));
			}
		}
		return maxDecimal;
	}
	
	public String Looping() {
		String output = "";
		for(Integer i: data) {
			output += i;
		}
		return output;
	}
	
	public void printOutput() {
		for(Integer i: data) {
			System.out.println(i);
		}
	}
	
	public ArrayList<Integer> tenRadix() {
		/*
		 * use algorithm described on canvas
		 * 
		 * also I prefer to use arraylists
		 */
		Integer loopCount = findMaxDigits();
		// arraylists
		ArrayList<Integer> zero   = new ArrayList<Integer>();
		ArrayList<Integer> one    = new ArrayList<Integer>();
		ArrayList<Integer> two    = new ArrayList<Integer>();
		ArrayList<Integer> three  = new ArrayList<Integer>();
		ArrayList<Integer> four   = new ArrayList<Integer>();
		ArrayList<Integer> five   = new ArrayList<Integer>();
		ArrayList<Integer> six    = new ArrayList<Integer>();
		ArrayList<Integer> seven  = new ArrayList<Integer>();
		ArrayList<Integer> eight  = new ArrayList<Integer>();
		ArrayList<Integer> nine   = new ArrayList<Integer>();
		
		for(int i = 0; i < loopCount; i++) {
			for(int m = 0; m < data.size(); m++) {
				// active number
				Integer active = data.get(m);
				// find which array to add to
				Integer value = (int) (active % Math.pow(10, i+1) / Math.pow(10, i));
				// place value in appropiate array
				switch(value) {
					case 0:
						zero.add(active);
						break;
					case 1:
						one.add(active);
						break;
					case 2:
						two.add(active);
						break;
					case 3:
						three.add(active);
						break;
					case 4:
						four.add(active);
						break;
					case 5:
						five.add(active);
						break;
					case 6:
						six.add(active);
						break;
					case 7:
						seven.add(active);
						break;
					case 8:
						eight.add(active);
						break;
					case 9:
						nine.add(active);
						break;
				}
			}
			// place back in arraylist (preserve order)
			data.clear();
			for(int j = 0; j< 10; j++) {
				switch(j) {
					case 0:
						for(Integer k: zero) {
							data.add(k);
						}
						zero.clear();
						break;
					case 1:
						for(Integer k: one) {
							data.add(k);
						}
						one.clear();
						break;
					case 2:
						for(Integer k: two) {
							data.add(k);
						}
						two.clear();
						break;
					case 3:
						for(Integer k: three) {
							data.add(k);
						}
						three.clear();
						break;
					case 4:
						for(Integer k: four) {
							data.add(k);
						}
						four.clear();
						break;
					case 5:
						for(Integer k: five) {
							data.add(k);
						}
						five.clear();
						break;
					case 6:
						for(Integer k: six) {
							data.add(k);
						}
						six.clear();
						break;
					case 7:
						for(Integer k: seven) {
							data.add(k);
						}
						seven.clear();
						break;
					case 8:
						for(Integer k: eight) {
							data.add(k);
						}
						eight.clear();
						break;
					case 9:
						for(Integer k: nine) {
							data.add(k);
						}
						nine.clear();
						break;
					}
				}
			}
		return data;
	}
	
	public ArrayList<Integer> oneRadix() {
		// how many times to process
		Integer loopCount = findMaxDigits();
		// arraylist setup
		ArrayList<ArrayList<Integer>> sortHelp = new ArrayList<ArrayList<Integer>>();
		// initialize our datastructure
		for(int i = 0; i < 10; i++) {
			sortHelp.add(new ArrayList<Integer>());
		}
		// go through all digit places
		for(int i = 0; i < loopCount; i++) {
			// sort through current digit place
			for(int j = 0; j < data.size(); j++) {
				// active number
				Integer active = data.get(j);
				// find which array to add to
				Integer value = (int) (active % Math.pow(10, i+1) / Math.pow(10, i));
				// place value in appropiate array
				sortHelp.get(value).add(active);
			}
			// clear out data that we already processed
			data.clear();
			// add back in sorted order and clear the lists
			for(int m = 0; m < sortHelp.size(); m++) {
				for(Integer n: sortHelp.get(m)) {
					data.add(n);
				}
				sortHelp.get(m).clear();
			}
		}
		return data;
	}

	public ArrayList<Integer> getData() {
		return data;
	}

	public void setData(ArrayList<Integer> data) {
		this.data = data;
	}
	
	
	public static void main(String[] args) {
		Random rn = new Random();
		ArrayList<Integer> small = new ArrayList<Integer>();
		ArrayList<Integer> large = new ArrayList<Integer>();
		// create a really large arraylist
		for(int i=0; i < 100000; i++) {
			large.add(rn.nextInt(1000000));
		}
		// create a small arraylist
		for(int i = 0; i < 10; i++) {
			small.add(rn.nextInt(1000));
		}
		
		RadixSort rs = new RadixSort(large);
		rs.oneRadix();
		rs.printOutput();
	}

}
