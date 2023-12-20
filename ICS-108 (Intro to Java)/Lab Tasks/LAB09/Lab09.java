package LAB09;

public class Lab09 {
    public static void main(String[] args) {

        person p1 = new person("Salem", "0501331854");
        Student s1 = new Student("reem","0501331854", 12312,3.8);
        Employee e1 = new Employee("Saad","0501331854",32142 ,16000);

        System.out.println(p1.toString());
        System.out.println(s1.toString());
        System.out.println(e1.toString());



    }



}


class person{
    private String name;
    private String phoneNum;

    public person(){}

    public person(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getNum(){
        return this.phoneNum;
    }
    public String getName(){
        return this.name;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "Phone Number: " + this.phoneNum;
    }
}


class Student extends person{
    private int id;
    private double gpa;

    public Student(String name, String phone, int id, double gpa){
        super(name, phone);
        this.id = id;
        this.gpa = gpa;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    public double getGpa(){
        return this.gpa;
    }


    @Override
    public String toString() {
        return "Student{" + "name=" + getName() + ", phoneNum=" + getNum() + ", id}" + this.id + ", gpa =" + this.gpa + '}';
    }
}


class Employee extends person{
    private int id;
    private int salary;

    public Employee(String name, String phone, int id, int salary){
        super(name, phone);
        this.id = id;
        this.salary = salary;
    }

    public int getSalary(){
        return this.salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    public String toString(){
        return "Employee{" + "name=" + getName() + ", phoneNum=" + getNum() + ", id" + this.id + ", salary" + this.salary + "SAR";
    }



}


