/*
 * Client object.
 */
package timetracker;

/**
 * @author Deborah van der Vegt
 */
class Client
{
    /**
     * The id property.
     */
    public int id;
    
    /**
     * The name property.
     */
    public String name;
    
    /**
     * New client.
     */
    public Client(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}