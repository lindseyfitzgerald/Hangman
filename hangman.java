import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:/Users/User/Hangman/src/Word_list.txt"));
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()){
            words.add(scanner.nextLine());
        }
        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));

        System.out.println(word);

    }
}
