package wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 */
class WordBank {
    private ArrayList<String> wordLength4 = new ArrayList<String>();
    private ArrayList<String> wordLength5 = new ArrayList<String>();
    private ArrayList<String> wordLength6 = new ArrayList<String>();
    private HashMap<String,String> wordExplanation = new HashMap<String,String>();
    
    /**
     * Constructor for {@code WordBank} object. Scans the file {@code bank} and adds each word 
     * found to their respective lists. <p>
     * Each word comes with its explanation - some flavour text shown to the player at the end of
     * each game. For example: <p>
     * > SPLAT : You SPLAT opponent by dealing enough damage to them with your weapon. <p>
     * The files may be editted freely, though each word and its explanation must take up one line 
     * each and: <p>
     * > - the word must be of the proper word length (4, 5 or 6) <p>
     * > - the word must precede its explanation, and the two must be separated by " : " <p>
     * Lines that do not follow this format are ignored. <p>
     * Throws {@code FileNotFoundException} if the file {@code bank} cannot be found, though 
     * this should not happen if all files are downloaded properly.
     * @throws FileNotFoundException if the file(s) cannot be found (likely not downloaded properly)
     */
    WordBank() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("src/wordle/bank"))) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" : ");
                if (line.length == 2) {
                    switch (line[0].length()) {
                        case 4:
                            wordLength4.add(line[0].toUpperCase());
                            wordExplanation.put(line[0].toUpperCase(), line[1]);
                            break;
                        case 5:
                            wordLength5.add(line[0].toUpperCase());
                            wordExplanation.put(line[0].toUpperCase(), line[1]);
                            break;
                        case 6:
                            wordLength6.add(line[0].toUpperCase());
                            wordExplanation.put(line[0].toUpperCase(), line[1]);
                            break;
                    }
                }
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
        }
        return ""; // unreachable, this is only to "ensure" return type is String
    }

    String getExplanation(String solution) {
        return wordExplanation.get(solution);
    }
}
