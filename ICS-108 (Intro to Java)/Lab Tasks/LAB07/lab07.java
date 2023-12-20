package LAB07;

import java.util.ArrayList;
import java.util.Scanner;

public class lab07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> weightsOfObjects = new ArrayList<>(); //creates a new array to store the weights

        System.out.println("Enter the number of objects: ");
        int numberOfObjects = scanner.nextInt();

        System.out.println("Enter the weight of the objects: ");
        for (int i = 0; i < numberOfObjects; i++) { //for loop to add each weight
            weightsOfObjects.add(scanner.nextInt());
        }

        ArrayList<Container> containers = new ArrayList<>(); //creates a new arraylist to store the containers
        for (int i = 0; i < numberOfObjects; i++) { //picks weight
            boolean added = false;

            for (Container container : containers) { //creates a new container

                if (container.getCurrentWeight() + weightsOfObjects.get(i) <= 10) { // will check if the current weight of the container plus the added weight is less than 10
                    container.addWeight(weightsOfObjects.get(i)); // adds weight to the container
                    added = true;
                    break; //leaves the for loop to pick a new weight
                }
            }

                if (!added) {
                    Container container = new Container();
                    container.addWeight(weightsOfObjects.get(i));
                    containers.add(container);

                }

        }


        for (int i = 0; i < containers.size(); i++) {
            System.out.println("Container contains objects with weights " + (i ) + ": " + containers.get(i).getWeightItems());
        }
    }
}



class Container {


    ArrayList <Integer> weightItems = new ArrayList<>();

    private int maxWeight;
    private int currentWeight;

    Container() {
        this.maxWeight = 10;
        this.currentWeight = 0;
    }
    public int getMaxWeight() {return maxWeight;}

    public int getCurrentWeight(){return currentWeight;}

    public ArrayList<Integer> getWeightItems() {
        return weightItems;
    }
    public void addWeight(int weight) {
            weightItems.add(weight);
            currentWeight += weight;
        }


    }


