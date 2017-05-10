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
        super();
    }

    @Override
    public boolean someoneWon() {
        int highestScore = Math.max(getScoreA(), getScoreB());
        int lowestScore = Math.min(getScoreA(), getScoreB());
        return ( standardSetWin(highestScore, lowestScore) ||
                 advantageSetWin(highestScore, lowestScore));
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
            normalScoreA = 3;
            normalScoreB = 3;
        }
        if (advantageA()) {
            normalScoreA = 4;
            normalScoreB = 3;
        }
        if (advantageB()) {
            normalScoreA = 3;
            normalScoreB = 4;
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
        return getScoreA() > 3 && getScoreB() > 3 && getScoreA() > getScoreB();
    }

    private boolean advantageB() {
        return getScoreA() > 3 && getScoreB() > 3 && getScoreB() > getScoreA();
    }

    private boolean zeroScores() {
        return getScoreA() == 0 && getScoreB() == 0;
    }

    private boolean deuce() {
        return getScoreA() > 3 && getScoreA() == getScoreB();
    }

    private boolean standardSetWin(int highestScore, int lowestScore) {
        return highestScore > 3 && lowestScore < 3;
    }

    private boolean advantageSetWin(int highestScore, int lowestScore) {
        return lowestScore > 3 && highestScore > lowestScore + 1;
    }
}
