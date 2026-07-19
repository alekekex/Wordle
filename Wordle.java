import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    private List<Letter> alphabet;
    private List<String> words;
    private String word;
    private char[] letters;
    private int wrongGuesses;
    private boolean isGameOver;

    public Wordle(List<String> words) {
        this.alphabet = getAlphabet();
        this.words = words;
        this.word = "CHICK";
        this.letters = word.toCharArray();
        this.wrongGuesses = 0;
        this.isGameOver = false;
    }

    public void playGame(Scanner sc) {
        while(!isGameOver) {
            String guess = readGuess(sc);

            if(guess.equals(word) || wrongGuesses >= 6)
                isGameOver = true;
            else {
                processGuess(guess);
                wrongGuesses++;
            }
        }

        if(isGameOver) {
            if(wrongGuesses >= 6)
                System.out.println("Game Over! The word is " + word + ".");
            else System.out.println("Game Over! You guessed the word " + word + "!");
        }
    }

    public String randomWord() {
        Random rand = new Random();
        int idx = rand.nextInt(words.size());
        return words.get(idx).toUpperCase();
    }

    public List<Letter> getAlphabet() {
        List<Letter> letters = new ArrayList<>();
        char c = 'A';

        for(int i = 0; i < 26; i++) {
            Letter l = new Letter(Character.toString(c));
            letters.add(l);
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
        char[] guessedLetters = guess.toCharArray();

        for(int i = 0; i < 5; i++) {
            if(guessedLetters[i] == letters[i]) {
                int idx = guessedLetters[i] - 'A';
                alphabet.get(idx).setColor("GREEN");
            }
            else {
                for(int j = 0; j < 5; j++) {
                    if(guessedLetters[j] == letters[i]) {
                        int idx = guessedLetters[j] - 'A';
                        alphabet.get(idx).setColor("YELLOW");
                    }
                    else {
                        int idx = guessedLetters[j] - 'A';
                        alphabet.get(idx).setColor("GRAY");
                    }
                }
            }
        }
    }

    public boolean checkIfGameOver(String guess) {
        boolean isOver = false;


        return isOver;
    }
}
