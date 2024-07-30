package wordle;
import java.util.Scanner;

public class Keyboard {

    public static String getInput(String msg) {
        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        System.out.print(msg);
        String input = keyboard.next();
        return input;
    }
}
