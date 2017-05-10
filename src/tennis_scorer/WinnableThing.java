package tennis_scorer;

import java.util.Random;

/**
 * Created by Essian on 09/05/2017.
 */
public abstract class WinnableThing {

    private int scoreA;
    private int scoreB;

    public WinnableThing() {
        scoreA = 0;
        scoreB = 0;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public void increment(String player) {
        if (player.equals("A")){
            this.scoreA++;
        }
        if (player.equals("B")) {
            this.scoreB++;
        }

    }



    public boolean someoneWon () {

        int highestScore = Math.max(scoreA, scoreB);
        int lowestScore = Math.min(scoreA, scoreB);
        return (highestScore > 3 && lowestScore < 3 ||
                lowestScore > 3 && highestScore > lowestScore + 1);
    }


    public abstract String toString();


}
