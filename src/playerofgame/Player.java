package playerofgame;

import deckofcards.Card;
import java.util.ArrayList;

public class Player <T> {
    protected String nameOfPlayer;
    protected ArrayList<T> cardsInHand;

    public Player(String nameOfPlayer){
        this.nameOfPlayer = nameOfPlayer;
        this.cardsInHand = new ArrayList<>();
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }

    public ArrayList<T> getCardsInHand() {
        return cardsInHand;
    }

    public void addCard(T card){
        this.cardsInHand.add(card);
    }

    public void dropCard(T card){
        this.cardsInHand.remove(card);
    }

    public void printCardInHand(){
        System.out.println(nameOfPlayer + "'s cards in hand:");
        for (T card : this.cardsInHand) {
            System.out.print(card.toString() + " ");
        }
        System.out.println();
    }
}
