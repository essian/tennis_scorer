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

    public void increment(String player) {
        if (player.equals("A")){
            this.scoreA++;
        }
        if (player.equals("B")) {
            this.scoreB++;
        }
    }

    public String serverFirstFormat(String server, String scoreA, String scoreB) {
        if (server.equals("A")) {
            return String.format("%s-%s ", scoreA, scoreB);
        } else {
            return String.format("%s-%s ", scoreB, scoreA);
        }
    }

    public abstract boolean someoneWon ();

    public abstract String toString(String server);




}
