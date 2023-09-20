package com.emir.learning.kotlin

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class BlackJackGameTest {

    @ParameterizedTest
    @CsvSource("DA, 11", "DK, 10", "S2, 2")
    fun `Get card score should return expected values`(card: String, expectedScore: Int) {
        val cardScore = getCardScore(card)
        assertEquals(expectedScore, cardScore)
    }

    @Test
    fun testPlayersHandScore() {
        val player = Player("TestEmirPlayer")
        val deck = mutableListOf("S3", "D7", "HA")
        player.draw(deck, numCards = 3)
        assertEquals(player.handScore, 21)
    }

    @Test
    fun testPlayerWithHighestScore() {
        val sam = Player("sam")
        val dealer = Player("dealer")

        sam.draw(mutableListOf("S2", "D7"), numCards = 2)
        dealer.draw(mutableListOf("DA", "H10"), numCards = 2)

        val highestScorePlayer: Player = getPlayerWithHighestScore(listOf(sam, dealer))
        assertEquals(highestScorePlayer, dealer)

    }

}