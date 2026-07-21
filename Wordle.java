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
        this.word = randomWord();//this.word = "CHOSE";
        this.letters = word.toCharArray();
        this.wrongGuesses = 0;
        this.isGameOver = false;
    }

    public void playGame(Scanner sc) {
        Display.resetGrid();

        while(!isGameOver) {
            String guess = readGuess(sc);
            List<Letter> guessedLetters = getLetters(guess);
            processGuess(guessedLetters);
            updateKeyboard(guessedLetters);
            Display.displayGrid(guessedLetters);
            Display.displayKeyboard(alphabet);

            if(guess.equals(word))
                isGameOver = true;
            else {
                wrongGuesses++;

                if(wrongGuesses >= 6)
                    isGameOver = true;
            }
        }

        if(isGameOver) {
            if(wrongGuesses < 6)
                System.out.println("Game Over! You guessed the word " + word + "!");
            else System.out.println("Game Over! The correct word is: " + word + ".");

            System.out.println();
        }
    }

    public List<Letter> getAlphabet() {
        List<Letter> alphabet = new ArrayList<>();
        char c = 'A';

        for(int i = 0; i < 26; i++) {
            Letter l = new Letter(c);
            alphabet.add(l);
            c++;
        }

        return alphabet;
    }

    public String randomWord() {
        Random rand = new Random();
        int idx = rand.nextInt(words.size());
        return words.get(idx).toUpperCase();
    }

    public List<Letter> getLetters(String guess) {
        List<Letter> letters = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            Letter l = new Letter(guess.charAt(i));
            letters.add(l);
        }

        return letters;
    }

    public String readGuess(Scanner sc) {
        boolean isRead = false;
        String guess;

        do {
            System.out.print("Guess the word: ");
            guess = sc.nextLine().toUpperCase();

            if(guess.length() != 5)
                System.out.println("Invalid input! Please enter a 5-letter word only.");
            else if(guess.matches(".*[^A-Z].*"))
                System.out.println("Invalid input! Please enter a word with letters from A-Z only.");
            else if(!isValidWord(guess))
                System.out.println("Word is not in list! Please enter a valid word.");
            else isRead = true;

        } while(!isRead);

        return guess;
    }

    public boolean isValidWord(String guess) {
        boolean isValid = false;

        for(int i = 0; i < words.size(); i++) {
            if(guess.equals(words.get(i).toUpperCase())) {
                isValid = true;
                i = words.size();
            }
        }

        return isValid;
    }

    public void processGuess(List<Letter> guessedLetters) {
        char[] temp = letters.clone();

        for(int i = 0; i < 5; i++) {
            if(guessedLetters.get(i).getLetter() == temp[i]) {
                guessedLetters.get(i).setColor("GREEN");
                temp[i] = '_';
            }
            else {
                for(int j = 0; j < 5; j++) {
                    if(guessedLetters.get(i).getLetter() == temp[j]) {
                        guessedLetters.get(i).setColor("YELLOW");
                        temp[j] = '_';
                        j = 5;
                    }
                    else guessedLetters.get(i).setColor("GRAY");
                }
            }
        }
    }

    public void updateKeyboard(List<Letter> guessedLetters) {
        for(int i = 0; i < 5; i++) {
            int idx = guessedLetters.get(i).getLetter() - 'A';

            if(guessedLetters.get(i).getColor().equals("GREEN"))
                alphabet.get(idx).setColor("GREEN");
            else if(guessedLetters.get(i).getColor().equals("YELLOW") &&
                    !("GREEN".equals(alphabet.get(idx).getColor())))
                alphabet.get(idx).setColor("YELLOW");
            else if(guessedLetters.get(i).getColor().equals("GRAY") &&
                    !("YELLOW".equals(alphabet.get(idx).getColor())) &&
                    !("GREEN".equals(alphabet.get(idx).getColor())))
                alphabet.get(idx).setColor("GRAY");
        }
    }
}
