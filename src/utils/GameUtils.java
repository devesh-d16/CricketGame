package utils;
import config.GameConfig;

public class GameUtils {

    public int getRandomScore() {
        return GameConfig.SCORING_OPTIONS[(int)(Math.random() * GameConfig.SCORING_OPTIONS.length)];
    }

}
