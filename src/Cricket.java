public class Cricket{

    static int[] score = {0, 1, 2, 3, 4, 6, -1};
    Team battingFirst;
    Team battingSecond;
    int totalOvers;
    private final UI ui;

    public Cricket(int totalOvers, Team battingFirst, Team battingSecond, UI ui) {
        this.totalOvers = totalOvers;
        this.battingFirst = battingFirst;
        this.battingSecond = battingSecond;
        this.ui = ui;
    }

    int play(Team team, int targetRun) throws InterruptedException {
        for(int overNo = 1; overNo <= totalOvers && (gameEnd(team, targetRun)); overNo++){
            playOver(team, targetRun, overNo);
        }
        ui.displayTeamScore(team);
        return team.getScore();
    }

    int simulateScore(){
        return score[(int) (Math.random() * 7)];
    }

    boolean gameEnd(Team batting, int targetRun){
        return batting.getWicket() != 10 && (targetRun == -1 || batting.getScore() <= targetRun);
    }

    void playOver(Team batting, int targetRun, int overNo) throws InterruptedException {
        for(int ball = 1; (ball <= 6) && (gameEnd(batting, targetRun)); ball++){
            int run = simulateScore();
            if(run == -1) {
                batting.addWicket();
            }
            else {
                batting.addScore(run);
            }
            ui.displayRunByBall(run);
        }
        Thread.sleep(1000);
        ui.displayOvers(overNo);
    }

    void game() throws InterruptedException {
        int score1 = play(battingFirst, -1);
        ui.displayInningsEndMessage();
        int score2 = play(battingSecond, score1);
        result(score1, score2);
    }

    void result(int score1, int score2){
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
