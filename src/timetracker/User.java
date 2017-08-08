/*
 * User object.
 */
package timetracker;

/**
 * @author Deborah van der Vegt
 */
public class User
{
    /**
     * The id property.
     */
    int id;
    
    /**
     * The name property.
     */
    String name;
    
    /**
     * New user.
     * 
     * @param id
     * @param name
     */
    public User(int id, String name)
    {
        this.name = name;
        this.id = id;        
    }
}