public class Cricket extends UI{


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
                System.out.print(run + " ");
                if(run == -1){
                    team.addWicket();
                    if(team.getWicket() == 10){
                        break;
                    }
                }
                else{
                    team.addScore(run);
                }
            }
            System.out.println();
            if(team.getWicket() == 10){
                System.out.println("All out");
                break;
            }
            else{
                displayOvers(i);
            }
        }
        displayTeamScore(team);
        return team.getScore();
    }

    void game(){
        int score1 = play(battingFirst);
        int score2 = play(battingSecond);
        if(score1 > score2){
            displayMatchResult(battingFirst.getName());
        } else if (score1 < score2) {
            displayMatchResult(battingSecond.getName());
        }
        else {
            System.out.println("Match drawn");
        }
    }

}
