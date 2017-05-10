import tennis_scorer.TennisMatch;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by Essian on 09/05/2017.
 */
public class Main {
    public static void main(String ...args) throws Exception {
        File file = new File("input.txt");
        Scanner reader = new Scanner(file);
        FileWriter writer = new FileWriter("output.txt");


        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            TennisMatch tennisMatch = new TennisMatch();
            tennisMatch.parseGameWinners(line);
            String result = tennisMatch.getScoreBoard();
            writer.write(result + "\n");
            System.out.println(result);

        }
        writer.close();
    }

}
