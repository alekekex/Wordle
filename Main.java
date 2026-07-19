import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
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
            System.out.println("Could not locate file! Please try again.");
        } catch(IOException e) {
            System.out.println("Could not read file! Please try again.");
        }

        while(isRunning) {
            System.out.println("Welcome to Wordle!");
            System.out.println("1. Play Game");
            System.out.println("2. Exit Program");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    Wordle game = new Wordle(words);
                    game.playGame(sc);
                    break;
                case 2:
                    System.out.println("Closing the program. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
