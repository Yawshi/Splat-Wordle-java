package wordle;

import java.io.FileNotFoundException;

public class GameMaster {
    static int length = 5;
    static int guessMax;
    static boolean isMixedLength = false;
    static boolean isBlind = false;
    static boolean exit = false;

    public static void gameMaster() throws FileNotFoundException {

        while (!exit) {
            System.out.println();
            System.out.println("----- SPLATOON WORDLE -----");
            System.out.println();

            System.out.println("Current game settings:");
            if (isMixedLength) {
                System.out.println("Word length: mixed!");
                guessMax = 7;
            } else {
                System.out.println("Word length: " + length);
                guessMax = 6;
            }
            if (isBlind) {
                System.out.println("Clue system: blind!");
                guessMax += 4;
            } else {
                System.out.println("Clue system: normal");
            }
            System.out.println("Guesses allowed: " + guessMax);
            System.out.println();

            System.out.println("What would you like to do?");
            System.out.println("Enter 1 to start the game!");
            System.out.println("Enter 2 to configure game");
            switch (Keyboard.getInput("Enter anything else to exit: ")) {
                case "1": 
                    startGame();
                    continue;
                case "2":
                    configureGame();
                    continue;
                default:
                    System.out.println("Goodbye!");
                    exit = true;
                    return;
            }
        }
    }

    public static void startGame() throws FileNotFoundException {
        WordBank wordBank = new WordBank();
        if (isBlind) {
            // Blind Game unimplemented yet
        } else {
            if (isMixedLength) {
                new BasicGame(wordBank.getAny(), guessMax, isMixedLength);
            } else {
                switch (length) {
                    case 4: 
                        new BasicGame(wordBank.getLength4(), guessMax, isMixedLength);
                        break;
                    case 5: 
                        new BasicGame(wordBank.getLength5(), guessMax, isMixedLength);
                        break;
                    case 6: 
                        new BasicGame(wordBank.getLength6(), guessMax, isMixedLength);
                        break;
                }
            }
        }
    }

    public static void configureGame() {
        System.out.println();
        System.out.println("Word length can be between 4 to 6, or mixed! Playing with a mixed "
                            + "length allows guesses of length 4-6, and a clue will be given on "
                            + "if you have the correct length.");
        System.out.println("Clue system can be blind instead! You will only be told how many "
                            + "you got in correct letter and position, and how many in "
                            + "correct letter but incorrect position. Extra hard!");
        System.out.println("The number of guesses allowed will change accordingly.");

        while (!exit) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("Enter 4, 5, 6, or mixed to change the word length");
            System.out.println("Enter 1 or 0 to turn on or off blind mode");
            switch (Keyboard.getInput("Enter anything else to go back: ")) {
                case "4":
                    length = 4;
                    isMixedLength = false;
                    System.out.println("Word length changed to 4!");
                    break;
                case "5":
                    length = 5;
                    isMixedLength = false;
                    System.out.println("Word length changed to 5!");
                    break;
                case "6":
                    length = 6;
                    isMixedLength = false;
                    System.out.println("Word length changed to 6!");
                    break;
                case "mixed":
                    isMixedLength = true;
                    System.out.println("Word length changed to mixed!");
                    break;
                case "1":
                    isBlind = true;
                    System.out.println("Clue system is now blind!");
                    break;
                case "0":
                    isBlind = false;
                    System.out.println("Clue system is now normal!");
                    break;
                default:
                    return;
            }
        }
    }
}
