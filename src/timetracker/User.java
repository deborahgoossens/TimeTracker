/*
 * User object
 */
package timetracker;

/**
 * @author Deborah Goossens
 */
public class User {
    /**
     * Id property
     */
    int id;
    
    /**
     * Name property
     */
    String name;
    
    /**
     * New user
     */
    public User(String name) {
        this.name = name;
        id = 1;        
    }
}
