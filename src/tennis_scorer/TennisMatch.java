package tennis_scorer;

/**
 * Created by Essian on 09/05/2017.
 */
public class TennisMatch {

    private final ScoreBoard scoreBoard;

    public TennisMatch() {
        scoreBoard = new ScoreBoard();
    }

    public void parsePointWinners(String line) {
        String[] gameWinners = line.split("");
        for (String gameWinner : gameWinners) {
            incrementScoreboard(gameWinner);
        }
    }

    private void incrementScoreboard(String gameWinner) {
        try {
            Player player = Player.valueOf(gameWinner);
            scoreBoard.increment(player);
        } catch (Exception e) {
            if (!gameWinner.equals("")) { //empty input should be permitted and should output nil-nil set
                throw new IllegalArgumentException("Invalid player in input " + gameWinner);
            }
        }
    }

    public String getScoreBoard() {
        return scoreBoard.toString();
    }
}
