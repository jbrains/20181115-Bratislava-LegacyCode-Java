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
        0             | 6    || 6
        3             | 6    || 9
        8             | 3    || 11
        11            | 1    || 0
        11            | 6    || 5
    }

    def "the board is not quite circular"() {
        def game = new SilentAndInspectableSinglePlayerGame(startingPlace)

        expect:
        game.roll(roll)
        game.placeForPlayer(game.indexOfLastPlayerWhoPlayed()) == endingPlace

        // These tests will fail once we "fix" moving around the
        // board to use % 12 in place of subtracting 12.
        where:
        startingPlace | roll || endingPlace
        0             | 24   || 12
        0             | 25   || 13
        13            | 39   || 40
    }
}
