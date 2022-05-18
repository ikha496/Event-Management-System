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
public class Sp extends User{

    public Sp() {
    }
    public ResultSet getEvents(){
        Database Db = new Database();
        
        return Db.getEvents("user");
    }
    public void updateEvents(){
        
    }
    
}
