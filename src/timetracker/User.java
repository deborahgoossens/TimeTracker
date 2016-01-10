/*
 * User object
 */
package timetracker;

/**
 * @author Deborah van der Vegt
 */
public class User {
    /**
     * id and name pSroperties
     */
    int id;
    String name;
    
    /**
     * New user
     * @param id
     * @param name
     */
    public User(int id, String name) {
        this.name = name;
        this.id = id;        
    }
}