package tennis_scorer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Essian on 13/05/2017.
 */
public class TennisScoreConverter {

    private int scoreA;
    private int scoreB;
    private int threshold;
    private int lead;
    private WinnableRound game;

    private static final Map<Integer, String> pointsList = new HashMap<>();
    static {
        pointsList.put(0, "0");
        pointsList.put(1, "15");
        pointsList.put(2, "30");
        pointsList.put(3, "40");
        pointsList.put(4, "A");
    }


    public HashMap<Player,String> convertScores(WinnableRound game) {
        this.scoreA = game.getScoreA();
        this.scoreB = game.getScoreB();
        this.threshold = game.getThreshold();
        this.lead = game.getLead();
        this.game = game;
        ensureValidScores();
        if (bothScoresReachedThreshold()) {
            normaliseScores();
        }
        HashMap<Player, String> normalisedScores = new HashMap<>();
        normalisedScores.put(Player.A, getScoreString(this.scoreA));
        normalisedScores.put(Player.B, getScoreString(this.scoreB));
        return normalisedScores;
    }

    private void ensureValidScores() {
        if (scoreA < 0 || scoreB < 0) {
            throw new IllegalArgumentException("Only positive scores can be converted");
        }
        if (this.game.someoneWon()) {
            throw new IllegalArgumentException("Game is already completed when scores are " + scoreA + " " + scoreB);
        }

    }

    private void normaliseScores() {

        if (deuce()) {
            scoreA = threshold - 1;
            scoreB = threshold - 1;
        }
        if (advantageA()) {
            scoreA = threshold;
            scoreB = threshold - 1;
        }
        if (advantageB()) {
            scoreA = threshold - 1;
            scoreB = threshold;
        }
    }

    private String getScoreString(int score) {
        String scoreString = pointsList.get(score);
        if (scoreString == null) {
            throw new IllegalArgumentException("Score: " + score);
        }
        return scoreString;
    }


    private boolean bothScoresReachedThreshold() {
        return scoreA >= threshold && scoreB >= threshold;
    }

    private boolean advantageA() {
        return scoreA > scoreB;
    }

    private boolean advantageB() {
        return scoreB > scoreA;
    }

    private boolean deuce() {
        return scoreA == scoreB;
    }


}


