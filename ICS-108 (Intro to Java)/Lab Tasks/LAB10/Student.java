package LAB10;

// file Student.java
public class Student extends Person {
    private int sid;
    private double gpa;

    public Student(String name, String phone, int sid, double gpa) {
        super(name, phone);
        this.sid = sid;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + sid + "\t" + gpa;
    }
}
