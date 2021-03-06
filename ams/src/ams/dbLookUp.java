/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** A class assigned for certain multi use code (UID look-up)
 *
 * @author Maan Alaulaqi (201610814@aau.ac.ae)
 */
public class dbLookUp {
    private static dbControl db;
    
    public dbLookUp(){}
    /**
     * This is a method to check if the card scanned is belongs to either a student or an instructor
     * It will return true for instructors and false for students
     * 
     * @param uid Card UID
     * @return False = Student, True = Instructor
     */
    public static boolean uidCheck(String uid){
        String x = null, y = null;
        boolean placeholder = false;
        try{
            db.dbComd("SELECT FIRST_NAME, LAST_NAME FROM STUDENT WHERE CARD_ID = '"+uid+"'");
            if(db.rs.next()){
                x = db.rs.getString("FIRST_NAME")+" "+db.rs.getString("LAST_NAME");
               // System.out.println(db.rs.getRow());
                System.out.println(x);
                db.doClose();
            } else db.doClose();
            db.dbComd("SELECT FIRST_NAME, LAST_NAME FROM INSTRUCTOR WHERE CARD_ID = '"+uid+"'");
            if(db.rs.next()){
                y = db.rs.getString("FIRST_NAME")+" "+db.rs.getString("LAST_NAME");
                //System.out.println(db.rs.getRow());
                System.out.println(y);
                db.doClose();
            } else db.doClose();
        } catch (SQLException ex) {
            Logger.getLogger(dbLookUp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{db.doClose();}
        //False = Student
        //True = Instructor
        if(x != null){
            System.out.println("A student");
            return false;
        }else if(y != null){
            System.out.println("An instructor");
            return true;
        }else {
            System.out.println("Not in the database");
            return false;
        }
    }
    
    

}
