package utils;
import config.GameConfig;

import java.util.Random;

public class GameUtils {

    public int getRandomWeightScore(int[] weights) {

        int totalWeight = 0;
        for(int weight : weights) {
            totalWeight += weight;
        }

        Random random = new Random();
        int randomWeight = random.nextInt(totalWeight);

        int cumulativeWeight = 0;
        for(int i = 0; i < weights.length; i++) {
            cumulativeWeight += weights[i];
            if(cumulativeWeight >= randomWeight) {
                return GameConfig.SCORING_OPTIONS[i];
            }
        }
        return GameConfig.SCORING_OPTIONS[0];
    }

    public int getRandomBatterWeightScore(int[] weights) {
        return getRandomWeightScore(GameConfig.BATTER_WEIGHT);
    }

    public int getRandomBowlerWeightScore(int[] weights) {
        return getRandomWeightScore(GameConfig.BOWLER_WEIGHT);
    }
}
