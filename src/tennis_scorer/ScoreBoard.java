package tennis_scorer;

import java.util.*;

/**
 * Created by Essian on 09/05/2017.
 */
public class ScoreBoard {

    private final List<WinnableRound> scoreBoard;
    private TennisSet currentSet;
    private TennisGame currentGame;
    private Player server;

    public ScoreBoard() {
        scoreBoard = new ArrayList<>();
        currentSet = new TennisSet(6, 2);
        currentGame = new TennisGame();
        scoreBoard.add(currentSet);
        scoreBoard.add(currentGame);
        server = Player.A;
    }


    public void incrementMatch(Player winner) {
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
        for (WinnableRound round : scoreBoard) {
            result.append(round.toString(server));
        }
        return result.toString();
    }

    private void startNewGame() {
        currentGame = new TennisGame();
        scoreBoard.add(currentGame);
    }

    private void updateSets(Player winner) {
        currentSet.increment(winner);
        if (currentSet.someoneWon()) {
            currentSet = new TennisSet(4, 2);
            scoreBoard.add(currentSet);
        }
    }

    private void switchServer() {
        server = server.equals(Player.A) ? Player.B : Player.A;
    }

}
