package playerofgame;

import deckofcards.Card;
import java.util.ArrayList;

public class Player{
    protected String nameOfPlayer;
    protected ArrayList<Card> cardsInHand  = new ArrayList<Card>();

    public Player(){
    }

    public String getNameOfPlayer(){
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer){
        this.nameOfPlayer = nameOfPlayer;
    }

    public ArrayList<Card> getCardOfPlayer(){
        return cardsInHand;
    }

    public void addCard(Card card){
        cardsInHand.add(card);
    }

    @Override
    public String toString(){
        return "nameOfPlayer='" + nameOfPlayer + '\'' + ", scoreOfPlayer=" + ", cardOfPlayer=" + cardsInHand + '}' + "\n";
    }
}
