import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to TKC");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your team name: ");
        String name1 = sc.nextLine();
        Team team1 = new Team(name1);

        System.out.println("Please enter opponent team name: ");
        String name2 = sc.nextLine();
        Team team2 = new Team(name2);

        System.out.println("Enter number of overs: ");
        int overs = sc.nextInt();
        sc.nextLine();
        System.out.println("Toss time....");
        System.out.println("Heads or Tails (H/T): ");
        String toss = sc.nextLine();

        System.out.println("Starting game.....");

        if(toss.equals("H")) {
            Cricket c = new Cricket(overs, team1, team2);
            c.game();
        }
        else{
            Cricket c = new Cricket(overs, team2, team1);
            c.game();
        }
    }
}