package tennis_scorer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Essian on 13/05/2017.
 */
class TennisScoreConverterTest {

    TennisScoreConverter converter = new TennisScoreConverter();
    HashMap<Player, String> expected = new HashMap<>();
    int threshold = 4;
    int lead = 2;

//    @Test
//    void testAdvantageA() {
//        expected.put(Player.A, "A");
//        expected.put(Player.B, "40");
//        assertEquals(expected, converter.convertScores(4, 3, threshold, lead));
//    }
//
//    @Test
//    void testAdvantageB() {
//        expected.put(Player.A, "40");
//        expected.put(Player.B, "A");
//        assertEquals(expected, converter.convertScores(6, 7, threshold, lead));
//    }
//
//    @Test
//    void testDeuce() {
//        expected.put(Player.A, "40");
//        expected.put(Player.B, "40");
//        assertEquals(expected, converter.convertScores(4, 4, threshold, lead));
//    }
//
//    @Test
//    void highScores() {
//        expected.put(Player.A, "40");
//        expected.put(Player.B, "40");
//        assertEquals(expected, converter.convertScores(50, 50, threshold, lead));
//    }
//
//
//    @Test
//    void testNilNil() {
//        expected.put(Player.A, "0");
//        expected.put(Player.B, "0");
//        assertEquals(expected, converter.convertScores(0, 0, threshold, lead));
//    }
//
//
//    @Test
//    void gameAlreadyOver() {
//        try {
//            converter.convertScores(4, 0, threshold, lead);
//            fail("No error generated");
//        } catch (IllegalArgumentException expectedException) {
//
//        }
//    }
//
//    @Test
//    void negativeScores() {
//        try {
//            converter.convertScores(-4, 0, threshold, lead);
//            fail("No error generated");
//        } catch (IllegalArgumentException expectedException) {
//
//        }
//    }
}