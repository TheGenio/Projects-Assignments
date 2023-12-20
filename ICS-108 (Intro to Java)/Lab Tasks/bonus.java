


import java.util.Arrays;
import java.util.ArrayList;


public class bonus {
    public static void main(String[] args) {

        int[] a ={10,12,3,40};

        int[] b = {10,3,12,40,15};

        ArrayList<Integer> array_list = new ArrayList<Integer>();
        ArrayList<Integer> array_list2 = new ArrayList<Integer>();


        for (int i = 0; i < a.length; i++){
            array_list.add(a[i]);}

        for (int i = 0; i < b.length; i++){
            array_list2.add(b[i]);}

        for (int i = 0; i < array_list.size(); i++){

            array_list2.remove(array_list.get(i));
        }

        for (int i = 0; i < array_list2.size(); i++){
            System.out.println(array_list2.get(i));
        }



    }




}
