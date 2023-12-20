package LAB23;

import java.util.LinkedList;
import java.util.TreeSet;

public class main {

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=2; i < 11; i++){
            list.add(i);
        }

        for(int i=0; i<list.size(); i++){
            //if (isPrime(list.get(i))) {
                int number = list.get(i);
                for (int j = i+1 ; j < list.size(); j++) {
                    if (list.get(j) % number == 0) {
                        list.remove(j);
                    }
                }
           // }
        }
        System.out.println(list);


    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
