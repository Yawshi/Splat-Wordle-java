package wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Word bank for Wordle game solutions. Stores words from files length4, length5 and length6 (in 
 * /bank) into respective lists with constructor {@code WordBank()} and randomly returns one with 
 * methods {@code getLength4()}, {@code getLength5()}, {@code getLength6()} or {@code getAny()}.
 */
class WordBank {
    ArrayList<String> wordLength4 = new ArrayList<String>();
    ArrayList<String> wordLength5 = new ArrayList<String>();
    ArrayList<String> wordLength6 = new ArrayList<String>();
    
    /**
     * Constructor for {@code WordBank} object. Scans the files length4, length5 and length6 (in 
     * /bank) and adds each word found to their respective lists. <p>
     * The files may be editted freely, though each word must take up one line and be of the 
     * proper word length. Capitalisation does not matter since the method converts all words to 
     * upper case (or ALL CAPS) before adding them to the internal lists. <p>
     * Throws {@code FileNotFoundException} if length4, length5 or length6 cannot be found, though 
     * this should not happen if all files are downloaded properly.
     * @throws FileNotFoundException if the file(s) cannot be found (likely not downloaded properly)
     */
    WordBank() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("src/wordle/bank/length4"))) {
            while (sc.hasNextLine()) {
                wordLength4.add(sc.nextLine().toUpperCase());
            }
        }
        try (Scanner sc = new Scanner(new File("src/wordle/bank/length5"))) {
            while (sc.hasNextLine()) {
                wordLength5.add(sc.nextLine().toUpperCase());
            }
        }
        try (Scanner sc = new Scanner(new File("src/wordle/bank/length6"))) {
            while (sc.hasNextLine()) {
                wordLength6.add(sc.nextLine().toUpperCase());
            }
        }
    }

    /**
     * Selects and returns a random word in the list of length 4 words, then removes it from the 
     * list. Throws {@code EmptyWordBankException} instead if the list is empty.
     * @return a random word selected (and then removed) in the list of length 4 words
     * @throws EmptyWordBankException if the list is empty
     */
    String getLength4() throws EmptyWordBankException {
        if (wordLength4.size() == 0) throw new EmptyWordBankException();
        return wordLength4.remove((int) Math.floor(Math.random() * wordLength4.size()));
    }

    /**
     * Selects and returns a random word in the list of length 5 words, then removes it from the 
     * list. Throws {@code EmptyWordBankException} instead if the list is empty.
     * @return a random word selected (and then removed) in the list of length 5 words
     * @throws EmptyWordBankException if the list is empty
     */  
    String getLength5() throws EmptyWordBankException {
        if (wordLength5.size() == 0) throw new EmptyWordBankException();
        return wordLength5.remove((int) Math.floor(Math.random() * wordLength5.size()));
    }

    /**
     * Selects and returns a random word in the list of length 6 words, then removes it from the 
     * list. Throws {@code EmptyWordBankException} instead if the list is empty.
     * @return a random word selected (and then removed) in the list of length 6 words
     * @throws EmptyWordBankException if the list is empty
     */
    String getLength6() throws EmptyWordBankException {
        if (wordLength6.size() == 0) throw new EmptyWordBankException();
        return wordLength6.remove((int) Math.floor(Math.random() * wordLength6.size()));
    }

    /**
     * Selects a word length randomly between 4-6, then returns and removes a random word from the
     * corresponding list. Throws {@code EmptyWordBankException} instead if the selected list is 
     * empty. <p>
     * Note: this selects a random list then calls its corresponding method, so there is an equal
     * likelyhood for each list to be selected, regardless of how many words are in each list. 
     * It is also possible for any one list to be exhausted and become empty before others do, and
     * thus causing an {@code EmptyWordBankException} while other lists are not empty.
     * @return a random word selected (and then removed) from a random list
     * @throws EmptyWordBankException if the randomly selected list is empty
     */
    String getAny() throws EmptyWordBankException {
        int i = (int) Math.floor(Math.random() * 3) + 4;
        switch (i) {
            case 4:
                return getLength4();
            case 5: 
                return getLength5();
            case 6:
                return getLength6();
            default:
                return "";  // unreachable, this is only to "ensure" return type is String
        }

    }
}
