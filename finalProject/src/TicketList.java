import java.util.ArrayList;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Final Project
//@Author  Brady Anderson, Dimitri Leopald, Sid Rath, Hayden Wertz
//Explain: 
//		Ticketlist will keep track of multiple tickets and serve as the
// 		main way to store work that needs to be done and work that has 
//		been completed. Additionally ticketlists serve as a useful way 
//		to keep track of multiple tickets
///////////////////////////////////////////////////////////////////////////////////

public class TicketList {
    public int id;
    public ArrayList<Ticket> tickets;

    public TicketList(int idInput, ArrayList<Ticket> ticketsInput){
        this.id = idInput;
        this.tickets = ticketsInput;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int idInput){
        this.id = idInput;
    }

    public ArrayList<Ticket> getTickets() {
        return this.tickets;
    }
    public void setId(ArrayList<Ticket> ticketsInput){
        this.tickets = ticketsInput;
    }

    public void addTicket(Ticket ticketInput){}

    public void removeTicket(){}

    public String toString(){return "";}




}
