package LAB15;

import java.util.Scanner;

public class LabTime {

    public static void main(String[] args) {
        // y or n
        boolean choice = true;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Enter time in 24-hour notation:");
            scanner.useDelimiter(":|\\s+");
            int hour = scanner.nextInt();
            int minute = scanner.nextInt();

            try {
                time converted = new time(hour, minute);
                System.out.println("That is the same as " +converted.convert());

                System.out.println("Again? (y/n)");
                String again = scanner.next();
                if (again.equals("y")) {} else if (again.equals("n")) {break;}

            } catch (TimeFormatException e) {
                System.out.println(e.getMessage());

            } catch (Exception e) {
                System.out.println("Hey, that's not a valid time!");
            }


        } while (choice);



    }



}


class time {

    int hour,minute;

    time(int h, int m) {
        this.hour = h;
        this.minute = m;
    }

    public String convert() throws TimeFormatException {


        if (hour < 0 || hour > 23 || minute < 0 || minute > 60) {

            throw new TimeFormatException();

        } else if (hour < 12){
            return hour + ":" + minute;
        } else {
            return ((hour - 12) +":" + minute + "");
        }

    }

}



class TimeFormatException extends Exception {
    public TimeFormatException() {
        super("Wrong format entered");
    }


}
