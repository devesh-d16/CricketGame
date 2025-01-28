package service;

import config.GameConfig;
import controller.GameController;
import model.Designation;
import model.Player;
import model.Team;
import model.Toss;
import ui.UI;
import utils.GameUtils;


import java.util.List;

public class GameService {

    private final UI ui;
    private final GameUtils utils;

    public GameService(UI ui, GameUtils utils) {
        this.ui = ui;
        this.utils = utils;
    }


    public void rotateStrike(int run, StrikePair strikePair) {
        if (run == 1 || run == 3) {
            Player temp = strikePair.playerOnStrike;
            strikePair.playerOnStrike = strikePair.playerOffStrike;
            strikePair.playerOffStrike = temp;
        }
    }

    public void overDone(StrikePair strikePair) {
        Player temp = strikePair.playerOnStrike;
        strikePair.playerOnStrike = strikePair.playerOffStrike;
        strikePair.playerOffStrike = temp;
    }

    private boolean gameEnd(Team batting, int targetRun){
        return (batting.getWicket() == 10 || (targetRun != -1 && batting.getScore() > targetRun));
    }

    public void simulateOver(Team batting, int targetRun, int overNo, StrikePair strikePair){
        int runThisOver = 0;
        for(int ball = 1; (ball <= 6) && (!gameEnd(batting, targetRun)); ball++){
            int run = 0;
            if(strikePair.playerOnStrike.getDesignation() == Designation.BATTER){
                run = utils.getRandomBatterWeightScore(GameConfig.BATTER_WEIGHT);
            }
            else{
                run = utils.getRandomBowlerWeightScore(GameConfig.BOWLER_WEIGHT);
            }

            if(run != -1) runThisOver += run;

            if(run == -1){
                batting.addWicket();
                if(!gameEnd(batting, targetRun)){
                    strikePair.playerOnStrike = batting.getPlayers().get(strikePair.getNextBatsman());
                    strikePair.nextBatsman();
                }
            }
            else{
                strikePair.playerOnStrike.addRuns(run);
                batting.addScore(run);
            }
            strikePair.playerOnStrike.addBallsFaced();
            rotateStrike(run, strikePair);
            ui.displayRunByBall(run);
        }
        overDone(strikePair);

        ui.displayOverStat(overNo, runThisOver);
    }

    public int simulateInning(Team team, int targetRun, int overs){
        StrikePair strikePair = new StrikePair(team.getPlayers().get(0), team.getPlayers().get(1));

        for(int overNo = 1; overNo <= overs && (!gameEnd(team, targetRun)); overNo++){
            simulateOver(team, targetRun, overNo, strikePair);
        }

        return team.getScore();
    }

    public void simulateMatch(Team battingFirst, Team battingSecond, int overs){
        int scoreBatting = simulateInning(battingFirst, -1, overs);
        ui.printTeamStats(battingFirst);
        ui.displayInningsEndMessage(battingFirst);

        int scoreBattingSecond = simulateInning(battingSecond, scoreBatting, overs);
        ui.printTeamStats(battingSecond);
        ui.displayInningsEndMessage(battingSecond);

        result(battingFirst, battingSecond);
    }

    public void result(Team battingFirst, Team battingSecond){
        int score1 = battingFirst.getScore();
        int score2 = battingSecond.getScore();
        int won;

        if(score1 > score2){
            won = 0;
            ui.displayMatchResult(battingFirst, battingSecond, won);
        }
        else if (score1 < score2) {
            won = 1;
            ui.displayMatchResult(battingSecond, battingFirst, won);
        }
        else {
            System.out.println("Match drawn");
        }
    }
}
