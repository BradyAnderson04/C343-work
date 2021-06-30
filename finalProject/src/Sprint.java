import java.util.ArrayList;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Final Project
//@Author  Brady Anderson, Dimitri Leopald, Sid Rath, Hayden Wertz
//Explain: 
//		Information about work currently being done in a project
//		which will have a set time period to work on and can be updated 
//		by team managers
///////////////////////////////////////////////////////////////////////////////////

public class Sprint {
    public String name;
    public Double timeFrame;
    public boolean seen;
    public TicketList tickets;
    public ArrayList<User> contributors;

    public Sprint(String nameInput, boolean seenInput){
        this.seen = seenInput;
        this.name = nameInput;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String nameInput){
        this.name = nameInput;
    }

    public double getTimeFrame(){
        return this.timeFrame;
    }
    public void setTimeFrame(double timeFrameInput){
        this.timeFrame = timeFrameInput;
    }

    public boolean getSeen(){
        return this.seen;
    }
    public void setSeen(boolean seenInput){
        this.seen = seenInput;
    }

    public ArrayList<User> getContributors(){
        return this.contributors;
    }
}
