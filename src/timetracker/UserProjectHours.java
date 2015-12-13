/*
 * UserProjectHours
 */
package timetracker;

/**
 *
 * @author Deborah Goossens
 */
public class UserProjectHours {
    int userid, projectId;
    double hours;
    
    public UserProjectHours(int userId, int projectId) {
        this.userid = userId;
        this.projectId = projectId;
        hours = 0;
    }
    
    public double GetHours() {
        return hours;
    }
    
    public void AddHours(double hours) {
        this.hours += hours;
    }

}
