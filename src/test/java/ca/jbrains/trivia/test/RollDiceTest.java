package ca.jbrains.trivia.test;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

public class RollDiceTest {
    @Test
    public void happyPath() throws Exception {
        Game game = new Game() {

        };

        game.roll(3);
    }
}
