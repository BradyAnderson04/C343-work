import java.util.ArrayList;
import java.util.Date;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Final Project
//@Author  Brady Anderson, Dimitri Leopald, Sid Rath, Hayden Wertz
//Explain: 
//		stores all data about issues within a certain project. 
// 		all users can add comments, and each ticket is associated 
//		with certain users who add them and will be how work that
//		needs to be done is tracked
///////////////////////////////////////////////////////////////////////////////////


public class Ticket {
    public String issue;
    public User owner;
    public ArrayList<User> assignee;
    public Date createDate;
    public int priority;
    public int status;
    public String description;
    public ArrayList<Comment> comments;
    public boolean seen;
    public int id;

    public Ticket(String issueInput, User ownerInput, ArrayList<User> assigneeInput, Date createDateInput, int priorityInput, int statusInput, String descriptionInput, ArrayList<Comment> commentsInput, boolean seenInput){
        this.issue = issueInput;
        this.owner = ownerInput;
        this.assignee = assigneeInput;
        this.createDate = createDateInput;
        this.priority = priorityInput;
        this.status = statusInput;
        this.description = descriptionInput;
        this.comments = commentsInput;
        this.seen = seenInput;
    }

    public String getIssue(){
        return this.issue;
    }
    public void setIssue(String issueInput){
        this.issue = issueInput;
    }
    public void deleteIssue(int issueID){}

    public User getOwner(){
        return this.owner;
    }
    public void setOwner(User ownerInput){
        this.owner = ownerInput;
    }

    public ArrayList<User> getAssignee(){
        return this.assignee;
    }
    public void setAssignee(ArrayList<User> assigneeInput){
        this.assignee = assigneeInput;
    }

    public Date getCreateDate(){
        return this.createDate;
    }
    public void setCreateDate(Date createDateInput){
        this.createDate = createDateInput;
    }

    public int getPriority(){
        return this.priority;
    }
    public void setPriority(int priorityInput){
        this.priority = priorityInput;
    }

    public int getStatus(){
        return this.status;
    }
    public void setStatus(int statusInput){
        this.status = statusInput;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String descriptionInput){
        this.description = descriptionInput;
    }

    public ArrayList<Comment> getComment(){
        return this.comments;
    }

    public void viewTicket(int ticketID){
    	/*
    	 * need a return value here
    	 */
    }

    public String toString(){return "";}

    public int getID(){
        return this.id;
    }

    public void setSeen(Boolean seenInput){
        this.seen = seenInput;
    }
    public boolean getSeen(){
        return this.seen;
    }

}
