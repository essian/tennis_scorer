package tennis_scorer;

import java.util.*;

/**
 * Created by Essian on 09/05/2017.
 */
public class ScoreBoard {

    private final List<WinnableRound> scoreBoard;
    private TennisSet currentSet;
    private TennisGame currentGame;
    private String server;

    public ScoreBoard() {
        scoreBoard = new ArrayList<>();
        currentSet = new TennisSet();
        currentGame = new TennisGame();
        scoreBoard.add(currentSet);
        scoreBoard.add(currentGame);
        server = "A";
    }

    public void incrementMatch(String winner) {
        currentGame.increment(winner);
        if (currentGame.someoneWon()) {
            switchServer();
            scoreBoard.remove(currentGame);
            updateSets(winner);
            startNewGame();
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (WinnableRound thing : scoreBoard) {
            result.append(thing.toString(server));
        }
        return result.toString();
    }

    private void startNewGame() {
        currentGame = new TennisGame();
        scoreBoard.add(currentGame);
    }

    private void updateSets(String winner) {
        currentSet.increment(winner);
        if (currentSet.someoneWon()) {
            currentSet = new TennisSet();
            scoreBoard.add(currentSet);
        }
    }

    private void switchServer() {
        server = server.equals("A") ? "B" : "A";
    }

}
