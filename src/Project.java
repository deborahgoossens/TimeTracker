/*
 * Project
 */
package timetracker;

import java.util.Date;

/**
 *
 * @author Deborah Goossens
 */
public class Project {
    
    public int id, clientId;
    public String name;
    public double maxHours, currentHours;
    public Date startDate, endDate;
    
    public Project(int id, String name, int clientId, double maxHours, Date startDate, Date endDate){
        this.id = id;
        this.name = name;
        this.clientId = clientId;
        this.maxHours = maxHours;
        this.currentHours = 0;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public double GetMaxHours() {
        return maxHours;
    }
    
     public void SetMaxHours(double maxHours) {
        this.maxHours = maxHours;
    }
     
    public double GetCurrentHours() {
        return currentHours;
    }
    
    public double HoursAvailable(){
        return maxHours - currentHours;
    }
    
    public void AddHours(double hours) {
        currentHours += hours;
        System.out.println("Er zijn "+hours+" toegevoegd aan "+name+", er zijn nog "+HoursAvailable()+" uur beschikbaar");

    }
    
    public boolean DateAvailable() {
        Date currentDate = new Date();
        return currentDate.before(endDate) && currentDate.after(startDate);
    }
}
