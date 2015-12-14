/*
 * UserProjectHours object
 */
package timetracker;

/**
 * @author Deborah Goossens
 */
public class UserProjectHours {
    /**
     * Userid and projectId property
     */
    int userid, projectId;
    
    /**
     * Hours property
     */
    double hours;
    
    /**
     * New UserProjectHours
     */
    public UserProjectHours(int userId, int projectId) {
        this.userid = userId;
        this.projectId = projectId;
        hours = 0;
    }
    
    /**
     * Gets the registered hours for specific project and user
     * @return double
     */
    public double GetHours() {
        return hours;
    }
    
    /**
     * Adds hours to a specific project and user
     * @return void
     */
    public void AddHours(double hours) {
        this.hours += hours;
    }
}
