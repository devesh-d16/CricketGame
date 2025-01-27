package model;

public class Player {
    private final String name;
    int runsScored;
    int wicketsTaken;
    int ballsFaced;
    private final Designation designation;

    public Player(String name, Designation designation) {
        this.name = name;
        this.runsScored = 0;
        this.wicketsTaken = 0;
        this.ballsFaced = 0;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void addRuns(int runs) {
        this.runsScored += runs;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void addBallsFaced() {
        this.ballsFaced++;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void addWicketsTaken() {
        this.wicketsTaken++;
    }

    public Designation getDesignation() {
        return designation;
    }


}
