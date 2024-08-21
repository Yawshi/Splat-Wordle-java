package wordle;

/**
 * Represents a clue given in a Wordle game. The clue is generated upon declaration of the object
 * with the constructor {@code Clue()}, and can be obtained by these methods: <p>
     * > - {@code isExactMatch()} returns whether the guess exactly matches the solution, thus 
     * winning the game. <p>
     * > - {@code isCorrectLength()} returns whether the guess has the same length as the solution.
     * This is always true when the mixed length rule is not in play (since a guess otherwise is
     * invalid and would not be allowed to be made). <p>
     * > - {@code isCorrectChar()} returns an array of booleans (of size equal to the length of the 
     * guess), where for each letter in the guess, whether it is the correct letter and in the 
     * correct position. For example, if the guess is "SPILL" and the solution is "SPLAT", this 
     * returns {@code [true, true, false, false, false]} <p>
     * > - {@code hasChar()} returns an array of booleans (of size equal to the length of the guess),
     * where for each letter in the guess, whether it is the correct letter but not in the correct 
     * position. Note each letter in the solution can only contribute to one {@code true} clue for
     * each letter in the guess. For example, if the guess is "SPILL" and the solution is "SPLAT", 
     * this returns {@code [false, false, false, true, false]}
 */
class Clue {

    private boolean isExactMatch, isCorrectLength;
    private boolean[] isCorrectChar, hasChar;

    /**
     * Constructor for the {@code Clue} class. The clue is generated here, and can be obtained
     * by the other methods in the class: <p>
     * > - {@code isExactMatch()} returns whether the guess exactly matches the solution, thus 
     * winning the game. <p>
     * > - {@code isCorrectLength()} returns whether the guess has the same length as the solution.
     * This is always true when the mixed length rule is not in play (since a guess otherwise is
     * invalid and would not be allowed to be made). <p>
     * > - {@code isCorrectChar()} returns an array of booleans (of size equal to the length of the 
     * guess), where for each letter in the guess, whether it is the correct letter and in the 
     * correct position. For example, if the guess is "SPILL" and the solution is "SPLAT", this 
     * returns {@code [true, true, false, false, false]} <p>
     * > - {@code hasChar()} returns an array of booleans (of size equal to the length of the guess),
     * where for each letter in the guess, whether it is the correct letter but not in the correct 
     * position. Note each letter in the solution can only contribute to one {@code true} clue for
     * each letter in the guess. For example, if the guess is "SPILL" and the solution is "SPLAT", 
     * this returns {@code [false, false, false, true, false]}
     * @param guess the guess to generate the clue from
     * @param solution the solution of the game
     */
    Clue(String guess, String solution) {
        this.isExactMatch = (guess.equals(solution));
        this.isCorrectLength = (guess.length() == solution.length());

        isCorrectChar = new boolean[guess.length()];
        hasChar = new boolean[guess.length()];
        boolean[] isCharTaken = new boolean[solution.length()]; 

        for (int posGuess = 0; posGuess<guess.length() && posGuess<solution.length(); posGuess++) {
            isCorrectChar[posGuess] = (guess.charAt(posGuess) == solution.charAt(posGuess));
            isCharTaken[posGuess] = isCorrectChar[posGuess];
        }

        for (int posGuess = 0; posGuess < guess.length(); posGuess++) {
            if (!isCorrectChar[posGuess]) {
                for (int posSol = 0; posSol < solution.length(); posSol++) {
                    if (!hasChar[posGuess] && !isCharTaken[posSol]) {
                        hasChar[posGuess] = (guess.charAt(posGuess) == solution.charAt(posSol));
                        isCharTaken[posSol] = (guess.charAt(posGuess) == solution.charAt(posSol));
                    }
                }
            }
        }
    }

    /**
     * Returns whether the guess exactly matches the solution, thus winning the game.
     * @return whether the guess exactly matches the solution
     */
    boolean isExactMatch() {
        return this.isExactMatch;
    }

    /**
     * Returns whether the guess is of the same length as the solution. This is always true when
     * the mixed length rule is not in play.
     * @return whether the guess is of the same length as the solution
     */
    boolean isCorrectLength() {
        return this.isCorrectLength;
    }

    /**
     * Returns an array of booleans (of size equal to the length of the guess), where for each 
     * letter in the guess, whether it is the correct letter and in the correct position. For 
     * example, if the guess is "SPILL" and the solution is "SPLAT", this returns 
     * {@code [true, true, false, false, false]}
     * @return whether each letter in the guess is the correct letter and position
     */
    boolean[] isCorrectChar() {
        return this.isCorrectChar;
    }

    /**
     * Returns an array of booleans (of size equal to the length of the guess), where for each 
     * letter in the guess, whether it is the correct letter but not in the correct position. Note
     * each letter in the solution can only contribute to one {@code true} clue for each letter in 
     * the guess. For example, if the guess is "SPILL" and the solution is "SPLAT", this returns 
     * {@code [false, false, false, true, false]}
     * @return whether each letter in the guess is the correct letter but not the correct position
     */
    boolean[] hasChar() {
        return this.hasChar;
    }
}
