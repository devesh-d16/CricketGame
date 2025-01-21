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
        for(int i = 1; i <= overs; i++){
            for(int j = 1; j <= 6; j++){
                int run = simulateScore();
                System.out.print(run + " ");
                if(run == -1){
                    team.addWicket();
                    if(team.getWicket() == 10){
                        allout = true;
                        break;
                    }
                }
                else{
                    team.addScore(run);
                    if(targetRun != -1 && team.getScore() > targetRun){
                        outscored = true;
                        break;
                    }
                }
            }
            System.out.println();
            if(outscored){
                System.out.println("outscored");
                break;
            }
            else if(allout){
                System.out.println("All out");
                break;
            }
            else{
                ui.displayOvers(i);
            }
        }
        ui.displayTeamScore(team);
        allout = false;
        outscored = false;
        return team.getScore();
    }

    void game(){

        int score1 = play(battingFirst, -1);
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
