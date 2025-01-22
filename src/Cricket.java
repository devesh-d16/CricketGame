public class Cricket{

    static int[] score = {0, 1, 2, 3, 4, 6, -1};
    Team battingFirst;
    Team battingSecond;
    int overs;
    boolean allout;
    boolean outscored;
    private final UI ui;

    public Cricket(int overs, Team battingFirst, Team battingSecond, UI ui) {
        this.allout = false;
        this.outscored = false;
        this.overs = overs;
        this.battingFirst = battingFirst;
        this.battingSecond = battingSecond;
        this.ui = ui;
    }

    int simulateScore(){
        return score[(int) (Math.random() * 7)];
    }

    int play(Team team, int targetRun){
        int i = 1;
        while(i <= overs && !outscored && !allout){
            int j = 1;
            while(j++ <= 6 && !outscored && !allout){

                // simulate run through random function
                int run = simulateScore();

                // To show run per ball
                ui.displayRunByBall(run);

                if(run == -1){
                    allout = team.addWicket(allout);
                }
                else{
                    outscored = team.addScore(run, targetRun);
                }
            }
            ui.displayOvers(i);
            ui.displayAllOutOrOutscored(allout, outscored);
            ui.displayLine();
            i++;
        }
        ui.displayTeamScore(team);
        allout = false;
        outscored = false;
        return team.getScore();
    }

    void game(){

        int score1 = play(battingFirst, -1);
        ui.displayInningsEndMessage();
        int score2 = play(battingSecond, score1);

        if(score1 > score2){
            ui.displayMatchResult(battingFirst.getName());
        } else if (score1 < score2) {
            ui.displayMatchResult(battingSecond.getName());
        }
        else {
            System.out.println("Match drawn");
        }
    }
}
