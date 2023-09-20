# black-jack-game
Hello 👋! I've created a simpe black jack game using Kotlin. It's been tested with IntelliJ and can be run directly there. Also, I've used gradle as the build tool, however, I need more knowledge to fully understand how `gradle` works 😉. Google and chatGPT have helped me extensively to set up a build which works. 

## Main files
There are two main files created for this purpose, namely: 
1. Actual black jack code: [src/main/kotlin/Main.kt](src/main/kotlin/Main.kt)
2. Couple of unit tests: [src/test/kotlin/BlackJackGameTest.kt](src/test/kotlin/BlackJackGameTest.kt)

## Build and run the code
(I've done this only with IntelliJ)
1. Clone the repository from github
2. Build the `jar` file: `./gradlew build`
3. Run code from command line:
```shell
java -jar build/libs/black-jack-game-1.0.0.jar
Dealer
Sam: [D8, D2, S5, SK], 25
Dealer: [C3, H6], 9
```


## :x: Did not complete
I have not had time to:
1. Currently the code creates a shuffled card deck using a random seed number between 1 and 100. But, the result will always be the same if the seed number is constant.

## Other remarks
- As for code repetition, it seems like the handling of drawing a card and checking if the score is over 21 could be refactored into a separate method as this logic is similar for both Sam and the dealer. 

- It seems like this concern might be due to two while loops both being used for card drawing for players with slightly different conditions (Sam draws until their hand is less than 17 and Dealer draws until their hand is less than Sam's or they have already lost). 

- These could potentially be merged into the Player class as an additional method to avoid this repetition and improve readibility of the main method. 

- Also, it may be good to add some print statements inside the while loops to see progression of the game when executed. 

- And finally, the code is missing exceptions, so whenever an undesired outcome happens (like running out of cards in the Deck), the program will just crash instead of making an interupt notifying about the problem. Simply add some checks before executing linked methods and throw exceptions whenever the checks fail. 

   
