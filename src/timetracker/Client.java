/*
 * Client object
 */
package timetracker;

/**
 * @author Deborah van der Vegt
 */
class Client {
    /**
     * id and name properties
     */
    public int id;
    public String name;
    
    /**
     * New client
     */
    public Client(int id, String name){
        this.id = id;
        this.name = name;
    }
}