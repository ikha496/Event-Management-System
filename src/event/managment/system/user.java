package event.managment.system;
public class user {
    protected int id;
    protected String name;
    protected String eMail;
    protected String password;
    protected String role;
    protected String gender;
    protected int phoneNo;

    public user(String eMail) {
        this.eMail = eMail;
    }
    
}
