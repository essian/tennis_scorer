package tennis_scorer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Essian on 09/05/2017.
 */
public class TennisGame extends WinnableRound {

    private TennisScoreConverter converter;


    public TennisGame(){
        super(4);
        converter = new TennisScoreConverter();
    }

    @Override
    public String toString(Player server) {
        if (zeroScores()) {
            return "";
        }
        HashMap<Player, String> normalisedScores = converter.convertScores(this);
        return serverFirstFormat(server, normalisedScores.get(Player.A), normalisedScores.get(Player.B));
    }

    private boolean zeroScores() {
        return getScoreA() == 0 && getScoreB() == 0;
    }

}
