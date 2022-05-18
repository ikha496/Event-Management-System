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
public class Customer extends User {
    public Customer(){
        this.role = "customer";
    }
    public void insertEvent(Event event){
        Database d= new Database();
        d.insertEvent(event.eventName, event.location, event.eventDetails,event.password, event.reservationNo, event.ownerMail);
    }
    public ResultSet getEvents(){
        Database d = new Database();
        return d.getEvents(this.role);
    }
}
