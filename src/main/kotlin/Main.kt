import kotlin.random.Random

fun shuffleDeck(deck: MutableList<String>): MutableList<String> {
    val seedNumber = Random.nextInt(1, 101)
    //println(seedNumber)
    println(Random(seedNumber))
    deck.shuffle(Random(seedNumber))
    return deck
}

fun createCardDeck(): MutableList<String> {
    val suits = listOf("S", "H", "D", "C")
    val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    val deck = mutableListOf<String>()
    for (suit in suits) {
        for (rank in ranks) {
            deck.add("$suit$rank")
        }
    }
    return shuffleDeck(deck)
}

fun getCardScore(card: String): Int {
    val scores = mapOf("A" to 11, "J" to 10, "Q" to 10, "K" to 10)
    return scores[card[1].toString()] ?: card.substring(1).toInt()
}

class Player(name: String) {
    val name: String = name
    val hand: MutableList<String> = mutableListOf()
    var drawNumber: Int = 0
    var hasWon: Boolean = false

    fun draw(deck: MutableList<String>, numCards: Int = 1) {
        drawNumber++
        repeat(numCards) {
            hand.add(deck.removeAt(0))
        }
    }

    fun showHand() {
        println("${name}'s hand: $hand. Score: $handScore")
    }

    val handScore: Int
        get() {
            var score = 0
            for (card in hand) {
                score += getCardScore(card)
            }
            return score
        }
}

fun getPlayerWithHighestScore(players: List<Player>): Player {
    var highestScore = 0
    var playerWithHighestScore = players[0]

    for (player in players) {
        if (player.handScore > highestScore) {
            highestScore = player.handScore
            playerWithHighestScore = player
        }
    }
    return playerWithHighestScore
}

fun getResults(players: List<Player>) {
    if (players.all { !it.hasWon }) {
        val playerWithHighestScore = getPlayerWithHighestScore(players)
        println(playerWithHighestScore.name)
    } else {
        players.filter { it.hasWon }.forEach { println(it.name) }
    }
    players.forEach { println("${it.name}: ${it.hand}, ${it.handScore}") }
}

fun main() {
    // Initiate the players
    val sam = Player("Sam")
    val dealer = Player("Dealer")
    // Create the deck
    val deck = createCardDeck()

    // Start the game
    sam.draw(deck, 1)
    dealer.draw(deck, 1)
    sam.draw(deck, 1)
    dealer.draw(deck, 1)

    if (sam.handScore == 21 && sam.drawNumber == 1) {
        println("Sam has blackjack! Sam wins!")
        sam.hasWon = true
    } else if (dealer.handScore == 22 && dealer.drawNumber == 1) {
        println("Dealer has 22! Dealer wins!")
        dealer.hasWon = true
    } else {
        while (sam.handScore < 17) {
            sam.draw(deck)
            //sam.showHand()
            if (sam.handScore > 21) {
                println("Sam has busted! Dealer wins!")
                dealer.hasWon = true
                break
            }
        }
        while (dealer.handScore <= sam.handScore && !dealer.hasWon) {
            dealer.draw(deck)
            //dealer.showHand()
            if (dealer.handScore > 21) {
                println("Dealer has busted! Sam wins!")
                sam.hasWon = true
                break
            }
        }
    }

    getResults(listOf(sam, dealer))
}
