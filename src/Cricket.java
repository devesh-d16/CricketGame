public class Cricket {

    static int[] scr = {0, 1, 2, 3, 4, 6, -1};
    Team battingFirst;
    Team battingSecond;
    int overs;


    public Cricket(int overs, Team battingFirst, Team battingSecond) {
        this.overs = overs;
        this.battingFirst = battingFirst;
        this.battingSecond = battingSecond;
    }

    int simulateScore(){
        return scr[(int) (Math.random() * 7)];
    }

    int play(Team team){
        for(int i = 1; i <= overs; i++){
            for(int j = 1; j <= 6; j++){
                int run = simulateScore();
                System.out.print(run + "|");
                if(run == -1){
                    team.wicket++;
                    if(team.wicket == 10){
                        break;
                    }
                }
                else{
                    team.score += run;
                }
            }
            if(team.wicket == 10){
                System.out.println("All out");
                break;
            }
            else{
                System.out.println("Over");
            }
        }
        System.out.println(team.name + " scored " + team.score);
        return team.score;
    }

    void game(){
        int score1 = play(battingFirst);
        int score2 = play(battingSecond);
        if(score1 > score2){
            System.out.println("The winner of the game is: " + battingFirst.name);
        } else if (score1 < score2) {
            System.out.println("The winner of the game is: " + battingSecond.name);
        }
        else {
            System.out.println("Match drawn");
        }
    }

}
