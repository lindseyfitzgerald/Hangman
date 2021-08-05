import java.util.Random;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class hangman {

    public static int gameStatus(String word, ArrayList<Character> guesses, Scanner inputDevice, int wrongCount){
        //Check wrong count. Determine win or lose
        //Display guessed letters
        while(true) {
            displayHangman(wrongCount);
            if (wrongCount >= 6) {
                System.out.println("\nYou lose");
                System.out.println("The word was: " + word);
                break;
            }
            currentWord(word, guesses);
            if (!getPlayerGuess(inputDevice, word, guesses)) {
                System.out.println("\nGuessed letters: " + guesses);
                wrongCount++;
            }
            if(currentWord(word, guesses)) {
                System.out.println("\nYou win!");
                break;
            }
        }
        return(wrongCount);
    }

    public static boolean getPlayerGuess(Scanner inputDevice, String word, ArrayList<Character> guesses) {
        //Get user guess
        System.out.print("Please enter a letter: ");
        String letterGuess = inputDevice.next();
        guesses.add(letterGuess.charAt(0));
        return word.contains(letterGuess);
    }
    public static boolean currentWord(String word, ArrayList<Character> guesses) {
        //Check word for player guess, display letter if found. If not display dash
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (guesses.contains(word.charAt(i))) {
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

    static void displayHangman(int wrongCount) {
        //Display hangman
        System.out.println("=====");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }
        if (wrongCount >= 2) {
            System.out.print("/");}
        if (wrongCount >= 3) {
            System.out.println(" \\");
        }
        else {
            System.out.println("");
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }
        if (wrongCount >= 5) {
            System.out.print("/ ");}
        if (wrongCount >= 6) {
            System.out.println("\\");
        }
        else {
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws FileNotFoundException {
        String word;
        ArrayList<Character> guesses = new ArrayList<>();
        int wrongCount = 0;
        ArrayList<String> words = new ArrayList<>();

        Scanner inputDevice = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("C:/Users/User/Hangman/src/Word_list.txt"));
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        Random rand = new Random();
        String choice = "y";

        while (choice.equals("y")) {
            word = words.get(rand.nextInt(words.size()));
            //System.out.println(word);
            gameStatus(word, guesses, inputDevice, wrongCount);

            System.out.print("\nWould you like to play again? (y/n): ");
            choice = inputDevice.next();
            guesses.clear();
        }
        System.out.println("Bye!");
    }}