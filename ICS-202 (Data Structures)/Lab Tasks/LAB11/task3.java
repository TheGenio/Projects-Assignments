package LAB11;
import java.util.Scanner;

public class task3 {
}
class PSuffix {
    static void countSamePrefixSuffix(String s, int n) {
        for (int i = 1; i < n; i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(n - i, n);

            System.out.println("Proper prefix: " + prefix + ", Proper suffix: " + suffix);

            if (prefix.equals(suffix)) {
                System.out.println(" *" + prefix.length());
            }

            System.out.println("-------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the pattern: ");
        String S = scanner.nextLine();
        int N = S.length();
        System.out.println("Substring: ");
        System.out.println("-------------------------------");
        countSamePrefixSuffix(S, N);



    }
        public static int[] computeNextArray(String x){
       int[] next = new int[x.length() + 1];
       next[0] = -1;
       int i = 0, j = -1;
       while(i < x.length()){
          while(j == -1 || i < x.length() && (x.charAt(i) == x.charAt(j))){
            i++;
            j++;
            next[i] = j;
          }

          j = next[j];
        }

        return next;
      }

}
