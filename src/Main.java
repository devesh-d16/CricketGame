import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UI ui = new UI();

        // Display Welcome Message
        ui.displayWelcomeMessage();

        // Team 1 initialisation
        System.out.println("Please enter your team name: ");
        Team team1 = new Team(sc.nextLine());

        // Team 2 initialisation
        System.out.println("Please enter opponent team name: ");
        Team team2 = new Team(sc.nextLine());

        // Overs
        int overs;
        try{
            System.out.println("Enter number of overs: ");
            overs = sc.nextInt();
            if(overs <= 0){
                throw new IllegalArgumentException("Overs must be positive :)");
            }
        }
        catch(Exception e){
            System.err.println("Invalid input! Please enter a valid number");
            return;
        }

        sc.nextLine();

        // Toss Time
        String toss;
        try{
            System.out.println("Toss time....");
            System.out.println("Heads or Tails (H/T): ");
            toss = sc.nextLine().toUpperCase();
            if(!toss.equals("H") && !toss.equals("T")){
                throw new IllegalArgumentException("Must be H or T");
            }
        }catch(Exception e){
            System.err.println("Invalid input! Please try again");
            return;
        }

        // Game starts
        System.out.println("Starting game.....");
        Cricket match;
        if(toss.equals("H")) {
            match = new Cricket(overs, team1, team2, ui);
        }
        else{
            match = new Cricket(overs, team2, team1, ui);
        }
        match.game();
    }
}