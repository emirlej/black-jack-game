# black-jack-game
Hello 👋! I've created a simpe black jack game using Kotlin. It's been tested with IntelliJ and run directly there. Also, I've used gradle as the build tool, however, I need more knowledge to fully understand how this works 😉. 

## Main files
There are two main files created for this purpose, namely: 
1. Actual black jack code: [src/main/kotlin/Main.kt](src/main/kotlin/Main.kt)
2. Couple of unit tests: [src/test/kotlin/BlackJackGameTest.kt](src/test/kotlin/BlackJackGameTest.kt)

Both can be run from inside IntelliJ. When the black jack code (1) is run, the program spits the dealer vs sam game and prints the result looking like:
```shell
# Run Main.kt in IntelliJ
# Output is:
Dealer
Sam: [S6, H9, S3], 18
Dealer: [DA, SQ], 21
```

## Did not complete
I have not had time to:
1. compile the `JAR` file correctly and run it from the terminal.
2. Currently the code creates a shuffled card deck using a random seed number between 1 and 100. But, the result will always be the same if the seed number is constant. 

   
