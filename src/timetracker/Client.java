/*
 * Client object
 */
package timetracker;

/**
 * @author Deborah Goossens
 */
class Client {
    /**
     * Id property
     */
    public int id;
    
    /**
     * Name property
     */
    public String name;
    
    /**
     * New client
     */
    public Client(int id, String name){
        this.id = id;
        this.name = name;
    }
}
