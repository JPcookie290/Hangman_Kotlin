import kotlin.random.Random

class Controller {
    private val view = View()
    private var playerName: String = ""
    private val maxAttempts = 6

    fun startGame() {
        askPlayerName()
        explainGameRules()

        var playAgain = true

        while (playAgain) {
            // Difficulty selection
            val wordToGuess = selectDifficulty()
            // For testing
            // println(wordToGuess)

            // Set up the game
            val game = Model(wordToGuess, maxAttempts)
            playGame(game)

            playAgain = view.promptPlayAgain()
        }

        println("Goodbye, $playerName! Thanks for playing!")
    }

    private fun askPlayerName() {
        print("Please enter your name: ")
        playerName = readlnOrNull() ?: "Player"
        println("Hello, $playerName! Welcome to Hangman!")
    }

    private fun explainGameRules() {
        println("""
            The rules of Hangman are simple:
            1. You need to guess the word letter by letter.
            2. You have a limited number of incorrect guesses (6 attempts).
            3. After each incorrect guess, the hangman drawing progresses.
            4. If you guess the word before running out of attempts, you win!
            5. If you fail to guess the word, you lose.
            Good luck!
        """)
    }

    // Select the difficulty
    private fun selectDifficulty(): String {
        println("Choose a difficulty, if none is chosen easy will be selected as default.")
        println("e for easy (5-letter words), m for medium (8-letter words), h for hard (12-letter words)")

        val difficulty = readlnOrNull()?.lowercase() ?: "e"

        val easyWords = listOf("apple", "brain", "cloud", "grape", "toast", "space", "flame")
        val mediumWords = listOf("elephant", "airplane", "building", "computer", "umbrella", "internet", "pandemic", "magazine")
        val hardWords = listOf("application", "programming", "revolutionary", "astonishment", "investigator", "conservation", "advertisement")

        val words = when (difficulty) {
            "m" -> mediumWords
            "h" -> hardWords
            else -> easyWords
        }

        return words[Random.nextInt(words.size)]
    }

    private fun playGame(game: Model) {
        while (!game.isGameOver()) {
            view.displayHangman(game.getAttemptsLeft())
            view.displayGameState(game.getDisplayWord(), game.getAttemptsLeft())
            val guess = view.promptGuess()

            game.guessLetter(guess)
        }

        view.displayHangman(game.getAttemptsLeft())
        view.displayEndMessage(game.hasWon(), game.getDisplayWord())
    }
}
