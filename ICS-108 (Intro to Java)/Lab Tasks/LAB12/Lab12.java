package LAB12;

public class Lab12 {

    public static void main(String[] args) {
        Student[] students = new Student[10];

        for (Student stat: students) {
            int temp = (int)(Math.random() + 1.5);
            double gpa = (float) (Math.random()*3 + 1);
            if (temp == 1){

                stat = new Graduate("GRADUATE ", gpa);

            }else if (temp == 2){
                stat = new Undergraduate("UNDERGRADUATE ", gpa);
            }

            System.out.println(stat.toString());

        }



    }


}


abstract class Student {
    private String id;
    private double gpa;

    Student(String id, double gpa) {
        this.id = id;
        this.gpa = gpa;
    }

    abstract String getStatus();

    public final String toString() {
        return "TYPE :" + id + " GPA: " + gpa +" STATUS " +getStatus();
    }

    public double getGpa(){
        return this.gpa;
    }


}



class Undergraduate extends Student{

    private String status;

    Undergraduate(String id, double gpa) {
        super(id, gpa);
    }

    public void setStatus() {
        if (getGpa() >= 3) {
            status = "good";
        }else {status = "probation";}
    }
    @Override
    String getStatus() {
        setStatus();
        return status;
    }


    }

    class Graduate extends Student {
        private String status;


        Graduate(String id, double gpa) {
            super(id, gpa);
        }



        public void setStatus() {
            if (getGpa() >= 3) {
                status = "honor";
            } else if (getGpa() >= 2) {
                status = "good";
            } else {status = "probation";}
        }
        @Override
        String getStatus() {
            setStatus();
            return status;
        }
    }