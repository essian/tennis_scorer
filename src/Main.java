import tennis_scorer.TennisMatch;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by Essian on 09/05/2017.
 */
public class Main {
    public static void main(String ...args) throws Exception {

        //        File inFile = new File(args[0]);
        //        File outFile = new File(args[1]);


        File inFile = new File("input.txt");
        File outFile = new File("output.txt");

        Scanner reader = new Scanner(inFile);
        FileWriter writer = new FileWriter(outFile);


        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            TennisMatch tennisMatch = new TennisMatch();
            tennisMatch.parsePointWinners(line);
            String result = tennisMatch.getScoreBoard();
            writer.write(result + "\n");
            System.out.println(result);

        }
        writer.close();
    }

}
