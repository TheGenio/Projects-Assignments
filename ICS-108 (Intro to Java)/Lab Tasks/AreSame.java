public class AreSame {

   /* public static void main(String[] args) {
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp(a, b));
    }
*/
    public static boolean comp(int[] a, int[] b) {

        if (a.length == 0 || b.length ==0) {
            return false;
        } else if (b.length == 0) {
            return true;
        }

        if (a.length == b.length) { //regardless of order!!!

            int count = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    int temp1 = a[i] * a[i];
                    int temp2 = b[j];
                    if ((a[i] * a[i]) == b[j]) {
                        count++;
                        break;
                    }

                }
            }
            return count == a.length;
        }
        return false;
    }
}
