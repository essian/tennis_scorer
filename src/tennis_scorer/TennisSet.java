package tennis_scorer;

/**
 * Created by Essian on 09/05/2017.
 */
public class TennisSet extends WinnableThing {

    public TennisSet() {
        super();
    }

    public String toString() {
        return String.format("%d-%d ", getScoreA(), getScoreB());
    }


}
