package tennis_scorer;

/**
 * Created by Essian on 09/05/2017.
 */
public abstract class WinnableRound {

    private int scoreA;
    private int scoreB;

    public WinnableRound() {
        scoreA = 0;
        scoreB = 0;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
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

    public abstract boolean someoneWon ();

    public abstract String toString(Player server);




}
