package tennis_scorer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Essian on 09/05/2017.
 */
public class TennisGame extends WinnableThing {

    private Map<Integer, String> pointsList = new HashMap<Integer, String>();

    public TennisGame(){
        super();
        pointsList.put(0, "0");
        pointsList.put(1, "15");
        pointsList.put(2, "30");
        pointsList.put(3, "40");
        pointsList.put(4, "A");
        pointsList.put(5, "out of range");

    }


    @Override
    public String toString() {
        int scoreA = getScoreA();
        int scoreB = getScoreB();
        if (scoreA > 3 && scoreA == scoreB) {
            scoreA = 3;
            scoreB = 3;
        }
        if (scoreA > 3 && scoreB > 3) {
            if (scoreA > scoreB) {
                scoreA = 4;
                scoreB = 3;
            } else {
                scoreA = 3;
                scoreB = 4;
            }
        }
        return String.format("%s-%s ", pointsList.get(scoreA), pointsList.get(scoreB) );
    }
}
