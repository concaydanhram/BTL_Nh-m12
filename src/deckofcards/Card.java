package deckofcards;
import cardsimage.*;

public class Card {
    private int cardNumber;
    private int suit;
    private int rank;

    public Card(){
    }
    public Card(int cardNumber, int suit, int rank) {
        this.cardNumber = cardNumber;
        this.suit = suit;
        this.rank = rank;
    }
    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getSuit() {
        return suit;
    }
    public void setSuit(int suit) {
        this.suit = suit;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
}