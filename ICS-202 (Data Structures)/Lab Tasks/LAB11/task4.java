package LAB11;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = scanner.nextLine();
        System.out.println("Enter the pattern to search for: ");
        String pattren = scanner.nextLine();

        String kmp = searchKMP(pattren,text);
        if(kmp == null){
            System.out.println("Pattern not in text.");
        }else {
            System.out.println("Pattern found at these text starting indexes: " + kmp);
        }
    }


    public static String searchKMP(String pattern, String text)
    {
        int M = pattern.length();
        int N = text.length();
        String indexes = "";


        int[] lps = computeLPSArray(pattern);

        int i = 0;
        int j = 0;
        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                indexes += (i - j) + "  ";
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters, they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }

        return indexes;
    }

    static int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int lps[] = new int[M];
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }

        return lps;
    }

}


