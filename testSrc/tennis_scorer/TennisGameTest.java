package tennis_scorer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Essian on 13/05/2017.
 */
class TennisGameTest {

    private TennisGame game;
    private String expected;

    @BeforeEach
    public void setup() {
        game = new TennisGame();
    }

    @Test
    void nilScoresReturnEmptyString() {
        expected = "";
        assertEquals(expected, game.toString(Player.A));
    }

    @Test
    void numericScoresReturnCorrectly() {
        expected = "15-15 ";
        game.setScoreA(1);
        game.setScoreB(1);
        assertEquals(expected, game.toString(Player.A));
    }

    @Test
    void alphaScoresReturnCorrectly() {
        expected = "A-40 ";
        game.setScoreA(4);
        game.setScoreB(3);
        assertEquals(expected, game.toString(Player.A));
    }

    @Test
    void serverScoreIsFirst() {
        expected = "40-A ";
        game.setScoreA(4);
        game.setScoreB(3);
        assertEquals(expected, game.toString(Player.B));

        expected = "A-40 ";
        game.setScoreA(4);
        game.setScoreB(3);
        assertEquals(expected, game.toString(Player.A));
    }
}