/*
 * UserProjectHours object.
 */
package timetracker;

/**
 * @author Deborah van der Vegt
 */
public class UserProjectHours
{
    /**
     * The userid and projectid property.
     */
    int userid, projectId;
    
    /**
     * The hours property.
     */
    double hours;
    
    /**
     * New UserProjectHours.
     */
    public UserProjectHours(int userId, int projectId, double hours)
    {
        this.userid = userId;
        this.projectId = projectId;
        this.hours = hours;
    }
}