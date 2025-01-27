package service;

import controller.GameController;
import model.Player;
import model.Team;
import model.Toss;
import ui.UI;
import utils.GameUtils;


import java.util.List;

public class GameService {

//    private final Team team;
    private final UI ui;
//    private final Player player;
//    private final Toss toss;
    private final GameUtils utils;

    public GameService(UI ui, GameUtils utils) {
//        this.team = team;
        this.ui = ui;
//        this.player = player;
//        this.toss = toss;
        this.utils = utils;
    }

    private boolean gameEnd(Team batting, int targetRun){
        return (batting.getWicket() == 10 || (targetRun != -1 && batting.getScore() >= targetRun));
    }

    public int simulateInning(Team team, int targetRun, int overs){
        for(int overNo = 1; overNo <= overs && (!gameEnd(team, targetRun)); overNo++){
           simulateOver(team, targetRun, overNo);
        }
        return team.getScore();
    }

    public void simulateOver(Team batting, int targetRun, int overNo){
        int runThisOver = 0;
        for(int ball = 1; (ball <= 6) && (!gameEnd(batting, targetRun)); ball++){
            int run = utils.getRandomScore();

            if(run != -1) runThisOver += run;

            if(run == -1){
                batting.addWicket();
            }
            else{
                batting.addScore(run);
            }
            ui.displayRunByBall(run);
        }
        ui.displayOverStat(overNo, runThisOver);
    }

    public void simulateMatch(Team battingFirst, Team battingSecond, int overs){
        int scoreBatting = simulateInning(battingFirst, -1, overs);
        ui.displayInningsEndMessage();

        int scoreBattingSecond = simulateInning(battingSecond, scoreBatting, overs);
        ui.displayInningsEndMessage();

        result(battingFirst, battingSecond);
    }

    public void result(Team battingFirst, Team battingSecond){
        int score1 = battingFirst.getScore();
        int score2 = battingSecond.getScore();

        if(score1 > score2){
            ui.displayMatchResult(battingFirst.getName());
        }
        else if (score1 < score2) {
            ui.displayMatchResult(battingSecond.getName());
        }
        else {
            System.out.println("Match drawn");
        }
    }
}
