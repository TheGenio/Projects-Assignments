package LAB20;

import java.util.ArrayList;

public class factrec {


    public static void main(String[] args){
        ArrayList<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(21);
        test.add(190);
        test.add(100);
        test.add(90);
        System.out.println(largestInteger(test,test.size()-1));

    }

    public static int largestInteger(ArrayList<Integer> list , int index){
        if (index == 1){
            return list.get(0);
        } else{
            return Math.max(list.get(index), largestInteger(list, index -1));
            }
    }

}