package wordle;

public class EmptyWordBankException extends Exception {
    public EmptyWordBankException() {
        super("Word bank ran out of words. Rerun the code to reset.");
    }
}
