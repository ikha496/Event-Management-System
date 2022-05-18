package event.managment.system;
public class User {
    protected int id;
    protected String name;
    protected String eMail;
    protected String password;
    protected String role;
    protected String gender;
    protected int phoneNo;
    protected String username;
    
    public User(String eMail) {
        this.eMail = eMail;
    }
    public User(){
        
    }
    
}
