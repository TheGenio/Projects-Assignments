package LAB10;

import java.util.ArrayList;
public class Lab10 {
    public static void main(String[] args) {
        ArrayList<Person> personList = createPersonList();
//1. This method prints the employees only
        printEmployees(personList);
//2. This method finds the average salary of employees
        double avgSalary = avgSalary(personList);
        System.out.println("avg salary of = " + avgSalary);
//3. This method prints the students only
        printStudents(personList);
//4. This method finds the average GPA of students
        double avgGpa = avgGpa(personList);
        System.out.println("avg GPA of students = " + avgGpa);
    }

    private static double avgGpa(ArrayList<Person> personList) {

        int count = 0;
        double avaGPA = 0.0;
        for(Person gpa: personList){
            if (gpa instanceof Student) {
                count++;
                avaGPA = ((Student) gpa).getGpa() + avaGPA;
            }
        }
        return (avaGPA / count);


    }

    private static void printStudents(ArrayList<Person> personList) {
        System.out.println("List of Students");
        System.out.println("Name   Phone     ID           GPA");

        for(Person student :personList){
            if(student instanceof Student){
                System.out.println(student.toString());
            }
        }
    }

    private static double avgSalary(ArrayList<Person> personList) {

        int count = 0;
        double avaSalary = 0.0;
        for(Person salary: personList){
            if (salary instanceof Employee) {
                count++;
                avaSalary = ((Employee) salary).getSalary() + avaSalary;
            }
        }
return (avaSalary / count);
    }

    private static void printEmployees(ArrayList<Person> personList) {
        System.out.println("List of EMPLOYEES:");
        System.out.println("Name   Phone     ID           Salary");
        for(Person personPrint : personList) {
            if (personPrint instanceof Employee) {
                System.out.println(personPrint.toString());
            }
        }
    }

    private static ArrayList<Person> createPersonList() {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Employee("Saad", "0563428255", 200003, 16000));
        personList.add(new Student("Reem", "0564448202", 20000, 3.6));
        personList.add(new Employee("Salem", "0501331845", 200001, 9000));
        personList.add(new Student("Hasan", "0594448202", 20002, 2.8));
        return personList;
    }
}



