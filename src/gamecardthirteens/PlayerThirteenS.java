package gamecardthirteens;

import deckofcards.Card;
import playerofgame.Player;

public class PlayerThirteenS extends Player {
    public PlayerThirteenS() {
        super("Player");
    }

    private int reRank(Card card){
        if(card.getRank() == 2) return 15;
        return card.getRank();
    }

    private boolean compareCard(Card card1, Card card2) {
        if(card1.getRank() > card2.getRank()) return true;
        if(card1.getRank() < card2.getRank()) return false;
        if(card1.getSuit() > card2.getSuit()) return true;
        return false;
    }

    public void addCard() {

    }

    public void sortCardsInHand(){

    }

    public void printCardsInHand(){
        for(int i = 0; i < cardsInHand.size(); i++){
            System.out.println(cardsInHand.get(i));
        }
    }
}
