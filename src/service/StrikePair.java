package service;

import model.Player;

public class StrikePair {
    public Player playerOnStrike;
    public Player playerOffStrike;
    private int nextBat;

    public int getNextBatsman() {
        return nextBat;
    }

    public void nextBatsman() {
        this.nextBat++;
    }

    public StrikePair(Player playerOnStrike, Player playerOffStrike){
        this.playerOnStrike = playerOnStrike;
        this.playerOffStrike = playerOffStrike;
        this.nextBat = 2;
    }
}
