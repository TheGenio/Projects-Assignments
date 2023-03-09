package Assignment03;

import java.util.ArrayList;

public class main {
}



class Card{

    private ArrayList<Double> transactions = new ArrayList<>();
    private int cardNumber;

    Card(int cardNumber){ //constructor
        this.cardNumber = cardNumber;
    }

    //getters
    public int getCardNumber() {
        return cardNumber;
    }
   public ArrayList<Double> getTransactionList(){
        return this.transactions;
   }

    //setters
    public void setCardNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }

    public void purchase(double amount){
        this.transactions.add(amount);
    }

    //methods
    public double getAmount(ArrayList<Double> transactions){
        double amount = 0.0;
        for(int i = 0; i < transactions.size(); i++){
            amount = transactions.get(i);
        }
        return amount;
    }

    public String toString(){
        return "Card number:" + getCardNumber() + ", amount:" + getAmount( getTransactionList() );
    }

    public boolean equals(Object){ // make equals method

    }

}
