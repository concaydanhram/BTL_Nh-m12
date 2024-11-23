package playerofgame;

import deckofcards.Card;
import java.util.ArrayList;

public class Player <T> {
    protected String nameOfPlayer;// Tên người chơi
    protected ArrayList<T> cardsInHand  = new ArrayList<T>();// Bộ bài người chơi sở hữu

    // Constructor của người chơi
    public Player(String nameOfPlayer){
    }

    public void addCard(T card){
        cardsInHand.add(card);
    }

    public void dropCard(Card card){
        cardsInHand.remove(card);
    }

    public void printCardInHand(){
        System.out.println(nameOfPlayer + "'s cards in hand:");
        for (T card : cardsInHand) {
            System.out.print(card.toString() + " ");
        }
        System.out.println();
    }


    // Các getter và setter
    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }

    public ArrayList<T> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(ArrayList<T> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

}
