package tennis_scorer;

/**
 * Created by Essian on 09/05/2017.
 */
public class TennisSet extends WinnableRound {

    public TennisSet(int threshold, int lead) {
        super(threshold, lead);
    }

    @Override
    public boolean someoneWon() {
        int highestScore = Math.max(getScoreA(), getScoreB());
        int lowestScore = Math.min(getScoreA(), getScoreB());
        return (highestScore >=getThreshold()  && highestScore >= lowestScore + getLead());
    }

    public String toString(Player server) {
        return serverFirstFormat(server, String.valueOf(getScoreA()), String.valueOf(getScoreB()));
    }
}
