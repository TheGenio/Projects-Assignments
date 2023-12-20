package LAB21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(21);
        test.add(90);
        test.add(100);
        test.add(90);

        remove(test, 90);
        System.out.println("Here" + test);
    }

    public static void remove(ArrayList<Integer> list, Integer target) {
        if (list.isEmpty()) {
            return;
        } else {
            if (list.get(0) == target) {
                list.remove(0);
                remove(list, target);
            } else {
                remove(new ArrayList<>(list.subList(1, list.size())), target);
            }
        }
    }





}

