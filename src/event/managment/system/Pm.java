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
public class Pm extends User{

    public Pm() {
        this.role = "PM";
    }
    
    public ResultSet getCustomerRequest(){
        Database d = new Database();
        return d.getEvents("pm1");
    }
    public ResultSet getFinishedEvents(){
        Database d= new Database();
        return d.getEvents("pm2");
    }
    public void sendEventsToSp(){
        Database.update("pm1", "sp");
    }
    public void sendEventsToCustomer(){
        Database.update("pm2", "user2");
    }
}

