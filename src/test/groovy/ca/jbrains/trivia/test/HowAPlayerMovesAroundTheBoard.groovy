package ca.jbrains.trivia.test

import spock.lang.Specification

class HowAPlayerMovesAroundTheBoard extends Specification {
    def "the board is circular"() {
        def game = new SilentAndInspectableSinglePlayerGame(startingPlace)

        expect:
        game.roll(roll)
        game.placeForPlayer(game.indexOfLastPlayerWhoPlayed()) == endingPlace

        where:
        startingPlace | roll || endingPlace
        0             | 3    || 3
    }
}
