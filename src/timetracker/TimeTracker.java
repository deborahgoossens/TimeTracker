/*
 * TimeTracker package
 */
package timetracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import timetracker.*;

/**
 * @author Deborah Goossens
 */
public class TimeTracker {
    
    /**
     * User property
     */
    private static User user;
    
    /**
     * Project property
     */
    private static Project[] projects;
    
    /**
     * Client property
     */
    private static Client[] clients;
    private static List<Client> clientList;
    
    /**
     * UserProjectHours property
     */
    private static UserProjectHours[] userProjectHours;

    /**
     * Main class
     * @param args
     */
    public static void main(String[] args) {
        user = LogIn();
        projects = new Project[] {};
        clientList = new ArrayList<Client>();

        clients = new Client[] {};
        userProjectHours = new UserProjectHours[] {};
        
        if (null != user) {
            System.out.println("Ingelogd als: " + user.name);
            ShowMenu();
        }
        
//        Project project = new Project(1, "project x", client.id, 100, sdate, edate);
//        
//        User user = new User("Deborah");
//        UserProjectHours userProjectHours = new UserProjectHours(user.id, project.id);
//
//        System.out.println("aantal uur dat "+user.name+" aan "+project.name+" heeft gewerkt is: "+userProjectHours.GetHours());
//        userProjectHours.AddHours(20);
//        System.out.println("aantal uur dat "+user.name+" aan "+project.name+" heeft gewerkt is: "+userProjectHours.GetHours());
//
//        System.out.println("Aan project "+project.name+" is "+project.GetCurrentHours()+" gewerkt. er zijn nog "+project.HoursAvailable()+" uur beschikbaar van de "+project.GetMaxHours());
//
//        project.AddHours(20);
//
//        System.out.println("Aan project "+project.name+" is "+project.GetCurrentHours()+" gewerkt. er zijn nog "+project.HoursAvailable()+" uur beschikbaar van de "+project.GetMaxHours());
//        
    }

    /**
     * Add new user
     * @return User
     */
    private static User LogIn() {
        User newUser;
        String userName;
        int userAction;
        Scanner input = new Scanner(System.in);
        
        System.out.print("1 - Inloggen, 2 - Registreren: ");
        userAction = input.nextInt();
        
        if (userAction == 1 || userAction == 2) {
            System.out.print("Gebruikersnaam: ");
            userName = input.next();
            newUser = new User(userName);

            return newUser;
        }
        else {
            return null;
        }
    }

    /**
     * Adds the action menu
     * @return void
     */
    private static void ShowMenu() {
        Scanner input = new Scanner(System.in);
        
        System.out.println(" ");
        System.out.println("1 - Uren registreren");
        System.out.println("2 - Project toevoegen");
        System.out.println("3 - Klant toevoegen");
        System.out.println("4 - Geregistreerde uren bekijken");
        System.out.println("5 - Uitloggen");
        System.out.print("Ga naar: ");

        int action = input.nextInt();

        switch (action) {
            case 1:
                RegisterHours();
                break;
            case 2:
                RegisterProject();
                break;
            case 3:
                RegisterClient();
                break;
            case 4:
                Logbook();
                break;
            case 5:
                System.exit(0);
        }
    }

    /**
     * Register hours on a project
     * @return void
     */
    private static void RegisterHours() {
        int amountOfProjects = projects.length;

        if (amountOfProjects < 1) {
            System.out.println("Er zijn geen projecten. Voeg eerst een project toe.");
        }
        else {
            System.out.println("Selecteer een project: ");
        }
        ShowMenu();
    }

    /**
     * Add a new project
     * @return void
     */
    private static void RegisterProject() {
        int amountOfClients = clientList.size();
        Scanner input = new Scanner(System.in);

        if (amountOfClients < 1) {
            System.out.println("Er zijn geen klanten. Voeg eerst een klant toe.");
        }
        else {
            System.out.println("Selecteer een klant: ");
            for (Client client : clientList) {
                System.out.println(client.id + " - " + client.name);
            }
            int clientId = input.nextInt();
            //        Project project = new Project(1, "project x", clientId, 100, sdate, edate);
            System.out.print("Geef een projectnaam op:  ");
            String projectName = input.next();
            
            System.out.print("Geef het maximum aantal uur op dat geregistreerd mag worden:  ");
            int maxHours = input.nextInt();
            
            System.out.print("Geef de startdatum op (Y-m-d):  ");
            Date startDate = new Date(input.next());
//        Date edate = new Date(2016-1900,1,1);
            
            System.out.print("Geef de einddatum op (Y-m-d):  ");
            Date endDate = new Date(input.next());
            
            Project project = new Project(1, projectName, clientId, maxHours, startDate, endDate);
            System.out.println(project);
            
        }
        ShowMenu();
    }

    /**
     * Add a new client
     * @return void
     */
    private static void RegisterClient() {
        Client newClient;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Voer klantnaam in: ");
        
        String clientName = input.next();
        newClient = new Client( (clientList.size( )), clientName);
        
        clientList.add(newClient);
        System.out.println("Klant " + clientList.get(clientList.size() - 1).name + " toegevoegd.");
        System.out.println("Aantal klanten: " + clientList.size() );

        ShowMenu();
    }

    /**
     * Show the logged hours for the user
     * @return void
     */
    private static void Logbook() {
        
    }
    
}
