package LAB07;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestAVL {
    public static void main(String[] args) {
        //Example which works with Left Rotation
        AVLTree<String> t = new AVLTree<String>();
        for (int i = 1; i <= 5; i++)
            t.insertAVL("a" + i);
        t.breadthFirst();
        System.out.println();

        System.out.println("Exercise 2");
        AVLTree<Integer> tnt = new AVLTree<>();

        int[] values = {8, 14, 12, 18, 23, 20, 15, 13, 7, 16};
        for (int e : values) {
            tnt.insertAVL(e);
        }
        tnt.breadthFirst();
        tnt.deleteAVL(18);
        tnt.deleteAVL(7);
        tnt.deleteAVL(20);
        tnt.breadthFirst();

        System.out.println("Exercise 3");
        String filePath = "/Users/genio/IdeaProjects/ICS-202/src/LAB07/sampletextfile.txt";
        AVLTree<String> str = new AVLTree<String>();


        // Create a Path object
        Path path = Paths.get(filePath);
                try {
            // Create a Scanner to read from the file
            Scanner scanner = new Scanner(path);

            // Read and print each line from the file
            while (scanner.hasNextLine()) {
                String line = scanner.next();
                str.insertAVL(line);
            }
            str.inorder();
            // Close the scanner to release resources
            scanner.close();
        } catch (IOException e) {
            // Handle the IOException (e.g., file not found)

        }


    }
}