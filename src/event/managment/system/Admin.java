/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.managment.system;

import Database.Database;
import java.sql.ResultSet;

/**
 *
 * @author ibrahim.khaled
 */
public class Admin extends User{
    public Admin(){
        this.role = "admin";
    }
    public void insertUser(User user){
        Database d= new Database();
        d.insertUser(user.name, user.name, user.password, user.phoneNo, user.role, user.gender);
    }
    public ResultSet getEvents(){
        Database d = new Database();
        return d.getEvents("admin");
    }
    public void sendEvents(){
        Database.update("admin", "pm1");
    }
}
