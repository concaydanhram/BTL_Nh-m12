package playerofgame;

import deckofcards.Card;
import java.util.ArrayList;

public class Player{
    public String nameOfPlayer;
    protected ArrayList<Card> cardsInHand  = new ArrayList<Card>();

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(ArrayList<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public void addCard(Card card){
        cardsInHand.add(card);
    }

    @Override
    public String toString(){
        return "nameOfPlayer='" + nameOfPlayer + '\'' + ", cardOfPlayer=" + cardsInHand + '}' + "\n";
    }
}
