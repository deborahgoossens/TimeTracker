/*
 * Project object
 */
package timetracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Deborah van der Vegt
 */
public class Project {
    /**
     * id, clientId, name, maxHours, currentHours, startDate and endDate properties
     */
    public int id, clientId;
    public String name;
    public double maxHours, currentHours;
    public Date startDate, endDate;
    
    /**
     * Constructor
     * @param id
     * @param name
     * @param clientId
     * @param maxHours
     * @param startDate
     * @param endDate
     */
    public Project(int id, String name, int clientId, double maxHours, String startDate, String endDate){
        this.id = id;
        this.name = name;
        this.clientId = clientId;
        this.maxHours = maxHours;
        this.currentHours = 0;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {      
            this.startDate = sdf.parse(startDate);
        } catch (ParseException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {      
            this.endDate = sdf.parse(endDate);
        } catch (ParseException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Calculates the available hours
     * @return 
     */
    public double HoursAvailable(){
        return maxHours - currentHours;
    }
    
    /**
     * Add an amount of hours
     * @param hours
     */
    public void AddHours(double hours) {
        currentHours += hours;
        System.out.println("Er zijn " + hours + " uren toegevoegd aan project " + name + ". Er zijn nog " + HoursAvailable() + "/" + maxHours + " uren beschikbaar.");

    }
    
    /**
     * Checks if you're allowed to register on this project in a specific time
     */
    public boolean DateAvailable() {
        Date currentDate = new Date();
        return currentDate.before(endDate) && currentDate.after(startDate);
    }
}