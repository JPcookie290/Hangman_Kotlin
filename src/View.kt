class View {

    // Visual fo the Hangman
    private val hangmanStages = arrayOf(
        """
           +---+
           |   |
               |
               |
               |
               |
         =========
        """,
        """
           +---+
           |   |
           O   |
               |
               |
               |
         =========
        """,
        """
           +---+
           |   |
           O   |
           |   |
               |
               |
         =========
        """,
        """
           +---+
           |   |
           O   |
          /|   |
               |
               |
         =========
        """,
        """
           +---+
           |   |
           O   |
          /|\  |
               |
               |
         =========
        """,
        """
           +---+
           |   |
           O   |
          /|\  |
          /    |
               |
         =========
        """,
        """
           +---+
           |   |
           O   |
          /|\  |
          / \  |
               |
         =========
        """
    )

    // Display hangman
    fun displayHangman(attemptsLeft: Int) {
        val stageIndex = 6 - attemptsLeft
        println(hangmanStages[stageIndex])
    }

    fun displayGameState(wordToGuess: String, attemptsLeft: Int) {
        println("Word to guess: $wordToGuess")
        println("Attempts left: $attemptsLeft")
    }

    // Input
    fun promptGuess(): Char {
        print("Enter your guess: ")
        val input = readlnOrNull()
        return input?.firstOrNull() ?: ' '
    }

    // Display message
    fun displayEndMessage(hasWon: Boolean, wordToGuess: String) {
        if (hasWon) {
            println("Congratulations! You've guessed the word!")
        } else {
            println("Game Over! The word was: $wordToGuess")
        }
    }

    fun promptPlayAgain(): Boolean {
        print("Do you want to play again? (y/n): ")
        val response = readlnOrNull()?.lowercase()
        return response == "y"
    }
}
