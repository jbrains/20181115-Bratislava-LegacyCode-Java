package ca.jbrains.trivia.test;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Assert;
import org.junit.Test;

public class RollDiceTest {
    @Test
    public void happyPath() throws Exception {
        class InspectableGame extends Game {
            public InspectableGame() {
                add("::irrelevant player name::");
                putPlayerInPlace(0, 0);
            }

            // REFACTOR Move to some kind of SetupGame module
            public void putPlayerInPlace(int playerIndex, int place) {
                places[playerIndex] = place;
            }

            public int placeForPlayer(int playerIndex) {
                return places[playerIndex];
            }

            // REFACTOR I wouldn't need this if I could inspect a Turn.
            private int indexOfLastPlayerWhoPlayed() {
                return 0;
            }
        }

        InspectableGame game = new InspectableGame();
        game.roll(3);
        Assert.assertEquals(3, game.placeForPlayer(game.indexOfLastPlayerWhoPlayed()));
    }
}
