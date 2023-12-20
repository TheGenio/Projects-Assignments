package LAB04;

import java.util.Scanner;

public class task2 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter your expression: ");
        //String expression = scanner.nextLine();
        //BalancedParentheses(expression); //[3 + (2 – 4) + {(a – b)}]

        //BalancedParentheses("[3 + 2( ");
        //BalancedParentheses("{ 7 + [ a – b} ] ");
        //BalancedParentheses("(a[3) - b(2])");

       //System.out.println("Enter your <postfix> expression: ");
       //String postfix = scanner.nextLine();

       //postfix(postfix); //
        // postfix("20 2 * 10 /");
        System.out.println("Enter your input: ");
        String revStack = scanner.nextLine();
        reverse(revStack);

    }

    public static void BalancedParentheses(String expression) {

        LabStack<Character> paranthese = new LabStack<>();

        boolean flag = true;
        for (Character x : expression.toCharArray()) {
            switch (x) {
                case '[' -> paranthese.push(x);
                case '{' -> paranthese.push(x);
                case '(' -> paranthese.push(x);
                case ')' -> {
                    if (paranthese.pop() != '(') {
                        flag = false;
                    }
                }
                case '}' -> {
                    if (paranthese.pop() != '{') {
                        flag = false;
                    }
                }
                case ']' -> {
                    if (paranthese.pop() != '[') {
                        flag = false;
                    }
                }
            }

        }

        if (flag == false) {
            System.out.println("Expression is not balanced");
        } else if (!paranthese.isEmpty()) {
            System.out.println("Expression is not balanced");

        } else {
            System.out.println("Expression is balanced");
        }
    }

    public static void postfix(String expression) {
        LabStack<Integer> paranthese = new LabStack<>();
        String number = "";
        for (Character x : expression.toCharArray()) {
            if (x == ' ') {
                if (number.chars().allMatch(Character::isDigit)) {
                    if (number != "") {
                        paranthese.push(Integer.valueOf(number));
                        number = "";
                    }
                }
            } else if (x != '*' && x != '/' && x != '+' && x != '-') {
                number = number + x;
            }

            switch (x) {
                case '*' -> {
                    paranthese.push(paranthese.pop() * paranthese.pop());
                    System.out.println("Currently, the stack is>> " + paranthese);
                }
                case '/' -> {
                    int divisor = paranthese.pop();
                    int dividend = paranthese.pop();
                    int result = dividend / divisor;
                    paranthese.push(result);
                    System.out.println("Currently, the stack is >> " + paranthese);
                }
                case '+' -> {
                    paranthese.push((paranthese.pop()) + paranthese.pop());
                    System.out.println("Currently, the stack is>>  " + paranthese);
                }
                case '-' -> {
                    int num1 = paranthese.pop();
                    int num2 = paranthese.pop();
                    paranthese.push(num2 - num1);
                    System.out.println("Currently, the stack is>>" + paranthese);
                    ;
                }
            }


        }


        System.out.println(expression + " = " + paranthese.topEl());

    }

    public static void reverse(String expression) {

        LabStack<String> paranthese = new LabStack<>();
        String number = "";
        int counter = 0;
        for (Character x : expression.toCharArray()) {

            if (x == ' ') {
                if (number.chars().allMatch(Character::isDigit)) {
                    if (number != "") {
                        paranthese.push(number);
                        number = "";
                    }
                }else{
                    paranthese.push(String.valueOf(x));
                }

            } else if (Character.isDigit(x)) {
                number = number + x;
            }else {paranthese.push(String.valueOf(x));}
            if (counter == expression.length()-1) {
                if (number !="") {
                    paranthese.push(number);
                }
            }
            counter++;
        }

        LabQueue<String> Qreverse = new LabQueue<String>();
        System.out.println("Now the stack is>> " + paranthese);
        while(!paranthese.isEmpty()){
            Qreverse.enqueue(paranthese.pop());
        }

        while(!Qreverse.isEmpty()){
            paranthese.push(Qreverse.dequeue());
        }
        System.out.println("After the stack is>> " + paranthese);



    }

}
