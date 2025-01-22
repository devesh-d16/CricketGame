public class UI {

    public void displayWelcomeMessage(){
        System.out.println("------------------------------------");
        System.out.println("--------------Welcome---------------");
        System.out.println("----------------To------------------");
        System.out.println("--------Java Premiere League--------");
        System.out.println("------------------------------------");
    }

    public void displayLine(){
        System.out.println("------------------------------------");
    }

    public void displayTeamScore(Team team){
        System.out.println(team.getName() + " scored " + team.getScore());
    }

    public void displayOvers(int overs){
        System.out.println();
        System.out.println(overs + " overs");
    }

    public void displayRunByBall(int run){
        if(run == -1){
            System.out.print("W ");
        }
        else if (run == 0) {
            System.out.print(". ");
        }
        else{
            System.out.print(run + " ");
        }
    }

    public void displayAllOutOrOutscored(boolean allout, boolean outscored){
        if(outscored){
            System.out.println();
            System.out.println("Outscored");
        }
        else if(allout){
            System.out.println();
            System.out.println("All out");
        }
    }

    public void displayInningsEndMessage(){
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("------------Innings Over------------");
        System.out.println("------------------------------------");
        System.out.println();
    }

    public void displayMatchResult(String name){
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("The winner is: " + name);
        System.out.println("------------------------------------");
    }
}
