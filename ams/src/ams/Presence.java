/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maan Alaulaqi (201610814@aau.ac.ae)
 */
public class Presence {
    private static dbControl db = new dbControl();
    private static dbControl dbUpdate = new dbControl();
    private static dbLookUp LookUp;
    private static ClassThread classC;
    
    
    
    
    public Presence(){}
    /**
     * The timeCheck() method is meant to be an inclusive method that can be used
     * anyhwhere in the application to check whether the current time has any 
     * ongoing classes. 
     * 
     * @return Time Check Positive or Negative
     */
    public static boolean timeCheck(){
        String start="", end="";
        int startX = 0, endX = 0, currentTime,classNum; 
        //Time x;
        classNum = classC.classCheck();
        //System.out.println(classNum);
        db.dbComd("select active_classes.id, name, start_time, end_time, firstt_class, second_class from active_classes join class on active_classes.CLASS_ID = class.id join class_schedule on active_classes.class_schedule_id = class_schedule.id where active_classes.ID = " +classNum);
        if (classNum == 0){
            System.out.println("There are no classes at this time to register your attendance to.");
            return false;
        }else{
            try {
                if(db.rs.next()){
                    start = db.rs.getString("START_TIME");
                    startX = toMins(start);
                    end = db.rs.getString("END_TIME");
                    endX = toMins(end);
                }//else db.doClose();
            } catch (SQLException ex) {
                Logger.getLogger(Presence.class.getName()).log(Level.SEVERE, null, ex);
            }finally {db.doClose();}
            //The following 3 lines is to obtain the current time in HH:MM format to use in "tiMins" method.
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
            LocalDateTime now = LocalDateTime.now();
            currentTime = toMins(dtf.format(now));
            //currentTime = currentTime - 500; //Testing methods that rely on this variable. 
            System.out.println(currentTime + " Altered currenttime " +startX);
            if(currentTime >= startX && currentTime <= endX){
                System.out.println("Time Check positive");
                return true;
            }else {
                System.out.println("Time Check negative");
                return true;
                //TO-DO Present profile
            }
        }
    }
    /**
     * There are times when the instructor is late or not present during a lecture. 
     * This method is geared towards activating the the AMS 15 minutes into 
     * class automatically so students who've attended may mark their presence
     * in the system.
     * 
     */
    public static void FifteenMinActivate(){
        String start, end;
        int startX = 0, endX = 0, currentTime; 
        Time x;
        db.dbComd("SELECT * FROM CLASS_SCHEDULE");
        try {
            if(db.rs.next()){
                start = db.rs.getString("START_TIME");
                startX = toMins(start);
                end = db.rs.getString("END_TIME");
                endX = toMins(end);
            }else db.doClose();
        } catch (SQLException ex) {
            Logger.getLogger(Presence.class.getName()).log(Level.SEVERE, null, ex);
        }finally {db.doClose();}
        //The following 3 lines is to obtain the current time in HH:MM format to use in "tiMins" method.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));
        currentTime = toMins(dtf.format(now));
        if(currentTime >= (startX+15) && currentTime <= endX){
            //TO-DO Activate for students 100% regardless of whether professor is there
        }else{
            //TO-DO Present profile
        }
    }
    /**
     * This method is meant for the timeCheck method. It returns the minute format for DD:HH:MM
     * 
     * @param s This is a method used to turn HH:MM:SS format into one int number in MINUTES only. It helps with time comparisons. 
     * @return HoursInMins 
     */
    public static int toMins(String s) {
    String[] hourMin = s.split(":");
    int hour = Integer.parseInt(hourMin[0]);
    int mins = Integer.parseInt(hourMin[1]);
    int hoursInMins = hour * 60;
    return hoursInMins + mins;
}
    public static boolean readStudentUID = false;
    public static String UIStudentName;
    public static void MarkPresent(String UID){
        
        int id_test = -1;
        //TO-DO Main Attendance taking method
        int class_id = ClassThread.classCheck();
        class_id = 2;
        if(timeCheck()){
            int class_idFromTable; String student_idFromTable;
            System.out.print(" MarkPresent() reached successfully. ");
            try {
            
            int x = dbUpdate.dbComdUpdate.rsUpdateMe("update attend \n" +
                    "    set present = true\n" +
                    "    where student_id = (SELECT attend.student_id FROM ATTEND\n" +
                    "    JOIN STUDENT ON STUDENT.ID = ATTEND.STUDENT_ID \n" +
                    "    JOIN ACTIVE_CLASSES ON ACTIVE_CLASSES.ID = ATTEND.CLASS_ID\n" +
                    "    WHERE STUDENT.CARD_ID = '"+UID+"'\n" +
                            "    AND ACTIVE_CLASSES.ID = "+class_id+")\n" +
                            "    and class_id = (SELECT attend.class_id FROM ATTEND\n" +
                            "    JOIN STUDENT ON STUDENT.ID = ATTEND.STUDENT_ID \n" +
                            "    JOIN ACTIVE_CLASSES ON ACTIVE_CLASSES.ID = ATTEND.CLASS_ID\n" +
                            "    WHERE STUDENT.CARD_ID = '"+UID+"'\n" +
                            "    AND ACTIVE_CLASSES.ID = "+class_id+")");
            
            dbUpdate.dbComdUpdate("SELECT * FROM ATTEND\n" +
                    "    JOIN STUDENT ON STUDENT.ID = ATTEND.STUDENT_ID \n" +
                    "    JOIN ACTIVE_CLASSES ON ACTIVE_CLASSES.ID = ATTEND.CLASS_ID\n" +
                    "    WHERE STUDENT.CARD_ID = '"+UID+"'\n" +
                    "    AND ACTIVE_CLASSES.ID = "+class_id+"");   
            System.out.println("||  " + dbUpdate.rsUpdate.getConcurrency() + " CONCURRENCY HERE ");
            System.out.println("||  " + ResultSet.CONCUR_UPDATABLE+ " CONCURRENCY HERE ResultSet.CONCUR_UPDATABLE ");
            
                if(dbUpdate.rsUpdate.next()){ //dbControl.rs.updateRow();
                    //dbUpdate.rs.moveToInsertRow();
                    student_idFromTable = dbUpdate.rsUpdate.getString("STUDENT_ID");
                    class_idFromTable = dbUpdate.rsUpdate.getInt("CLASS_ID");
                    dbUpdate.dbComdUpdate("select present from attend where student_id = "+student_idFromTable+" and card_id= "+class_idFromTable);
                    dbUpdate.rsUpdate.updateBoolean("present", true);
                    dbUpdate.rsUpdate.updateRow();
//                    id_test = db.rs.getInt("ID");
//System.out.println("ID # is: "+id_test);
//} db.doClose();
//dbControl.dbComdUpdate("SELECT * FROM STUDENT_PRESENCE JOIN STUDENT ON STUDENT_PRESENCE.STUDENT_ID = STUDENT.ID WHERE STUDENT_PRESENCE.STUDENT_ID = " +id_test);
//                if(dbControl.rs.next()){
//                    k = Integer.parseInt(dbControl.rs.getInt("PRESENT") +"");
//                    System.out.println("Reached this part! "+dbControl.rs.getRow()+" "+k); //Checking
//                    k++;
//                    w = (""+k);
//                    readStudentUID = true;
//                    UIStudentName = dbControl.rs.getString("first_name")+" "+dbControl.rs.getString("last_name");
//                    //dbControl.dbComdUpdate("select present from student_presence");
//                    dbControl.rs.updateString("present",w);
//                    dbControl.rs.updateRow();
//                }
//dbControl.doClose();
                }else {
//Meh, not much to do here  lol
                }
            } catch (SQLException ex) {
                Logger.getLogger(Presence.class.getName()).log(Level.SEVERE, null, ex);
            
//InterfaceCmds.getCurrentStudent(UID);
            }finally {dbUpdate.doClose();}

        
        
    }
    }
    //This will most likely be a button, so we want to send in as much info as 
    //we can, without any work from the instructor.
    //We can send in a boolean, or int, to signify UP/DOWN in terms of presence
    /**
     * The following three methods are geared towards adjusting a student's presence
     * in a certain class. 
     * @param UID Card UID
     * @param req  req
     */
    public static void AdjustPresence(String UID, boolean req){ 
        //TO-DO Method for moments where instructors needs to adjust a presence
        //Utilize the UpPresence and DownPresence for this
       if(req == true) UpPresence(UID);
       else DownPresence(UID);
        
    }
    public static void UpPresence(String UID){
        //TO-DO Present +1 
        //int classNum = ClassThread.classCheck();
        int id_test = -1;
        //TO-DO Main Attendance taking method
        if(timeCheck()){
            int k; String w;
            try {
                db.dbComd("SELECT ID FROM STUDENT WHERE CARD_ID ='"+UID+"'");
                if(db.rs.next()){
                    id_test = db.rs.getInt("ID");
                    //System.out.println("ID # is: "+id_test);
                }
                db.dbComdUpdate("SELECT * FROM STUDENT_PRESENCE WHERE STUDENT_ID = " +id_test);
                if(db.rs.next()){
                    k = Integer.parseInt(db.rs.getInt("PRESENT") +"");
                    System.out.println("Reached this part! "+db.rs.getRow()+" "+k); //Checking
                    k++;
                    w = (""+k);
                    db.rs.updateString("present",w);
                    db.rs.updateRow();
                }
            }catch (SQLException ex) {
                Logger.getLogger(ams_main.class.getName()).log(Level.SEVERE, null, ex);
            }finally{ db.doClose();}
        }else {
            //Meh, not much to do here  lol
        }
    }
    public static void DownPresence(String UID){
        //TO-DO Present -1
        //int classNum = ClassThread.classCheck();
        int id_test = -1;
        //TO-DO Main Attendance taking method
        if(timeCheck()){
            int k; String w;
            try {
                db.dbComd("SELECT ID FROM STUDENT WHERE CARD_ID ='"+UID+"'");
                if(db.rs.next()){
                    id_test = db.rs.getInt("ID");
                    //System.out.println("ID # is: "+id_test);
                }
                db.dbComdUpdate("SELECT * FROM STUDENT_PRESENCE WHERE STUDENT_ID = " +id_test);
                if(db.rs.next()){
                    k = Integer.parseInt(db.rs.getInt("PRESENT") +"");
                    System.out.println("Reached this part! "+db.rs.getRow()+" "+k); //Checking
                    if (k > 0) k--;
                    w = (""+k);
                    db.rs.updateString("present",w);
                    db.rs.updateRow();
                }
            }catch (SQLException ex) {
                Logger.getLogger(ams_main.class.getName()).log(Level.SEVERE, null, ex);
            }finally{ db.doClose();}
        }else {
            //Meh, not much to do here  lol
        }
    }
    
    public static void getPresncePercentage(String UID){
        //TO-DO Return percentage of absence of student
        //Maybe also instructor since we have their presence kaman
    }
    
}
