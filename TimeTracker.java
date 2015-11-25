/*
 * TimeTracker
 */
package timetracker;

import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Deborah Goossens
 */
public class TimeTracker {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Date sdate = new Date(2015-1900,1,1);
        Date edate = new Date(2016-1900,1,1);
        
        Client client = new Client(1, "Connect Holland");
        Project project = new Project(1, "project x", client.id, 100, sdate, edate);
        
        User user = new User("Deborah");
        UserProjectHours userProjectHours = new UserProjectHours(user.id, project.id);

        System.out.println("aantal uur dat "+user.name+" aan "+project.name+" heeft gewerkt is: "+userProjectHours.GetHours());
        userProjectHours.AddHours(20);
        System.out.println("aantal uur dat "+user.name+" aan "+project.name+" heeft gewerkt is: "+userProjectHours.GetHours());

        System.out.println("Aan project "+project.name+" is "+project.GetCurrentHours()+" gewerkt. er zijn nog "+project.HoursAvailable()+" uur beschikbaar van de "+project.GetMaxHours());

        project.AddHours(20);

        System.out.println("Aan project "+project.name+" is "+project.GetCurrentHours()+" gewerkt. er zijn nog "+project.HoursAvailable()+" uur beschikbaar van de "+project.GetMaxHours());
        
    }
    
}
