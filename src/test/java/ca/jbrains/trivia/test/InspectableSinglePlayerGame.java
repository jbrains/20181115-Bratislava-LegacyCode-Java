package ca.jbrains.trivia.test;

import com.adaptionsoft.games.uglytrivia.Game;

public class InspectableSinglePlayerGame extends Game {
    public InspectableSinglePlayerGame(int startingPlace) {
        add("::irrelevant player name::");
        putPlayerInPlace(indexOfTheOnlyPlayer(), startingPlace);
    }

    // REFACTOR Move to some kind of SetupGame module
    public void putPlayerInPlace(int playerIndex, int place) {
        places[playerIndex] = place;
    }

    public int placeForPlayer(int playerIndex) {
        return places[playerIndex];
    }

    // REFACTOR I wouldn't need this if I could inspect a Turn.
    public int indexOfLastPlayerWhoPlayed() {
        return indexOfTheOnlyPlayer();
    }

    private int indexOfTheOnlyPlayer() {
        return 0;
    }
}
