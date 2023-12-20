import java.util.ArrayList;
import java.util.Scanner;
public class Lab04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Integer> weights = new ArrayList<>();

        System.out.println("Enter the number of objects: ");
        int objects = scanner.nextInt();
        int sumWeights = 0;

        System.out.println("Enter the weights of the objects: ");
        for (int i = 0; i < objects; i++) { // get the weighs of all the objects
            int objWeight = scanner.nextInt();
            sumWeights = objWeight + sumWeights;
            weights.add(objWeight);
        }

        int containers = (int)(sumWeights / 10) + 1; // pigeon hole principle to get number of containers
        for (int i=0; i < containers; i++) {

            int min = weights.get(0);
            int max = weights.get(0);

            // store the length of the ArrayList in variable n
            int n = weights.size();

            // loop to find minimum from ArrayList
            for (int j = 1; j < n; j++) {
                if (weights.get(j) < min) {
                    min = weights.get(j);
                }
            }
            // loop to find maximum from ArrayList
            for (int z = 1; z < n; z++) {
                if (weights.get(z) > max) {
                    max = weights.get(z);
                }
            }

            if (max + max > 10){
                System.out.println("LAB07.Container " + (i+1) + " contains objects with weight " + max);
                weights.remove(max);

            } else if (max + min < 10) {
                System.out.println("LAB07.Container " + (i+1) + " contains objects with weight " + max + min );
                weights.remove(max);
                weights.remove(min);

            } else {
                System.out.println("LAB07.Container " + (i+1) + " contains objects with weight " + max );
                weights.remove(max);

            }


        }






    }
}
