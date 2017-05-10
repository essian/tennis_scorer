package tennis_scorer;

/**
 * Created by Essian on 09/05/2017.
 */
public class TennisMatch {

    private final ScoreBoard scoreBoard;
    private Player player;

    public TennisMatch() {
        scoreBoard = new ScoreBoard();
    }

    public void parsePointWinners(String line) {
        String[] gameWinners = line.split("");
        for (String gameWinner : gameWinners) {
            try {
                player = Player.valueOf(gameWinner);
                scoreBoard.incrementMatch(player);
            } catch (Exception e) {
                continue;
//                could raise exception here if required
            }

        }
    }

    public String getScoreBoard() {
        return scoreBoard.toString();
    }
}
