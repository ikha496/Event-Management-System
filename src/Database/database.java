package Database;

import java.sql.*;
import java.util.*;
public class database {
    public static Connection con = null;
    public static java.sql.PreparedStatement ps ;

    public database() {
        connect();
    }
    
    //finished
    public void connect() 
      {
          if(con==null){
          try {
              con= DriverManager.getConnection("jdbc:sqlite:EventManagment");
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          }
          }
    }
    //finished
    public void create(){

        try {
           ps = con.prepareStatement
                ("CREATE TABLE users (ID INTEGER UNIQUE,eMail TEXT NOT NULL UNIQUE,name TEXT NOT NULL,username TEXT NOT NULL UNIQUE, password TEXT NOT NULL,role TEXT NOT NULL,PRIMARY KEY(ID AUTOINCREMENT))");
            System.out.println("Table is created");
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //finished
    public void insertUser(String name ,String email ,
        String password,int phoneNumber,String role,String gender){
         try {
           ps = con.prepareStatement
                ("INSERT into users (name,eMail,password,phoneNumber,role,gender)"
                        + " values (?,?,?,?,?,?)");
           
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setInt(4, phoneNumber);
            ps.setString(5, role);
            ps.setString(6, gender);
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //finished
    public void insertEvent(String eventName ,String location ,
            String eventDetails,String password, int reservation,String email){
        connect();
         try {
           java.sql.PreparedStatement ps1 = con.prepareStatement
                ("INSERT into events (eventName,location,eventDetails,password,"
                        + "status,reservationNumber,ownerEmail)"
                        + " values (?,?,?,?,?,?,?)");
           
            ps1.setString(1, eventName);
            ps1.setString(2, location);
            ps1.setString(3, eventDetails);
            ps1.setString(4, password);
            ps1.setString(5, "admin");
            ps1.setInt(6, reservation);
            ps1.setString(7, email);
            ps1.execute();
            ps1.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //finished
    public ResultSet login(String email) throws SQLException{
        String password;
        try {
            ps =con.prepareStatement("SELECT * FROM users WHERE eMail=?");
            ps.setString(1, email);
            ResultSet resultSet =ps.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void showBill(){
        
    }
    //finished
    public ResultSet getEvents (String role){
       try {
            connect();
            ps =con.prepareStatement("SELECT * FROM events WHERE status=?");
            ps.setString(1, role);
            ResultSet resultSet =ps.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return null;
    }
    //finished
    public ResultSet sendEvents (String eventName, String password){
       try {
            connect();
            ps =con.prepareStatement("SELECT * FROM events WHERE eventName=?");
            ps.setString(1, eventName);
            ResultSet resultSet= ps.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return null;
    }
    //finished
    public static void update(String oldRole,String newRole){
        try {
           ps = con.prepareStatement
                ("UPDATE events set status =? WHERE status =?");
            ps.setString(1,newRole);
            ps.setString(2, oldRole);
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
    }
    
    public void addPriceDate(String reservationNumber,String price,String date){
        try {
           ps = con.prepareStatement
                ("UPDATE events set price =?, readyDate=? where reservationNumber=?");
            ps.setString(1,price);
            ps.setString(2,date);
            ps.setInt(3, Integer.parseInt(reservationNumber));
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
    }
}

