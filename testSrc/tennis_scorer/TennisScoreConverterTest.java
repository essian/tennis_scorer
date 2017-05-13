package tennis_scorer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Essian on 13/05/2017.
 */
class TennisScoreConverterTest {

    private TennisScoreConverter converter;
    private HashMap<Player, String> expected;
    private TennisGame game;

    @BeforeEach
    public void setup() {
    converter = new TennisScoreConverter();
    expected = new HashMap<>();
    game = new TennisGame();
    }


    @Test
    void testAdvantageA() {
        game.setScoreA(4);
        game.setScoreB(3);
        expected.put(Player.A, "A");
        expected.put(Player.B, "40");
        assertEquals(expected, converter.convertScores(game));
    }

    @Test
    void testAdvantageB() {
        game.setScoreA(6);
        game.setScoreB(7);
        expected.put(Player.A, "40");
        expected.put(Player.B, "A");
        assertEquals(expected, converter.convertScores(game));
    }

    @Test
    void testDeuce() {
        game.setScoreA(6);
        game.setScoreB(6);
        expected.put(Player.A, "40");
        expected.put(Player.B, "40");
        assertEquals(expected, converter.convertScores(game));
    }

    @Test
    void highScores() {
        game.setScoreA(50);
        game.setScoreB(50);
        expected.put(Player.A, "40");
        expected.put(Player.B, "40");
        assertEquals(expected, converter.convertScores(game));
    }


    @Test
    void testNilNil() {
        game.setScoreA(0);
        game.setScoreB(0);
        expected.put(Player.A, "0");
        expected.put(Player.B, "0");
        assertEquals(expected, converter.convertScores(game));
    }


    @Test
    void gameAlreadyOver() {
        try {
            game.setScoreA(4);
            game.setScoreB(0);
            converter.convertScores(game);
            fail("No error generated");
        } catch (IllegalArgumentException expectedException) {

        }
    }

    @Test
    void negativeScores() {
        try {
            game.setScoreA(-4);
            game.setScoreB(0);
            converter.convertScores(game);
            fail("No error generated");
        } catch (IllegalArgumentException expectedException) {

        }
    }
}