import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    private List<Character> alphabet;
    private List<String> words;
    private String word;
    private char[] letters;
    private boolean isGameOver;

    public Wordle(List<String> words) {
        this.alphabet = getAlphabet();
        this.words = words;
        this.word = randomWord();
        this.letters = word.toCharArray();
        this.isGameOver = false;
    }

    public void playGame(Scanner sc) {

    }

    public String randomWord() {
        Random rand = new Random();
        int idx = rand.nextInt(words.size());
        return words.get(idx).toUpperCase();
    }

    public List<Character> getAlphabet() {
        List<Character> letters = new ArrayList<>();
        char c = 'A';

        for(int i = 0; i < 26; i++) {
            letters.add(c);
            c++;
        }

        return letters;
    }

    public String readGuess(Scanner sc) {
        boolean isRead = false;
        String guess;

        do {
            System.out.print("Enter your word guess: ");
            guess = sc.nextLine().toUpperCase();

            if(guess.length() != 5)
                System.out.println("Invalid input! Please enter a 5-letter word only.");
            else if(guess.matches(".*[^A-Z].*"))
                System.out.println("Invalid input! Please enter a word with letters from A-Z only.");
            else isRead = true;

        } while(!isRead);

        return guess;
    }

    public void processGuess(String guess) {

    }

    public void changeLetterColor(char c, String color) {

    }
}
