public class UI {

    public void displayWelcomeMessage(){
        System.out.println("Welcome to Java Premiere League");
    }

    public void displayTeamScore(Team team){
        System.out.println(team.getName() + " scored " + team.getScore());
    }

    public void displayOvers(int overs){
        System.out.println(overs + " overs");
    }

    public void displayMatchResult(String name){
        System.out.println("The winner is: " + name);
    }
}
