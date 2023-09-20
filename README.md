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
I have a solution for this

   
