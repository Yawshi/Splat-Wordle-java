package wordle;
import java.util.Scanner;

/**
 * Utility for receiving inputs from the terminal, using the static method {@code getInput()}. <p>
 * Code example: {@code String input = Keyboard.getInput("Enter a message. ")} 
 */
public class Keyboard {

    /**
     * Prints the message included, then reads and returns the string on inputs until the next line.
     * @param msg the message included
     * @return string of inputs until the next line
     */
    public static String getInput(String msg) {
        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        System.out.print(msg);
        String input = keyboard.next();
        return input;
    }
}
