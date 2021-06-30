////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Final Project
//  @Author  Brady Anderson, Dimitri Leopald, Sid Rath, Hayden Wertz
//  Explain: 
//  	The user class can have multiple types of roles. It serves as our 
//		core identity piece of the project. Users can create tickets, comments,
//		and with proper permissions create projects/sprints
///////////////////////////////////////////////////////////////////////////////////

public class User {

    public String name;
    public String username;
    public String password;
    public String role;

    public User(String nameInput, String usernameInput, String passwordInput, String roleInput){
        this.name = nameInput;
        this.username = usernameInput;
        this.password = passwordInput;
        this.role = roleInput;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String nameInput){
        this.name = nameInput;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String usernameInput){
        this.username = usernameInput;
    }
    public String getPassword(){
        return this.getPassword();
    }
    public void setPassword(String passwordInput){
        this.password = passwordInput;
    }
    public String getRole(){
        return this.role;
    }
    public void setRole(String roleInput){
        this.role = roleInput;
    }
    public String toString() {
    	return getUsername() + ": " + getRole();
    }
}
