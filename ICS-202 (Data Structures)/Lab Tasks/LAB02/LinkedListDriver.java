package LAB02;

import java.util.LinkedList;
import java.util.Iterator;

class LinkedListDriver {
    public static void main(String[] args) {





        LinkedList<String> stringList = new LinkedList<>();

        stringList.add("Madinah");
        stringList.add("Dammam");
        stringList.add("Riyadh");
        stringList.add("Dhahraan");

        System.out.println("List: " + stringList);

        int index = stringList.indexOf("Riyadh");
        if(index == -1)
          System.out.println("Riyadh is not in the list");
        else{
          stringList.add(index + 1, "Jubail"); // insert Jubail after Riyadh
          stringList.addFirst("Najraan");   // insert Najraan at the beginning
        }

        System.out.println("List: " + stringList);

        index = stringList.indexOf("Dhahraan");
        if(index == -1)
          System.out.println("Dhahraan is not in the list");
        else
          stringList.set(index, "Abha");   // replace Dhahran with Abha

        String removedString = stringList. removeFirst();
        System.out.println("Removed Element: " + removedString);
        stringList.addFirst("Taif");
        System.out.println("Updated list: " + stringList);

        // Add code that will insert "Tabouk" before "Dammam", display error message if
        // "Dammam" is not in list or if the list is empty. Your code must work for any
        // two strings str1 and str2.
        if(stringList.contains("Dammam")) {
            Iterator<String> iterator = stringList.iterator();
            int count = 0;
            int indexOf = 0;
            while (iterator.hasNext()) {
                if (iterator.next().equals("Dammam")) {
                    indexOf = count;
                }
                count++;
            }
            if (indexOf != 0) {
                stringList.add(indexOf, "Tabouk");
                System.out.println("List after adding Tabouk: " + stringList);
            }


        } else{System.out.println("Error");}


        // Add code that will insert "AlKhafj" before the last node, your code must work
        // for any non-empty list. Display an error message if the list is empty.
            Iterator<String> iterator = stringList.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }
            stringList.add(count-1, "AlKhafj");
            System.out.println("List after adding AlKhafj: " + stringList);




    }
}