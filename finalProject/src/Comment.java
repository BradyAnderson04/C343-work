import java.util.Date;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Final Project
//@Author  Brady Anderson, Dimitri Leopald, Sid Rath, Hayden Wertz
//Explain: 
//	This will store data for each comment. This includes the message 
//	author and date created. Comments will convey an update about a 
//	certain issue
///////////////////////////////////////////////////////////////////////////////////

public class Comment {
    public String message;
    public User author;
    public Date created;

    public Comment(String messageInput, User authorInput, Date createdInput){
        this.message = messageInput;
        this.author = authorInput;
        this.created = createdInput;
    }

    public String getMessage(){
        return this.message;
    }
    public void setMessage(String messageInput){
        this.message = messageInput;
    }

    public User getAuthor(){
        return this.author;
    }
    public void setAuthor(User authorInput){
        this.author = authorInput;
    }

    public Date getCreated(){
        return this.created;
    }
    public void setCreated(Date createdInput){
        this.created = createdInput;
    }

    public String toString(){return "";}

}
