package LAB02;

public class SLLTest {
    public static void main(String[] args) {
        SLL<Integer> exam = new SLL<>();
        exam.addToTail(3);
        exam.addToTail(4);
        exam.addToTail(5);
        exam.addToTail(6);
        exam.addToTail(7);
        exam.addToTail(8);
        exam.addToTail(9);
        System.out.println(0%2);
        System.out.println("before: " + exam.toString());
        exam.examq();
        System.out.println("after: " + exam.toString());


        SLL<Integer> sll = new SLL<>();

        sll.addToTail(7);
        sll.addToTail(5);
        sll.addToTail(3);
        sll.addToTail(50);
        sll.addToTail(7);
        sll.addToTail(9);

        System.out.println("Original Integer array: "+ sll); //Should print [ 7 5 3 50 7 9 ]

        sll.insertBefore(4, 20);
        System.out.println("After inserting 20 before index 4: "+sll); //Should print [ 7 5 3 50 20 7 9 ]

        System.out.println("Element deleted from index 4: "+sll.delete(4)); // Should print: [ 7 5 3 50 7 9 ]
        System.out.println("After deleting element from index 4: "+sll);

        sll.insertAfterSecondOccurrence(30, 7);
        System.out.println("After inserting 30 after the second occurrence of 7: "+sll); // Should print: [ 7 5 3 50 7 30 9 ]


    }
}

