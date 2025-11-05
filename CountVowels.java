import java.io.File; // For reading from files
import java.io.FileWriter; // For writing to output file
import java.io.IOException; // For handling file errors
import java.util.Scanner; // For reading input easily
import java.util.ArrayList; // For storing words in a list

/**
 * This program reads words from input.txt,
 * counts the vowels in each word,
 * and writes the results to output.txt
 * while also showing them in the terminal.
 *
 * If a word contains digits, it counts as 0 vowels.
 */
public final class NumVowels {

    private NumVowels() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This function counts the vowels in a word.
     * @param word The word to count vowels in.
     * @return The number of vowels in the word.
     * If the word contains digits, returns 0.
     */
    public static int numVowels(final String word) {
        // Check if the word has any numbers
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                return 0; // If it has a number, 0 vowels
            }
        }

        // Convert word to lowercase so 'A' and 'a' are the same
        word = word.toLowerCase();

        int count = 0; // start counting vowels

        // Go through each letter in the word
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++; // if it's a vowel, add 1
            }
        }
        return count; // return the total
    }

    /**
     * Main program: reads from input.txt, counts vowels, and writes output.
     * @param args Unused.
     */
    public static void main(final String[] args) {
        ArrayList<String> words = new ArrayList<>(); // to store words from file

        try {
            File inputFile = new File("input.txt"); // open input file
            Scanner reader = new Scanner(inputFile); // read file

            // read all words into ArrayList
            while (reader.hasNext()) {
                words.add(reader.next());
            }
            reader.close(); // close file after reading

            // create output file
            FileWriter writer = new FileWriter("output.txt");

            System.out.println("Word : Vowel Count"); // print header
            writer.write("Word : Vowel Count\n");

            // go through each word and count vowels
            for (String word : words) {
                int count = numVowels(word); // call function
                System.out.println(word + " : " + count);
                writer.write(word + " : " + count + "\n"); // write to file
            }

            writer.close(); // close writer
            // show that output is saved
            System.out.println("\nResults saved to output.txt!");

        } catch (IOException e) {
            // show error if file missing
            System.out.println("Error: " + e.getMessage());
        }
    }
}
