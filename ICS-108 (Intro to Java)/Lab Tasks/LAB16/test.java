package LAB16;

public class test {
}


class person implements Comparable<person>{
    private String name;
    private int age;

    public int compareTo(person p) {
        if (this.age > p.age) {
            return 1;
        } else if (this.age < p.age) {
            return -1;
        }else {return 0;}

    }

    }

