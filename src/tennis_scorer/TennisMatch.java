package tennis_scorer;

/**
 * Created by Essian on 09/05/2017.
 */
public class TennisMatch {

    private ScoreBoard scoreBoard;

    public TennisMatch() {
        scoreBoard = new ScoreBoard();
    }

    public void parseGameWinners(String line) {
        String[] gameWinners = line.split("");
        for (String gameWinner : gameWinners) {
            scoreBoard.incrementMatch(gameWinner);
        }
    }

    public String getScoreBoard() {
        return scoreBoard.toString();
    }
}
