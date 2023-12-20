package LAB10;

// file Employee.java
public class Employee extends Person {
    private int sid;
    private int salary;

    public Employee(String name, String phone, int sid, int salary) {
        super(name, phone);
        this.sid = sid;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + sid + "\t" + salary;
    }
}
