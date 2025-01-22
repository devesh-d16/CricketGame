import java.util.List;

public class Team {
    private int score;
    private int wicket;
    private final String name;
    private List<Player> players;

    public Team(String name){
        score = 0;
        wicket = 0;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

//    public void addScore(int runs) {
//        this.score += runs;
//    }

    public boolean addScore(int runs, int targetRun) {
        this.score += runs;
        return targetRun != -1 && this.score > targetRun;
    }

    public int getWicket() {
        return wicket;
    }

    public boolean addWicket(boolean allout) {
        if(this.wicket < 10){
            this.wicket++;
        }
        else {
            allout = true;
        }
        return allout;
    }

    public String getName() {
        return name;
    }
}
