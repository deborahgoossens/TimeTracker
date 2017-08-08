/*
 * TimeTracker package.
 */
package timetracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Deborah van der Vegt
 */
public class TimeTracker
{
    
    /**
     * The User property.
     */
    private static List<User> userList;
    
    /**
     * The Project property.
     */
    private static List<Project> projectList;
    
    /**
     * The Client property.
     */
    private static List<Client> clientList;
    
    /**
     * The UserProjectHours property.
     */
    private static List<UserProjectHours> userProjectHoursList;
    
    /**
     * The User property.
     */
    private static User currentUser;

    /**
     * Main class.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        userList = new ArrayList<User>();
        projectList = new ArrayList<Project>();
        clientList = new ArrayList<Client>();
        userProjectHoursList = new ArrayList<UserProjectHours>();
                
        LogIn(); 
    }

    /**
     * Add new user.
     */
    private static void LogIn()
    {
        User newUser;
        String userName;
        int userAction;
        Scanner input = new Scanner(System.in);
        
        System.out.print("1 - Inloggen, 2 - Registreren: ");
        userAction = input.nextInt();
        
        if (userAction == 1 || userAction == 2) {
            System.out.print("Gebruikersnaam: ");
            userName = input.next();
            newUser = new User(userList.size(), userName);
            userList.add(newUser);
            currentUser = newUser;
            System.out.println("Ingelogd als: " + currentUser.name);
            ShowMenu();
        }
    }

    /**
     * Adds the action menu.
     */
    private static void ShowMenu()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println(" ");
        System.out.println("1 - Uren registreren");
        System.out.println("2 - Project toevoegen");
        System.out.println("3 - Klant toevoegen");
        System.out.println("4 - Geregistreerde uren bekijken");
        System.out.println("5 - Andere gebruiker");
        System.out.println("9 - Programma afsluiten");
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
                LogIn();
                break;
            case 9:
                System.exit(0);
        }
    }

    /**
     * Register hours on a project.
     */
    private static void RegisterHours()
    {
            Project project = SelectProject();
            if(project != null) {
                if (project.DateAvailable() && project.HoursAvailable() > 0) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Hoeveel uur wil je registreren? : ");
                    double amountOfHours = input.nextDouble();
                    if (amountOfHours <= project.HoursAvailable() ) {
                        project.AddHours(amountOfHours);
                        
                        UserProjectHours userProjectHours = new UserProjectHours(currentUser.id, project.id, amountOfHours);
                        userProjectHoursList.add(userProjectHours);
                    }
                    else {
                        System.out.println("U kunt nog maximaal " + project.HoursAvailable() + " uur boeken.");
                    }
                }
                else {
                    System.out.println("De einddatum van dit project is verlopen of het project heeft geen uren beschikbaar meer. Neem contact op met je projectmanager.");
                }
            }
        ShowMenu();
    }

    /**
     * Add a new project.
     */
    private static void RegisterProject()
    {
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
            System.out.print("Geef een projectnaam op:  ");
            String projectName = input.next();
            
            System.out.print("Geef het maximum aantal uur op dat geregistreerd mag worden:  ");
            int maxHours = input.nextInt();
            
            System.out.print("Geef de startdatum op (dd/mm/yyyy):  ");
            String startDate = input.next();
            
            System.out.print("Geef de einddatum op (dd/mm/yyyy):  ");
            String endDate = input.next();
            
            Project project = new Project(projectList.size(), projectName, clientId, maxHours, startDate, endDate);
            projectList.add(project);
            
            System.out.println("Nieuw project: " + projectList.get(projectList.size()-1).name + " toegevoegd voor klant: " + clientList.get(clientId).name);
        }
        ShowMenu();
    }

    /**
     * Add a new client.
     */
    private static void RegisterClient()
    {
        Client newClient;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Voer klantnaam in: ");
        String clientName = input.nextLine();
        newClient = new Client(clientList.size(), clientName);
        clientList.add(newClient);
        
        System.out.println("Klant " + clientList.get(clientList.size() - 1).name + " toegevoegd.");
        System.out.println("Aantal klanten: " + clientList.size() );
        ShowMenu();
    }

    /**
     * Show the logged hours for the user.
     */
    private static void Logbook()
    {
        Project project = SelectProject();
        if(userProjectHoursList.size() < 1) {
            System.out.println("Er zijn nog geen geregistreerde uren.");
        }
        else {
            for (UserProjectHours userProjectHours : userProjectHoursList) {
                String userName = userList.get(userProjectHours.userid).name;
                int projectid = projectList.get(userProjectHours.projectId).id;
                String projectName = projectList.get(userProjectHours.projectId).name;
                String clientName = clientList.get(project.clientId).name;
                
                if(projectid == project.id) {
                    System.out.println("Gebruiker " + userName + " heeft " + userProjectHours.hours + "  uren geboekt op project " + projectName + " voor " + clientName);
                }
            }
            System.out.println("===============================================");
            System.out.println("Er zijn voor project " + project.name + " in totaal " + project.currentHours + " uren geboekt.");
        }
        ShowMenu();
    }
    
    /**
     * Show a list of projects.
     */
    private static Project SelectProject()
    {
        if (projectList.size() < 1) {
            System.out.println("Er zijn geen projecten. Voeg eerst een project toe.");
            return null;
        }
        else {
            System.out.println("Selecteer een project: ");
            Scanner input = new Scanner(System.in);
            for (Project project : projectList) {
                System.out.println(project.id + " - " + clientList.get(project.clientId).name + " - " + project.name);
            }
            int projectId = input.nextInt();
            return projectList.get(projectId);
        }
    }
}