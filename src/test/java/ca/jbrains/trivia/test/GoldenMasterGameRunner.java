package ca.jbrains.trivia.test;

import com.adaptionsoft.games.uglytrivia.Game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


public class GoldenMasterGameRunner {

    private static boolean notAWinner;

    public static void main(String[] args) throws IOException {
        Path testOutputDirectory = Paths.get(".", "test", "data");
        Path testOutputFilePath = testOutputDirectory.resolve("game-1000.txt");
        Files.createDirectories(testOutputDirectory);
        File testOutputFile = testOutputFilePath.toFile();
        FileOutputStream canvas = new FileOutputStream(testOutputFile);
        System.setOut(new PrintStream(canvas));
        new GoldenMasterGameRunner().runGame(1000);
        canvas.flush();
        canvas.close();
    }

    public void runGame(int seed) {
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        Random rand = new Random(seed);

        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }


        } while (notAWinner);
    }
}
