/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import static ams.Presence.toMins; //easier than setting up a different variable for every time I use this..
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *The idea here is to try and have a constant java thread that's consistently checking 
 * the time to see verify which class is currently ongoing. 
 * The main use I have for this is for the Presence class, the timeCheck() method
 * 
 * @author Maan Alaulaqi (201610814@aau.ac.ae)
 */
public class ClassThread {
    private static Presence timeCheck;
    
    public ClassThread(){}
    
    /**
     * This method is to check which "time slot" of the day as class is ongoing.
     * The classCheck() method is written with knowledge of the tables in the 
     * database. 
     * @return 
     */
    public static int classCheck(){//Nothing wrong here
        int class_id = -1;
        String DayWeek;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtfWEEK = DateTimeFormatter.ofPattern("EEEE");  
        LocalDateTime DayOfWeek = LocalDateTime.now();
        DayWeek = dtfWEEK.format(DayOfWeek);
        //System.out.println(DayWeek);
        //System.out.println(dtf.format(now));
        int currentTime = toMins(dtf.format(now));
        currentTime = currentTime - 500;
        //System.out.println(currentTime);
        //Begin organizing preset class timings..
        String classOneBegin = "11:00", classTwoBegin = "12:30", classThreeBegin = "14:00", classFourBegin = "16:30", classFourEnd = "18:00";
        int classOneBeginX, classTwoBeginX, classThreeBeginX, classFourBeginX, classFourEndX;
        classOneBeginX = timeCheck.toMins(classOneBegin);
        
        classTwoBeginX = timeCheck.toMins(classTwoBegin);
        classThreeBeginX = timeCheck.toMins(classThreeBegin);
        classFourBeginX = timeCheck.toMins(classFourBegin);
        classFourEndX = timeCheck.toMins(classFourEnd);
        //...End. I feel confident that I could've found a faster, more inclusive solution to this, but time is of the essence..
        //For the future, I'd put these into an array. It'd make for faster access and upgradability for more classes. 
        //(Array size will depend on the lastRow of the of class db table)
        
        //Now to compare the time with each "cycle" and return an int that represent the current class. 
        if(DayWeek.equalsIgnoreCase("Monday") || DayWeek.equals("Wednesday")) {
            if (currentTime >= classOneBeginX && currentTime <= classTwoBeginX) {
                class_id = 4; 
            }else if(currentTime >= classFourBeginX && currentTime <= classFourEndX){
                class_id = 3;}
        }else if (DayWeek.equals("Sunday") || DayWeek.equals("Tuesday")){
            if(currentTime >= classTwoBeginX && currentTime <= classThreeBeginX){
                class_id = 1;
            }else if(currentTime >= classThreeBeginX && currentTime <= classFourBeginX){
                class_id = 2;}
        }else if (DayWeek.equals("Thursday") || DayWeek.equals("Friday") || DayWeek.equals("Saturday")) 
            class_id = 0; //Outside of class time ..
        System.out.println(classOneBeginX + " " + DayWeek);
        // This return should never be reached, the method just needed a return statement
        return class_id;
        //return 2; //Return tester

    }
}
