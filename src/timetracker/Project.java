/*
 * Project object
 */
package timetracker;

import java.util.Date;

/**
 * @author Deborah Goossens
 */
public class Project {
    /**
     * Id and client property
     */
    public int id, clientId;
    
    /**
     * Name property
     */
    public String name;
    
    /**
     * maxHours and currentHours property
     */
    public double maxHours, currentHours;
    
    /**
     * startDate and endDate property
     */
    public Date startDate, endDate;
    
    /**
     * New project
     */
    public Project(int id, String name, int clientId, double maxHours, Date startDate, Date endDate){
        this.id = id;
        this.name = name;
        this.clientId = clientId;
        this.maxHours = maxHours;
        this.currentHours = 0;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    /**
     * Gets the maximum available hours for the project
     * @return double
     */
    public double GetMaxHours() {
        return maxHours;
    }
    
    /**
     * Sets the maximum amount hours for the project
     * @return void
     */
     public void SetMaxHours(double maxHours) {
        this.maxHours = maxHours;
    }
    
    /**
     * Gets the currently amount of hours
     * @return double
     */
    public double GetCurrentHours() {
        return currentHours;
    }
    
    /**
     * Calculates the available hours
     * @return double
     */
    public double HoursAvailable(){
        return maxHours - currentHours;
    }
    
    /**
     * Add an amount of hours
     * @return void
     */
    public void AddHours(double hours) {
        currentHours += hours;
        System.out.println("Er zijn "+hours+" toegevoegd aan "+name+", er zijn nog "+HoursAvailable()+" uur beschikbaar");

    }
    
    /**
     * Checks if you're allowed to register on this project in a specific time
     * @return boolean
     */
    public boolean DateAvailable() {
        Date currentDate = new Date();
        return currentDate.before(endDate) && currentDate.after(startDate);
    }
}
