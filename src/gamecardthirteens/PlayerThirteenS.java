package gamecardthirteens;

import deckofcards.Card;
import playerofgame.Player;

import java.util.Collections;
import java.util.Comparator;

public class PlayerThirteenS extends Player {
    public PlayerThirteenS() {
        super("Player");
    }

    public int reRank(Card card){
        if(card.getRank() == 2) return 15;
        return card.getRank();
    }

    public int reSuit(Card card){
        if(card.getSuit().equals("H")) return 4;
        if(card.getSuit().equals("D")) return 3;
        if(card.getSuit().equals("C")) return 2;
        return 1;
    }

    private boolean compareCard(Card card1, Card card2) {
        if(card1.getRank() > card2.getRank()) return true;
        if(card1.getRank() < card2.getRank()) return false;
        if(reSuit(card1) > reSuit(card2)) return true;
        return false;
    }

    public void sortCardsInHand(){
        Collections.sort(cardsInHand, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                int nameCompare = Integer.compare(reRank(card1), reRank(card2));
                if(nameCompare != 0) return nameCompare;
                return Integer.compare(reSuit(card1), reSuit(card2));
            }
        });
    }
}
