
# Kotlin Hangman Game

## Overview

This is a simple command-line Hangman game built using Kotlin. The game challenges the player to guess a word by selecting one letter at a time. The player has 6 attempts to guess the word before losing. The game features different difficulty levels and an interactive user interface that displays the progress of the hangman drawing as the player guesses letters.

## Features

- Three difficulty levels:
  - Easy (5-letter words)
  - Medium (8-letter words)
  - Hard (12-letter words)
- A maximum of 6 attempts to guess the word correctly.
- Interactive hangman drawing that updates after every incorrect guess.
- Option to play again after each round.
- Player name input and personalized greeting.
- Display of game rules at the beginning of each game.

## Files

- **Controller.kt**: Manages the game flow, including starting the game, selecting the difficulty, and prompting for user input.
- **Model.kt**: Handles the game logic, including tracking the word to guess, the player's attempts, and whether the player has won or lost.
- **View.kt**: Responsible for displaying the game state to the player, including the hangman drawing and the current state of the guessed word.
- **Main.kt**: The entry point of the application, where the game is initialized and started.

## How to Run

1. Ensure you have [Kotlin](https://kotlinlang.org/docs/command-line.html) installed on your system.
2. Clone this repository or download the Kotlin source files.
3. Compile and run the project using the Kotlin command-line tools or your preferred IDE (like IntelliJ IDEA).

To compile the Kotlin files:

```bash
kotlinc Main.kt Model.kt View.kt Controller.kt -include-runtime -d hangman.jar
```

To run the compiled JAR:

```bash
java -jar hangman.jar
```

Alternatively, you can run the program directly through Kotlin:

```bash
kotlin MainKt
```

## Game Instructions

1. The game begins by prompting the player to enter their name.
2. The rules of Hangman are displayed to explain how the game works.
3. The player selects a difficulty level by entering:
   - `e` for easy (5-letter word)
   - `m` for medium (8-letter word)
   - `h` for hard (12-letter word)
4. The player then attempts to guess the word, letter by letter.
5. The hangman drawing progresses after each incorrect guess.
6. If the player successfully guesses the word within the allowed attempts, they win. Otherwise, they lose.
7. The player is then prompted to play again.
