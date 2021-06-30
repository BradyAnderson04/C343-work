import java.util.ArrayList;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Final Project
//@Author  Brady Anderson, Dimitri Leopald, Sid Rath, Hayden Wertz
//Explain: 
//		This will store all data about a project from tickets to sprints
//		to various other details. 
///////////////////////////////////////////////////////////////////////////////////

public class Project {

    public String name;
    public String description;
    public ArrayList<User> collaborators;
    public TicketList toDo;
    public ArrayList<Sprint> inProgress;
    public TicketList workDone;

    public Project(String nameInput){}

    public String getName(){
        return this.name;
    }

    public void setName(String nameInput){
        this.name = nameInput;
    }

    public void rename(String nameInput){}

    public String toString(){return "";}

    public void addCollaborators(User userInput){}

    public void removeCollaborators(User userInput){}

}
