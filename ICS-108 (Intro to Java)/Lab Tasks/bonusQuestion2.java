import java.util.ArrayList;
import java.util.Arrays;

public class bonusQuestion2 {
    public static void reverseArrayList(ArrayList<Integer> list , ArrayList<Integer> newList){
        if(list.size() == 0){
            return;
        }
        newList.add(list.get(list.size()-1));
        list.remove(list.size()-1);
        reverseArrayList(list,newList);



    }


// mian method

    public static void main(String[] args) {
        Integer[] x = {1, 2, 3, 4, 5};

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(x));
        ArrayList<Integer> b = new ArrayList<>();
        reverseArrayList(a,b);
        System.out.println(b);
    }





}



