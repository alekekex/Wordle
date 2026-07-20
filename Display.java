import java.util.ArrayList;
import java.util.List;

public class Display {
    public static final List<Letter> WORD_HISTORY = new ArrayList<>();

    public static void displayMenu() {
        System.out.println("""
                ┌─────────────────────────┐
                │         WORDLE          │
                ├─────────────────────────┤
                │  1. Play Game           │
                │  2. Exit Program        │
                └─────────────────────────┘""");
    }

    public static void displayGrid(List<Letter> guessedLetters) {
        String topBorder    = "┌───┬───┬───┬───┬───┐";
        String middleBorder = "├───┼───┼───┼───┼───┤";
        String bottomBorder = "└───┴───┴───┴───┴───┘";
        WORD_HISTORY.addAll(guessedLetters);
        System.out.println(topBorder);

        for(int i = 0; i < 6; i++) {
            System.out.print("│");

            for(int j = 0; j < 5; j++) {
                int idx = (i * 5) + j;

                if(idx < WORD_HISTORY.size()) {
                    Letter l = WORD_HISTORY.get(idx);
                    System.out.print(" " + l.getColoredLetter() + " │");
                }
                else System.out.print("   │");
            }

            System.out.println();

            if(i < 5)
                System.out.println(middleBorder);
            else System.out.println(bottomBorder);
        }
    }

    public static void resetGrid() {
        WORD_HISTORY.clear();
    }

    public static void displayExitMessage() {
        System.out.println("""
                ┌─────────────────────────┐
                │   Thanks for playing!   │
                │       Goodbye!          │
                └─────────────────────────┘""");
    }
}
