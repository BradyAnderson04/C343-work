import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class findMedian {
	
	private ArrayList<Integer> numbers;

	public findMedian(ArrayList<Integer> list) {
		this.setList(list);
	}
	
	public Double simpleMedian() {
		/* 
		 * get the median by sorting a list and getting the middle elements
		 */
		Collections.sort(numbers);	// sorts arraylist
		Integer index = numbers.size() / 2;
		if(numbers.size() % 2 == 0) {
			// even
			Double median = (double) ((numbers.get(index) + numbers.get(index + 1)) / 2);
			return median;
		} else if (numbers.size() % 2 == 1) {
			// odd
			return (double) numbers.get(index);
		}
		return null;
	}
	
	private ArrayList<Integer> partition(ArrayList<Integer> l, Integer p, String command){
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if(command.equals("Less")) {
			// get all values in array that are < pivot value
			for(int i = 0; i < l.size(); i++) {
				if(l.get(i) < p) {
					returnList.add(l.get(i));
				}
			}
		} else if(command.equals("More")) {
			// get all values in array that are > pivot value
			for(int i = 0; i < l.size(); i++) {
				if(l.get(i) > p) {
					returnList.add(l.get(i));
				}
			}
		} else {
			for(int i = 0; i < l.size(); i++) {
				if(l.get(i) == p) {
					returnList.add(l.get(i));
				}
			}
		}
		return returnList;
	}
	
	public Integer select(int i, Integer a, Integer b) {
		/*
		 * given an array list computationally find the median w/ o sorting
		 * a - start index (exclusive)
		 * b - end index (inclusive)
		 */
		Random rn = new Random();
		// select a pivot index
		Integer p =  rn.nextInt(b - a) + a;
		// partition into 3 subsequences
		Integer n1 = partition(getList(), getList().get(p), "Less").size(); // array list of start index to pivot - 2 index
		Integer n2 = partition(getList(), getList().get(p), "literally anything could be here").size(); // pivot - 1 index to pivot index
//		Integer n3 = partition(getList(), getList().get(p), "More").size(); // pivot index to end of arraylist - not used in algorithm
		// recurssive call 
		if(i < n1) {
			return select(i, a, n1);
		} else if(i >= n1 + n2) {
			return select(i, n1 + n2, b);
		} else {
			return getList().get(p);
		}
	}

	public static void main(String[] args) {
		Random rn = new Random();
		// testing here 8521379
		ArrayList<Integer> test = new ArrayList<Integer>();
		ArrayList<Integer> test1 = new ArrayList<Integer>();
		test.add(8);
		test.add(5);
		test.add(2);
		test.add(1);
		test.add(3);
		test.add(7);
		test.add(9);
		for(int i = 0; i < 10001; i++) {
			test1.add(rn.nextInt(50));
		}
		System.out.println(test1.size());

		findMedian testObject = new findMedian(test);
		findMedian testObject1 = new findMedian(test1);
		
		// method running 
		long startTime = System.nanoTime();
		System.out.println(testObject.select(testObject.getList().size()/2, 0, testObject.getList().size()));
		long endTime = System.nanoTime();
		System.out.println("Small set recursive Runtime: " + (endTime - startTime)/1000000 + " ms\n");
		
		long startTime1 = System.nanoTime();
		System.out.println(testObject.simpleMedian());
		long endTime1 = System.nanoTime();
		System.out.println("Small set sort runtime: " + (endTime1 - startTime1)/1000000 + " ms\n");
		
		long startTime2 = System.nanoTime();
		System.out.println(testObject1.select(testObject1.getList().size()/2, 0, testObject1.getList().size()));
		long endTime2 = System.nanoTime();
		System.out.println("Large set recursive runtime: " + (endTime2 - startTime2)/1000000 + " ms\n");
		
		long startTime3 = System.nanoTime();		
		System.out.println(testObject1.simpleMedian());
		long endTime3 = System.nanoTime();
		System.out.println("Large set sort runtime: " + (endTime3 - startTime3)/1000000 + " ms\n");
	}


	public ArrayList<Integer> getList() {
		return this.numbers;
	}


	public void setList(ArrayList<Integer> list) {
		this.numbers = list;
	}

}
