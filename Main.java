import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reader r = new Reader();
        List<String> words = new ArrayList<>();
        String filePath = "words.txt";
        boolean isRunning = true;

        try {
            words = r.readWords(filePath);
        } catch(FileNotFoundException e) {
            System.out.println("Could not locate file!");
            isRunning = false;
        } catch(IOException e) {
            System.out.println("Could not read file!");
            isRunning = false;
        }

        while(isRunning) {
            Display.displayMenu();
            int choice = getIntInput(sc, 1, 2);

            switch(choice) {
                case 1:
                    Wordle game = new Wordle(words);
                    game.playGame(sc);
                    break;
                case 2:
                    Display.displayExitMessage();
                    isRunning = false;
                    break;
            }
        }
    }

    public static int getIntInput(Scanner sc, int min, int max) {
        int n = -1;
        boolean isValid = false;

        do {
            try {
                System.out.print("Choose an option: ");
                n = sc.nextInt();
                sc.nextLine();

                if(max == -1) {
                    if (n < min)
                        System.out.println("Invalid option! Value must be at least " + min + ".");
                    else isValid = true;
                }
                else {
                    if(!(n >= min && n <= max))
                        System.out.println("Invalid option! Please enter a value between " +
                                min + " and " + max + ".");
                    else isValid = true;
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }
        } while(!isValid);

        return n;
    }
}
