package Assignment02;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    public static void main(String[] args) {
        ArrayList<Integer> sum45 = new ArrayList<>(); //init an array list with random numbers that sum to 45
        sum45.add(18);
        sum45.add(10);
        sum45.add(7);
        sum45.add(2);
        sum45.add(4);
        sum45.add(4);


        boolean flag = true;
        while (flag) {

            System.out.println(sum45);

            for (int i = 0; i < sum45.size(); i++) { //this loop will go over all the elements and subtract 1 from them
                int temp = sum45.get(i) - 1;
                sum45.set(i, temp);
            }
            sum45.add(sum45.size()); //add the sum of the subtracted numbers to the end of the list
            sum45.removeAll(Collections.singleton(0)); //remove ane possible zeros from the list

            int check = 0;
            for (int j = 1; j < 10; j++) { //this loop will check if we have 1 to 9 in any possible order
                if (sum45.contains(j)) {
                    check++; // if the number is in the list it will incremeant by one
                }
            }
            if (check == 9) { // this will mean that we have all numbers from 1-9
                flag = false;
                System.out.println(sum45);
            }

        } //while bracket
    } //method bracket
} //class bracket