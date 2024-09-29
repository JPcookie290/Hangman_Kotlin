class Model(private val wordToGuess: String, private val maxAttempts: Int) {
    private var guessedLetters = mutableSetOf<Char>()
    private var attemptsLeft = maxAttempts

    // Returns the word
    fun getDisplayWord(): String {
        return wordToGuess.map { if (it in guessedLetters) it else '_' }.joinToString(" ")
    }

    // Checks the word
    fun guessLetter(letter: Char): Boolean {
        if (letter in guessedLetters) return false
        guessedLetters.add(letter)

        return if (letter in wordToGuess) {
            true
        } else {
            attemptsLeft--
            false
        }
    }

    // Check game over
    fun isGameOver(): Boolean {
        return attemptsLeft <= 0 || wordToGuess.all { it in guessedLetters }
    }

    // Check won
    fun hasWon(): Boolean {
        return wordToGuess.all { it in guessedLetters }
    }

    fun getAttemptsLeft(): Int {
        return attemptsLeft
    }
}
