package LAB07;

import java.util.ArrayList;
import java.util.Scanner;


class Main1 {
    public static void main(String[] args) {
        Container_old test = new Container_old(10);
        Scanner scanner = new Scanner(System.in);

        int items = 0; // change to input, object numbers from input

        while (items <= 3){

            System.out.println("Add weight: ");
            int weight = scanner.nextInt();
            if(test.addItem(weight)){
                System.out.println("Added");
                items ++;
            } else {
                System.out.println("Not added");
                items++;
            }
        }
        test.printArray();
    }
}

public class Container_old {
    ArrayList <Integer> weightItems = new ArrayList<>();
    int maxWeight;
    public Container_old(int weight){

        maxWeight = weight;
    }

    public boolean addItem(int weight){
        double sum = 0;
        for (int i = 0; i < weightItems.size(); i++) {
            sum = sum + weightItems.get(i);
        }

        if(maxWeight > sum){
            weightItems.add(weight);
            return true;
        } else {return false;}
    }
    public void printArray(){

        for(int i = 0; i < weightItems.size(); i++){
            System.out.println(weightItems.get(i));
        }
    }


}
