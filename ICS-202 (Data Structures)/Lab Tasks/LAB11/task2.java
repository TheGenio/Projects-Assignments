package LAB11;
import java.util.Scanner;


class task2{}



class BruteForceStringMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text string T: ");
        String text = scanner.nextLine();

        System.out.print("Enter a pattern string P: ");
        String pattern = scanner.nextLine();

        int occurrences = searchPattern(text, pattern);

        if (occurrences > 0) {
            System.out.println("Occurrences found at the following starting text indexes:");
            printOccurrences(text, pattern);
        } else {
            System.out.println("Pattern not found.");
        }
    }

    private static int searchPattern(String text, String pattern) {
        int occurrences = 0;
        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == patternLength) {
                occurrences++;
            }
        }

        return occurrences;
    }

    private static void printOccurrences(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == patternLength) {
                System.out.println(text);
                for (int k = 0; k < i; k++) {
                    System.out.print(" ");
                }
                System.out.println(pattern);
                System.out.println(i);
                System.out.println();
            }
        }
    }
}
