import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hangman {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner inputDevice = new Scanner(System.in);
        String word;
        List<Character> guesses = new ArrayList<>();
        int wrongGuesses = 0;
        Scanner scanner = new Scanner(new File("C:/Users/User/Hangman/src/Word_list.txt"));
        ArrayList<String> words = new ArrayList<String>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        Random rand = new Random();
        word = words.get(rand.nextInt(words.size()));

        //System.out.println(word);
        while(true) {
            displayHangedMan(wrongGuesses);
            if (wrongGuesses >= 6) {
                System.out.println("You lose!");
                System.out.println("The word was: " + word);
            }
            currentWord(word, guesses);
            if (!getPlayerGuess(inputDevice, word, guesses)) {
                System.out.println("Guessed letters: " + guesses);
                wrongGuesses++;
            }
            if(currentWord(word, guesses)) {
                System.out.println("\nYou win!");
            }
        }
    }

    private static void displayHangedMan(int wrongCount) {
        System.out.println("========");
        System.out.println(" | ");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }
        if (wrongCount >= 2) {
            System.out.print("/");
            if (wrongCount >= 3) {
                System.out.println(" \\");
            }
            else {
                System.out.println("");
            }
        }
        if (wrongCount >= 4) {
            System.out.println(" |");
        }
        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println(" \\");
            }
            else {
                System.out.println("");
            }
        }
        System.out.println("");
    }
    private static boolean currentWord(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println("");
        return (word.length() == correctCount);
    }
    private static boolean getPlayerGuess(Scanner inputDevice, String word, List<Character> playerGuesses) {
        System.out.println("Please enter a letter:");
        String letterGuess = inputDevice.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
        return word.contains(letterGuess);
    }

}