import java.util.Scanner;

public class Game {
    UI ui = new UI();
    Scanner sc = new Scanner(System.in);

    void run() throws InterruptedException {

        // Display Welcome Message
        ui.displayWelcomeMessage();

        // Team 1 initialisation
        System.out.println("Please enter your team name: ");
        Team team1 = new Team(sc.nextLine());

        // Team 2 initialisation
        System.out.println("Please enter opponent team name: ");
        Team team2 = new Team(sc.nextLine());

        // input overs
        int overs = inputOver();
        sc.nextLine();

        // toss
        Team battingTeam = toss(team1, team2);

        // Game starts
        gameStart(battingTeam, team1, team2, overs);
    }

    void gameStart(Team battingTeam, Team team1, Team team2, int overs) throws InterruptedException {
        System.out.println("Starting game.....");
        Cricket match;
        if(battingTeam == team1) {
            match = new Cricket(overs, team1, team2, ui);
        }
        else{
            match = new Cricket(overs, team2, team1, ui);
        }
        match.game();
    }

    Team toss(Team team1, Team team2){
        Toss tossResult = null;
        while (tossResult == null) {
            System.out.println("Toss time....Heads or Tails (H/T):");
            String input = sc.nextLine();
            try {
                tossResult = Toss.inputToss(input.toUpperCase());
            }
            catch (IllegalArgumentException e) {
                System.err.println("Invalid input! Please choose between H or T!");
            }
        }
        return (tossResult == Toss.TAILS) ? team2 : team1;
    }

    int inputOver(){
        int overs = -1;
        boolean validOvers = false;

        while (!validOvers) {
            try {
                System.out.println("Enter number of overs: ");
                overs = sc.nextInt();
                if (overs <= 0 || overs > 100) {
                    System.err.println("Overs must be between 1 and 100.");
                }
                else {
                    validOvers = true;
                }
            } catch (Exception e) {
                System.err.println("Invalid input! Please enter a valid number.");
                sc.nextLine();
            }
        }
        return overs;
    }
}
