package tennis_scorer;

/**
 * Created by Essian on 09/05/2017.
 */
public class TennisSet extends WinnableRound {

    public TennisSet() {
        super(6, 2);
    }

    public String toString(Player server) {
        return serverFirstFormat(server, String.valueOf(getScoreA()), String.valueOf(getScoreB()));
    }
}
