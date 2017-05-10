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
    public String toString(String server) {
        int scoreA = getScoreA();
        int scoreB = getScoreB();

        if (zeroScores()) {
            return "";
        }
        if (deuce()) {
            scoreA = 3;
            scoreB = 3;
        }
        if (advantageA()) {
            scoreA = 4;
            scoreB = 3;
        }
        if (advantageB()) {
            scoreA = 3;
            scoreB = 4;
        }
        return serverFirstFormat(server, pointsList.get(scoreA), pointsList.get(scoreB));
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
