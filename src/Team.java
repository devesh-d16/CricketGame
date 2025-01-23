import java.util.ArrayList;
import java.util.List;

public class Team {
    private int score;
    private int wicket;
    private final String name;
    private final List<Player> players;

    public Team(String name){
        score = 0;
        wicket = 0;
        this.name = name;
        this.players = new ArrayList<>();
    }

//    NOT IMPLEMENTED YET
    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayers(Player player) {
        if(players.size() < 11){
            players.add(player);
        }
        else{
            System.out.println("11 players are already in the team");
        }
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
