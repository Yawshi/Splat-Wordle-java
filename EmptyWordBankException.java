package wordle;

/**
 * Custom checked exception, thrown when {@code WordBank} runs out of words to use. Error message is 
 * always "Word bank ran out of words. Rerun the code to reset."
 * @see WordBank
 */
class EmptyWordBankException extends Exception {

    /**
     * Custom checked exception, thrown when {@code WordBank} runs out of words to use. Error message 
     * is always "Word bank ran out of words. Rerun the code to reset."
     * @see WordBank
     */
    EmptyWordBankException() {
        super("Word bank ran out of words. Rerun the code to reset.");
    }
}
