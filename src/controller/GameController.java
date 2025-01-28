package controller;

import config.GameConfig;
import model.Player;
import model.Team;
import model.Toss;
import service.GameService;
import ui.UI;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final UI ui;
    private final GameService gameService;


    public GameController( UI ui, GameService gameService){
        this.ui = ui;
        this.gameService = gameService;
    }

    public Team initializeTeam(UI ui){
        String teamName = ui.inputTeamName();
        List<Player> players = new ArrayList<>();
        for(int i = 1; i <= GameConfig.MAX_PLAYERS; i++){
            players.add(ui.inputPlayer(i));
        }
        return new Team(teamName, players);
    }

    public int inputOvers(UI ui){
        return ui.inputOvers();
    }

    public Team toss(UI ui, Team team1, Team team2){
        Toss toss = ui.inputToss();
        if(toss == Toss.HEADS){
            return team1;
        }
        return team2;
    }

    public void startGame() {
        Team team1 = initializeTeam(ui);
        Team team2 = initializeTeam(ui);

        int overs = inputOvers(ui);
        Team battingTeam = toss(ui, team1, team2);
        Team bowlingTeam = battingTeam == team1 ? team2 : team1;

        gameService.simulateMatch(battingTeam, bowlingTeam, overs);
    }

}
