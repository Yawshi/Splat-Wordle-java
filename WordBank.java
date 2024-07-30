package wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordBank {
    ArrayList<String> wordLength4 = new ArrayList<String>(89);
    ArrayList<String> wordLength5 = new ArrayList<String>(123);
    ArrayList<String> wordLength6 = new ArrayList<String>(76);
    
    public WordBank() throws FileNotFoundException {
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

    public String getLength4() {
        return wordLength4.remove((int) Math.floor(Math.random() * wordLength4.size()));
    }

    public String getLength5() {
        return wordLength5.remove((int) Math.floor(Math.random() * wordLength5.size()));
    }

    public String getLength6() {
        return wordLength6.remove((int) Math.floor(Math.random() * wordLength6.size()));
    }

    public String getAny() {
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
