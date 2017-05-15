package tennis_scorer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Essian on 13/05/2017.
 */
class TennisGameTest {

    private String expected;
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
    void nilScoresReturnEmptyString() {

        try {
            scoreA.set(game, 0);
            scoreB.set(game, 0);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        expected = "";
        assertEquals(expected, game.toString(Player.A));
    }

    @Test
    void numericScoresReturnCorrectly() {
        try {
            scoreA.set(game, 1);
            scoreB.set(game, 1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }        expected = "15-15 ";
        assertEquals(expected, game.toString(Player.A));
    }

    @Test
    void alphaScoresReturnCorrectly() {
        expected = "A-40 ";
        try {
            scoreA.set(game, 4);
            scoreB.set(game, 3);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        assertEquals(expected, game.toString(Player.A));
    }

    @Test
    void serverScoreIsFirst() {
        expected = "40-A ";
        try {
            scoreA.set(game, 4);
            scoreB.set(game, 3);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        assertEquals(expected, game.toString(Player.B));

        expected = "A-40 ";
        try {
            scoreA.set(game, 4);
            scoreB.set(game, 3);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        assertEquals(expected, game.toString(Player.A));
    }
}