import java.util.Random;

public class Main {

    // Custom shuffle function
    public static void customShuffle(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Custom function to convert Roman numerals to integers
    public static int romanToInteger(String roman) {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentSymbol = roman.charAt(i);
            int currentValue = 0;

            switch (currentSymbol) {
                case 'I':
                    currentValue = 1;
                    break;
                case 'V':
                    currentValue = 5;
                    break;
                case 'X':
                    currentValue = 10;
                    break;
                case 'L':
                    currentValue = 50;
                    break;
                case 'C':
                    currentValue = 100;
                    break;
                case 'D':
                    currentValue = 500;
                    break;
                case 'M':
                    currentValue = 1000;
                    break;
            }

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }

    // Custom function to check for a pangram
    public static boolean isPangram(String sentence) {
        boolean[] alphabetPresent = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            char ch = Character.toLowerCase(sentence.charAt(i));
            if ('a' <= ch && ch <= 'z') {
                alphabetPresent[ch - 'a'] = true;
            }
        }

        for (boolean present : alphabetPresent) {
            if (!present) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // A. Shuffle an array
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        customShuffle(array);
        System.out.print("Shuffled Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // B. Convert Roman numeral to an integer
        String romanNumeral = "XXX";
        int integerEquivalent = romanToInteger(romanNumeral);
        System.out.println("Roman Numeral " + romanNumeral + " is equivalent to " + integerEquivalent);

        // C. Check if the input is a pangram
        String pangramSentence = "The quick brown fox jumps over the lazy dog";
        boolean isPangram = isPangram(pangramSentence);
        System.out.println("Is it a Pangram? " + isPangram);
    }
}
