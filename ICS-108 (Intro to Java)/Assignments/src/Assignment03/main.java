package Assignment03;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args){

        int numberOFCards = 10; // It can be of your own choice.
        Card[] cards = new Card[numberOFCards];

        for (int i =0 ; i < cards.length ; i ++){

            // Generate a random card
            int choice = (int) (Math.random()*2);
            int cardnumber = (int) (Math.random() * 1000000000);
            if ( choice % 2 ==0 )

                // Generate random fees
                cards[i] =new SilverCard(cardnumber, 0.15);
            else {
                int monthlyFee = (int) (Math.random() * (300 - 100) + 100);
                cards[i] = new GoldCard(cardnumber, monthlyFee); //
            }
            // Do some transactions
            int transactions = (int) (Math.random()*(15-5)+5);
            for (int j = 0 ; j < transactions ; j++) {
                int amount = (int) (Math.random() *100000);
                cards[i].purchase(amount);
            }
        }

        Arrays.sort(cards);

        for (Card value : cards) { //printing sorted arrays
            System.out.println(value.toString());
        }

        //finding the total amount of gold card members
        double sumOfGoldCardAmount = 0;
        for(Card card : cards){
            if (card instanceof GoldCard){
            sumOfGoldCardAmount += card.getAmount();
            }
        }
        System.out.println("The total amount of all GoldenCard objects in the array is " + sumOfGoldCardAmount);


    }



}



class Card implements Comparable<Card>{

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
    public double getAmount(){
        double amount = 0.0;
        for(int i = 0; i < transactions.size(); i++){
            amount = transactions.get(i);
        }
        return amount;
    }

    public String toString(){
        return "Card number:" + getCardNumber() + ", amount:" + getAmount();
    }

    public boolean equals(Object o){
        return (o instanceof Card ) && ( getCardNumber() == ( (Card)o).getCardNumber());
    }

    @Override
    public int compareTo(Card o) {
        return Double.compare(getCardNumber(), o.getCardNumber());
    }
}



class SilverCard extends Card {
    private double transactionFee;


    SilverCard(int cardNumber, double transactionFee) {
        super(cardNumber);
        this.transactionFee = transactionFee;
    }

    public void purchase(double amount){
        getTransactionList().add( (amount * transactionFee + amount) );
    }


}



class GoldCard extends Card{
    private int monthlyFee;

    GoldCard(int cardNumber, int monthlyFee) {
        super(cardNumber);
        this.monthlyFee = monthlyFee;
    }

    public double getAmount(){
        return super.getAmount() + monthlyFee;
    }
}


