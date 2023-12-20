package LAB16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        try {
            Scanner input = new Scanner(new File("/Users/genio/IdeaProjects/ICS-108/src/LAB16/Untitled.txt"));

            while(input.hasNext()) {
                String id = input.next();
                students.add(id);
            }
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        Collections.sort(students);


        try {
            PrintWriter output = new PrintWriter("/Users/genio/IdeaProjects/ICS-108/src/LAB16/sortedStudents.txt");
            for (String std : students) {
                output.println(std);
            }
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}


