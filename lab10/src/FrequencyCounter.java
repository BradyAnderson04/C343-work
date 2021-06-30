////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Lab8
//  @Author Brady Anderson 
//  Explain: 
//  	take in a file name to read the file. After reading 
//		the file take statisitics on line count, word count,
//		and how often unique words happen as well as what the
//		unique words are
//		
//		more details provided over each individual function
///////////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
 * take in a text file name and return the total number of words, distinct number of words
 * number of lines, and how often distinct words happen. Also store the name of the file
 */
public class FrequencyCounter {
	
	private Integer lineCount;
	private Integer wordCount;
	
	private File input;
	private String fileName;
	private Scanner fileReader;
	private ArrayList<Data> StringData;

	public FrequencyCounter(String fileName) {
		/*
		 * get the name of the file to be processed
		 * from there open the file in the constructor
		 * all of these should be setup w/ instance variables
		 */
		this.fileName = fileName;
		lineCount = 0;
		wordCount = 0;
		StringData = new ArrayList<Data>();
		try {
			input = new File(fileName);
			fileReader = new Scanner(input);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getLineCount() throws FileNotFoundException {
		/*
		 * get the line count of the file
		 * need to create a new scanner object
		 * or else the other code won't run
		 */
		
		try {
			Scanner line = new Scanner(input);	
			
			while(line.hasNextLine()) {
				lineCount ++;
				line.nextLine();
			}
			line.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void PopulateFiles() throws FileNotFoundException {
		/*
		 * create a set to track distinct strings
		 * create a map to track frequency of distict strings
		 */
		Set<String> hashSet = new HashSet<String>();
		Map<String, Integer> distinctMap = new TreeMap<>();
		getLineCount();
		while(fileReader.hasNext()) {
			/*
			 * add to set and and increment frequency of word
			 * if already in increment o.w initialize
			 */
			wordCount ++;
			String word = fileReader.next().toLowerCase();
			hashSet.add(word);
			if(distinctMap.containsKey(word)) {
				distinctMap.replace(word, distinctMap.get(word)+1);
			} else {
				distinctMap.put(word, 1);
			}
		}
		for(Map.Entry<String, Integer> entry: distinctMap.entrySet()) {
			/*
			* populate the arrayList w/ data classes
			*/
			StringData.add(new Data(entry.getKey(), entry.getValue()));
		}	
		Collections.sort(StringData);
	}
	
	public void writeData() throws FileNotFoundException {
		/*
		 * Write data to an ouput called statistics.txt
		 * should include file name, # of words
		 * number of lines
		 * number of distinct words
		 * distinct words, length, # of occurances
		 */
		System.out.println("Writing Data");
		PrintWriter out = new PrintWriter("statistics.txt");
		out.println(fileName + " word count: " + wordCount);
		out.println("");
		out.println(fileName + " line count: " + lineCount);
		out.println("");
		out.println(fileName + " distinct word count: " + StringData.size());
		out.println("");
		out.println("Distinct word details below...");
		out.println("_______________________________");
		for(int i = 0; i<3; i++) {
			out.println("");
		}
		out.println("word | # of instances | length");
		for(Data entry: StringData) {
			// optional format string to look about the same
			out.println(entry.getStr() + " | " + entry.getCount() + " | " + entry.getLength());
		}
		out.close();
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// tester code here
		FrequencyCounter fq = new FrequencyCounter("txtFolder/tale.txt");
		fq.PopulateFiles();
		fq.writeData();
	}
	
	
	

}
