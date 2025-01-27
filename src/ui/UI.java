package ui;

import model.Designation;
import model.Player;
import model.Team;
import model.Toss;

import java.util.List;
import java.util.Scanner;

public class UI {
    private final Scanner sc = new Scanner(System.in);

    public void displayWelcomeMessage(){
        System.out.println("====================================");
        System.out.println("-------------Welcome----------------");
        System.out.println("----------------To------------------");
        System.out.println("--------Java Premiere League--------");
        System.out.println("====================================");
    }

    public String inputTeamName() {
        System.out.print("Please enter team's name: ");
        return sc.nextLine();
    }

    public Player inputPlayer(int playerNumber){
        System.out.println("Enter details for Player " + playerNumber + ":");
        System.out.println("Name: ");
        String name = sc.nextLine();

        Designation designation = null;
        while(designation == null){
            System.out.print("Designation (Bat/Bowl): ");
            try{
                designation = Designation.inputDesignation(sc.nextLine());
            }catch(IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }
        return new Player(name, designation);
    }

    public void displayInningsEndMessage(Team team) {
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("------------Innings Over------------");
        System.out.println("------------------------------------");

        int runs = team.getScore();
        int wickets = team.getWicket();

        System.out.println("Runs scored by " + team.getName() + " : " + runs + "/" + wickets);
    }


    public void displayMatchResult(Team teamWon, Team teamLost, int won) {
        System.out.println();
        System.out.println("------------------------------------");
        if(won == 0){
            int difference = teamWon.getScore() - teamLost.getScore();
            System.out.println(teamWon.getName() + " won by " + difference + " runs.");
        }
        else{
            int difference = 10 - teamWon.getWicket();
            System.out.println(teamWon.getName() + " won by " + difference + " wickets.");
        }
        System.out.println("------------------------------------");
        System.out.println();
    }

    public void displayRunByBall(int run){
        if(run == -1){
            System.out.print("W ");
        }
        else if(run == 0){
            System.out.print(". ");
        }
        else{
            System.out.print(run + " ");
        }
    }

    public void displayOverStat(int overNo, int runThisOver){
        System.out.println();
        System.out.println("Runs scored in over " + overNo + ": " + runThisOver);
    }

    public int inputOvers() {
        int overs = -1;
        while(overs < 1 || overs > 100){
            System.out.println("Enter the number of overs (1-100): ");
            try{
                overs = Integer.parseInt(sc.nextLine());
                if(overs < 1 || overs > 100){
                    System.err.println("Invalid input! Please enter a value between 1 and 100");
                }
            }
            catch(NumberFormatException e){
                System.err.println("Invalid input! Please enter a valid number");
            }
        }
        return overs;
    }



    public Toss inputToss() {
        Toss tossResult = null;
        while(tossResult == null){
            System.out.print("Toss Time! Chose Heads or Tails (H/T):");
            try{
                tossResult = Toss.inputToss(sc.nextLine());
            }
            catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }
        return tossResult;
    }

    public void printTeamStats(Team team){
        List<Player> players = team.getPlayers();
        for (Player p : players) {
            System.out.println(p.getName() + " " + p.getDesignation() + " " + p.getRunsScored() + " " + p.getBallsFaced());
        }
    }
}
