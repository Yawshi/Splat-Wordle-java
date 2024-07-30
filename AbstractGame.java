package wordle;

/**
 * Represents an instance of a Wordle game. Parent of {@code BasicGame} and {@code BlindGame}
 * classes. <p>
 * Has the following methods: <p>
 * - {@code getSolution()} returns the solution of the game. <p>
 * - {@code getGuessCount()} returns the order number of the guess, starting from 1. <p>
 * - {@code incrementGuessCount()} increments the guess count (order number of the guess) by 1. <p>
 * - {@code getGuessMax()} returns the maximum number of guesses that can be made this game. <p>
 * - {@code isMixedLength()} returns whether or not the game plays with the mixed length rule. <p>
 * - {@code makeGuess()} prompts the player to enter a guess, then returning a {@code String} 
 * of the guess. <p>
 * - {@code isValidGuess()} checks and returns whether a guess is valid by the rules of the game.<p>
 * - {@code generateClue()} returns a {@code Clue} object for a guess. <p>
 * - {@code giveClue()} is {@code abstract} and prints (on the terminal) an interpretation 
 * of a {@code Clue} object based on the rules of the game. <p>
 * @see BasicGame
 * @see BlindGame
 * @see Clue
 */
public abstract class AbstractGame {
    String solution, guess;
    int guessCount = 1;
    int guessMax;
    boolean mixedLength;
    
    /**
     * Returns the solution of the game.
     * @return the solution of the game
     */
    String getSolution() {
        return this.solution;
    }

    /**
     * Returns the order number of the guess, starting from 1. For example the first guess is 1, 
     * and the fifth guess is 5.
     * @return the order number of the guess
     */
    int getGuessCount() {
        return this.guessCount;
    }

    /**
     * Increments the guess count (order number of the guess) by 1. Done after giving each clue.
     */
    void incrementGuessCount() {
        this.guessCount++;
    }

    /**
     * Returns the maximum number of guesses that can be made this game.
     * @return the max number of guesses this game
     */
    int getGuessMax() {
        return this.guessMax;
    }

    /**
     * Returns whether the game plays with the mixed length rule.
     * @return whether the game plays with the mixed length rule
     */
    boolean isMixedLength() {
        return this.mixedLength;
    }

    /**
     * Prompts the player to make a guess, then returns a {@code String} of the guess. 
     * @return the guess made
     */
    String makeGuess() {
        String guess = "";
        while (!isValidGuess(guess)) {
            guess = Keyboard.getInput("Enter your guess:                   ");
            if (!isValidGuess(guess)) {
                System.out.println("The guess is invalid.");
                System.out.println("Check if the input is of the correct length "
                                + "and of only alphabetical characters.");
            }
        }
        guess = guess.toUpperCase();
        return guess;
    }

    /**
     * Checks and returns whether the guess made is valid by the rules of the game. <p>
     * A guess is valid when all characters are alphabetical characters, and the guess is either 
     * the same length as the solution of the game or if it is between 4 and 6 if the game plays 
     * by the mixed length rule.
     * @param guess the guess made
     * @return whether the guess is valid
     */
    boolean isValidGuess(String guess) {
        if ((guess.length() == getSolution().length()) 
        || (isMixedLength() && (4 <= guess.length()) && (guess.length() <= 6))) {
            for (int i = 0; i < guess.length(); i++) {
                if (!('a' <= guess.charAt(i) && guess.charAt(i) <= 'z')
                && !('A' <= guess.charAt(i) && guess.charAt(i) <= 'Z')) {
                    return false;
                }
            }
            return true;
        } else return false;
    }

    /**
     * Returns a {@code Clue} object for a guess.
     * @param guess the guess made
     * @return the {@code Clue} object for the guess
     * @see Clue
     */
    Clue generateClue(String guess) {
        return new Clue(guess, getSolution());
    }

    /**
     * Abstract. Prints (on the terminal) an interpretation of a {@code Clue} object based on
     * the rules of the game.
     * @param clue the {@code Clue} object to be interpreted
     * @see BasicGame
     * @see BlindGame
     */
    abstract void giveClue(Clue clue);
}
