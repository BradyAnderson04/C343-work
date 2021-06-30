import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class projectManager {
	
	ArrayList<Project> allProjects;
	
	public projectManager(){
    	/*
    	 * Read in all data from database / initialize allProjects variable 
    	 */
		allProjects = new ArrayList<Project>();
    }

	public void deleteProject(Project deleteProject){
		/*
		 * Given a Project delete it
		 */
		int index = allProjects.indexOf(deleteProject);
		allProjects.remove(index);
	}
	
	public Boolean addProject(Project newProject){
		/*
		 * add a new project to arraylist (local memory)
		 */
		allProjects.add(newProject);
		return true;
	}
	
	public ArrayList<Project> displayProjects(){
		/*
		 * return all projects so they can be displayed
		 */
		return allProjects;
	}
	
    public void updateDatabase(){
		/*
		* write project data to text file
		*/
	}

    public void populateLocalMemory(){
		/*
		* take data from text file and write to ArrayList
		* each line should represent a project
		*/
		try {
			File input = new File("txtFolder/projectFile.txt");
			Scanner reader = new Scanner(input);
			System.out.println("Success");
			while(reader.hasNextLine()) {
				// create city and add to list
				String projectData = reader.nextLine();
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		projectManager pm = new projectManager();
		pm.populateLocalMemory();
    }
}
