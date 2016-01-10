/*
 * UserProjectHours object
 */
package timetracker;

/**
 * @author Deborah van der Vegt
 */
public class UserProjectHours {
    /**
     * userid, projectId and hours properties
     */
    int userid, projectId;
    double hours;
    
    /**
     * New UserProjectHours
     */
    public UserProjectHours(int userId, int projectId, double hours) {
        this.userid = userId;
        this.projectId = projectId;
        this.hours = hours;
    }
}