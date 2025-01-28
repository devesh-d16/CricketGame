package model;

import java.util.*;

public class Team {
    private int score;
    private int wicket;
    private final String name;
    private final List<Player> players;

    public Team(String name, List<Player> players) {
        score = 0;
        wicket = 0;
        this.name = name;
        this.players = new ArrayList<>(players);
    }

    //    NOT IMPLEMENTED YET
    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayers(Player player) {
        players.add(player);
    }

    public int getScore() {
        return score;
    }

    public void addScore(int runs) {
        this.score += runs;
    }

    public int getWicket() {
        return wicket;
    }

    public void addWicket() {
        if(this.wicket < 10){
            this.wicket++;
        }
    }

    public String getName() {
        return name;
    }
}
