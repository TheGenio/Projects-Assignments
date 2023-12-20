import java.util.ArrayList;

import java.util.Scanner;
public class lab04test {

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



        }
    }

