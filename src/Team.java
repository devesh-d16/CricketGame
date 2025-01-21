public class Team {
    private int score;
    private int wicket;
    private final String name;

    public Team(String name){
        score = 0;
        wicket = 0;
        this.name = name;
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
