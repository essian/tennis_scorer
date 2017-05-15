package tennis_scorer;

/**
 * Created by Essian on 09/05/2017.
 */
public abstract class WinnableRound {

    private int scoreA;
    private int scoreB;

    private final int threshold;
    private final int lead;

    public WinnableRound(int threshold) {
        scoreA = 0;
        scoreB = 0;
        this.threshold = threshold;
        this.lead = 2;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public int getThreshold() {
        return threshold;
    }

    public int getLead() {
        return lead;
    }

    public void increment(Player player) {
        switch (player) {
            case A:
                scoreA++;
                break;
            case B:
                scoreB++;
                break;
            default:
                throw new IllegalArgumentException("Invalid player");
        }
    }

    public String serverFirstFormat(Player server, String scoreA, String scoreB) {
        String formattedString;
        switch (server) {
            case A:
                formattedString = String.format("%s-%s ", scoreA, scoreB);
                break;
            case B:
                formattedString = String.format("%s-%s ", scoreB, scoreA);
                break;
            default:
                throw new IllegalArgumentException("Invalid player");
        }
        return formattedString;
    }

    public boolean someoneWon () {
        int highestScore = Math.max(scoreA, scoreB);
        int lowestScore = Math.min(scoreA, scoreB);
        return highestScore >= getThreshold() && highestScore >= lowestScore + lead;
    }

    public abstract String toString(Player server);

}
