package tennis_scorer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Essian on 09/05/2017.
 */
public class TennisGame extends WinnableRound {

    private static final Map<Integer, String> pointsList = new HashMap<>();
    static {
        pointsList.put(0, "0");
        pointsList.put(1, "15");
        pointsList.put(2, "30");
        pointsList.put(3, "40");
        pointsList.put(4, "A");
    }
    private int normalScoreA;
    private int normalScoreB;

    public TennisGame(){
        super(3, 2);
    }

    @Override
    public boolean someoneWon() {
        int highestScore = Math.max(getScoreA(), getScoreB());
        int lowestScore = Math.min(getScoreA(), getScoreB());
        return highestScore > getThreshold() && highestScore >= lowestScore + getLead();
    }


    @Override
    public String toString(Player server) {
        if (zeroScores()) {
            return "";
        }
        normaliseScores();
        return serverFirstFormat(server, getScoreString(normalScoreA), getScoreString(normalScoreB));

    }

    private void normaliseScores() {
        normalScoreA = getScoreA();
        normalScoreB = getScoreB();
        if (deuce()) {
            normalScoreA = getThreshold();
            normalScoreB = getThreshold();
        }
        if (advantageA()) {
            normalScoreA = getThreshold() + 1;
            normalScoreB = getThreshold();
        }
        if (advantageB()) {
            normalScoreA = getThreshold();
            normalScoreB = getThreshold() + 1;
        }
    }

    private String getScoreString(int score) {
        String scoreString = pointsList.get(score);
        if (scoreString == null) {
            throw new IllegalArgumentException("Score: " + score);
        }
        return scoreString;
    }

    private boolean advantageA() {
        return getScoreA() >= getThreshold() && getScoreB() >= getThreshold() && getScoreA() > getScoreB();
    }

    private boolean advantageB() {
        return getScoreA() >= getThreshold() && getScoreB() >= getThreshold() && getScoreB() > getScoreA();
    }

    private boolean zeroScores() {
        return getScoreA() == 0 && getScoreB() == 0;
    }

    private boolean deuce() {
        return getScoreA() >= getThreshold() && getScoreA() == getScoreB();
    }

}
