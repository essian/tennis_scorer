package tennis_scorer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Essian on 13/05/2017.
 */
class TennisScoreConverterTest {

    private TennisScoreConverter converter = new TennisScoreConverter();
    private Map<Player, String> expected = new HashMap<>();
    private TennisGame game = new TennisGame();
    private Field scoreA;
    private Field scoreB;

    @BeforeEach
    public void setup() {
        try {
            scoreA = game.getClass().getSuperclass().getDeclaredField("scoreA");
            scoreA.setAccessible(true);
            scoreB = game.getClass().getSuperclass().getDeclaredField("scoreB");
            scoreB.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }



    @Test
    void testAdvantageA() {
        try {
            scoreA.set(game, 4);
            scoreB.set(game, 3);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        expected.put(Player.A, "A");
        expected.put(Player.B, "40");
        assertEquals(expected, converter.convertScores(game));
    }

    @Test
    void testAdvantageB() {
        try {
            scoreA.set(game, 6);
            scoreB.set(game, 7);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        expected.put(Player.A, "40");
        expected.put(Player.B, "A");
        assertEquals(expected, converter.convertScores(game));
    }

    @Test
    void testDeuce() throws IllegalAccessException {
        scoreA.set(game, 6);
        scoreB.set(game, 6);
        expected.put(Player.A, "40");
        expected.put(Player.B, "40");
        assertEquals(expected, converter.convertScores(game));
    }

    @Test
    void highScores() throws IllegalAccessException {
        scoreA.set(game, 50);
        scoreB.set(game, 50);
        expected.put(Player.A, "40");
        expected.put(Player.B, "40");
        assertEquals(expected, converter.convertScores(game));
    }


    @Test
    void testNilNil() throws IllegalAccessException {
        scoreA.set(game, 0);
        scoreB.set(game, 0);
        expected.put(Player.A, "0");
        expected.put(Player.B, "0");
        assertEquals(expected, converter.convertScores(game));
    }


    @Test
    void gameAlreadyOver() throws IllegalAccessException {
        try {
            scoreA.set(game, 4);
            scoreB.set(game, 0);
            converter.convertScores(game);
            fail("No error generated");
        } catch (IllegalArgumentException expectedException) {

        }
    }

    @Test
    void negativeScores() {
        try {
            scoreA.set(game, -4);
            scoreB.set(game, 0);
            converter.convertScores(game);
            fail("No error generated");
        } catch (IllegalArgumentException expectedException) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}