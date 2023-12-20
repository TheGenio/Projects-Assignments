package LAB08;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lab08 {
    public static void main(String[] args) {
        String question = "What is the best laptop";
        String[] choices = {"Apple", "Samsung", "HP"};


        MCQustion qustion1 = new MCQustion(question,choices, 4);
        System.out.println(qustion1.toString());
        qustion1.setQuestion("What is the best phone");
        System.out.println(qustion1.getQuestion());
    }



}



class Qustion{
    private String text;
    public Qustion(String text){

        this.text = text;
    }
    public String toString(){
        return this.text;
    }

    public String getQuestion(){
        return text;
    }
    public String setQuestion(String text){
        this.text = text;
        return this.text;
    }


}


class MCQustion extends Qustion{
    String[] choices = new String[4];
    int correct;

    public MCQustion(String text , String[] choices, int correct){
        super(text);
        this.choices = choices;
        this.correct = correct;
    }




    public String toString(){

        return super.toString() + Arrays.toString(this.choices) + this.correct ;
    }
}