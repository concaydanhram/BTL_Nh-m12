package gamecardbaccarat;

import deckofcards.Card;
import playerofgame.Player;

import java.util.ArrayList;

public class PlayerBaccarat extends Player {
    private int scoreOfPlayer ;

    public void addCard(Card card){
        cardsInHand.add(card);
        this.scoreOfPlayer += card.getRank();
    }
    // Tính điểm của người chơi
/*    public void addScoreOfPlayer(Card card) {
        this.scoreOfPlayer += card.getRank();
    }*/
    public int getScoreOfPlayer(){
        return scoreOfPlayer;
    }
}