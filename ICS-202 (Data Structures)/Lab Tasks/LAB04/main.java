package LAB04;

public class main {

    public static void main(String[] args){
        LabStack<Integer> s1 = new LabStack<Integer>();
        LabQueue<Integer> q1 = new LabQueue<Integer>();
        LabStack<Integer> s2 = new LabStack<Integer>();
        LabQueue<Integer> q2 = new LabQueue<Integer>();

        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        System.out.println("s1 =" + s1.toString());
        q1.enqueue(5);
        q1.enqueue(6);
        q1.enqueue(7);
        q1.enqueue(8);
        System.out.println("q1 =" + q1.toString());

        while (!s1.isEmpty()){
            s2.push(q1.dequeue());
            q2.enqueue(s1.pop());
        }
        System.out.println("s2 =" +s2.toString()); //s2
        System.out.println("q2 ="+q2.toString());
        String s22 = "";
        while(!s2.isEmpty()){
            s22 = s22 + s2.pop();
        }
        System.out.println("s2 ="+s22);
        String q22 = "";
        while(!q2.isEmpty()){
            q22 = q22 + q2.dequeue();
        }
        System.out.println("q2 ="+q22);

    }
}
