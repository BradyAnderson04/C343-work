import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ICE13 {
	
	private static Random generator = new Random();
	static Timer timer = new Timer();
	static Timer timer1 = new Timer();
	
	public static int[] randomIntArray()
	   {  
	      int[] a = new int[1000000];      
	      for (int i = 0; i < a.length; i++)
	      {
	         a[i] = generator.nextInt(10001) + 1000;
	      }
	      
	      return a;
	   }
	
	public static ArrayList<Integer> randomArrayList()
	   {  
	      ArrayList<Integer> a = new ArrayList<Integer>();      
	      for (int i = 0; i < 1000000; i++)
	      {
	         a.add(generator.nextInt(10001) + 1000);
	      }
	      
	      return a;
	   }
	
	public static SearchValue binarySearchArray(int[] a, int low, int high, int value) {
		SearchValue number = new SearchValue(value);
		if (low <= high)
	      {
	         int mid = (low + high) / 2;
	
	         if (a[mid] == value) 
	         {
	        	 number.addPositions(mid);
	        	 // get all elements of same value before
	        	 int i = 1;
	        	 while(a[mid - i] == value) {
	        		 number.addPositions(mid-i);
	        		 i++;
	        	 }
	        	 // get all elements of same value previous
	        	 i = 1;
	        	 while(a[mid + i] == value) {
	        		 number.addPositions(mid + i);
	        		 i++;
	        	 }
	         }
	         else if (a[mid] < value )
	         {
	            return binarySearchArray(a, mid + 1, high, value);
	         }
	         else
	         {
	            return binarySearchArray(a, low, mid - 1, value);
	         }         
	      }
		return number;
	}
	
	public static SearchValue binarySearchArrayList(ArrayList<Integer> a, int low, int high, int value) {
		SearchValue number = new SearchValue(value);
		if (low <= high)
	      {
	         int mid = (low + high) / 2;

	         if (a.get(mid) == value) 
	         {
	            number.addPositions(value);
	            // get all elements of same value before
	        	 int i = 1;
	        	 while(a.get(mid -i) == value) {
	        		 number.addPositions(mid-i);
	        		 i++;
	        	 }
	        	 // get all elements of same value previous
	        	 i = 1;
	        	 while(a.get(mid + i) == value) {
	        		 number.addPositions(mid + i);
	        		 i++;
	        	 }
	         }
	         else if (a.get(mid) < value )
	         {
	            return binarySearchArrayList(a, mid + 1, high, value);
	         }
	         else
	         {
	            return binarySearchArrayList(a, low, mid - 1, value);
	         }         
	      }
		return number;
		}

	public static SearchValue linearSearchArray(int[] a, int value) {  
		SearchValue number = new SearchValue(value);
		
	    for (int i = 0; i < a.length; i++)
	    {  
	    	if (a[i] == value) {
	    		number.addPositions(i);
	    	}
	    }
	    return number;
	}
	
	public static SearchValue linearSearchArrayList(ArrayList<Integer> a, int value) { 
		SearchValue number = new SearchValue(value);
	    for (int i = 0; i < a.size(); i++)
	    {  
	    	if (a.get(i) == value) { 
	    		number.addPositions(i); 
	    	}
	    }
	    return number;
		}
	
	public static void main(String[] args) {
		// test code below
		int[] a = randomIntArray();
		ArrayList<Integer> b = randomArrayList();
		// linear search tests
		for(int i = 0; i< 10; i++) {
			Integer searchValue = generator.nextInt(1001) + 1000;
			timer.start();
			SearchValue arraySearch = linearSearchArray(a, searchValue);
			timer.stop();
			timer1.start();
			SearchValue arrayListSearch = linearSearchArrayList(b, searchValue);
			timer1.stop();
			System.out.println("Linear Search Loop: " + i);
			System.out.println("Searching for " + arraySearch.getValue() + ". I found this value " + arraySearch.getPositions().size() + " times, at indexes " + arraySearch.getPositions());
			System.out.printf("Elapsed milliseconds:%8d%n",
			           timer.getElapsedTime());
			        timer.reset();
			System.out.println();
			System.out.println("Searching for " + arrayListSearch.getValue() + ". I found this value " + arrayListSearch.getPositions().size() + " times, at indexes " + arrayListSearch.getPositions());
			System.out.printf("Elapsed milliseconds:%8d%n",
			           timer1.getElapsedTime());
			        timer1.reset();
			System.out.println();
			System.out.println(" ");
		}
		// sort arrays for binary search
		Arrays.parallelSort(a);
		Collections.sort(b);
		
		// binary search tests
		for(int i = 0; i< 10; i++) {
			Integer searchValue = generator.nextInt(1001) + 1000;
			timer.start();
			SearchValue arraySearch = binarySearchArray(a, 0, 1000000, searchValue);
			timer.stop();
			timer1.start();
			SearchValue arrayListSearch = binarySearchArrayList(b, 0, 1000000, searchValue);
			timer1.stop();
			System.out.println("Binary Search Loop: " + i);
			System.out.println("Searching for " + arraySearch.getValue() + ". I found this value " + arraySearch.getPositions().size() + " times, at indexes " + arraySearch.getPositions());
			System.out.printf("Elapsed milliseconds:%8d%n",
			           timer.getElapsedTime());
			        timer.reset();
			System.out.println();
			System.out.println("Searching for " + arrayListSearch.getValue() + ". I found this value " + arraySearch.getPositions().size() + " times,at indexes " + arrayListSearch.getPositions());
			System.out.printf("Elapsed milliseconds:%8d%n",
			           timer1.getElapsedTime());
			        timer1.reset();
			System.out.println();
			System.out.println(" ");
		}
		
	}

}
