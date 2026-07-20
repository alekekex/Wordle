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

    public static void displayKeyboard(List<Letter> alphabet) {
        int[] row1 = {16, 22, 4, 17, 19, 24, 20, 8, 14, 15};
        int[] row2 = {0, 18, 3, 5, 6, 7, 9, 10, 11};
        int[] row3 = {25, 23, 2, 21, 1, 13, 12};
        System.out.println();
        System.out.print(" ");

        for(int i = 0; i < row1.length; i++) {
            if(i > 0)
                System.out.print(" | ");

            System.out.print(alphabet.get(row1[i]).getColoredLetter());
        }

        System.out.println();
        System.out.print("   ");

        for(int i = 0; i < row2.length; i++) {
            if(i > 0)
                System.out.print(" | ");

            System.out.print(alphabet.get(row2[i]).getColoredLetter());
        }

        System.out.println();
        System.out.print("     ");

        for(int i = 0; i < row3.length; i++) {
            if(i > 0)
                System.out.print(" | ");

            System.out.print(alphabet.get(row3[i]).getColoredLetter());
        }

        System.out.println("\n");
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
