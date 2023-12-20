package LAB13;
import java.util.Arrays;
public class ComparingTest {

    public static void main(String[] args) {

        City[] newcites = new City[5];
        String[] listOfCites = {"Mumbai", "Delhi", "Riyadh", "Dammam", "Bangalore"};

        for (int i = 0; i < newcites.length; i++) {

            int temp = (int) ( Math.random()*(40-10) + 10);
            newcites[i] = new City(listOfCites[i], temp);
            System.out.println(newcites[i].toString());
        }

        System.out.println("------------------------------------");
        System.out.println("Now sorted from higest to lowest");
        Arrays.sort(newcites);
        for(City e : newcites) {
            System.out.println(e.toString());
        }


    }
}
