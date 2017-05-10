package tennis_scorer;

import java.util.*;

/**
 * Created by Essian on 09/05/2017.
 */
public class ScoreBoard {

    private List<WinnableThing> scoreBoard;
    private TennisSet currentSet;
    private TennisGame currentGame;

    public ScoreBoard() {
        scoreBoard = new ArrayList<WinnableThing>();
        currentSet = new TennisSet();
        currentGame = new TennisGame();
        scoreBoard.add(currentSet);
        scoreBoard.add(currentGame);
    }

    public void incrementMatch(String winner) {

        currentGame.increment(winner);
        if (currentGame.someoneWon()) {
            currentSet.increment(winner);
            scoreBoard.remove(currentGame);
            if (currentSet.someoneWon()) {
                currentSet = new TennisSet();
                scoreBoard.add(currentSet);
            }
            currentGame = new TennisGame();
            scoreBoard.add(currentGame);
        }
    }

    public String toString() {
        String result = "";
        for (WinnableThing thing : scoreBoard) {
            result += thing.toString();
        }
        return result;
    }



}
