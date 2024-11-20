package gamecardbaccarat;

import deckofcards.Card;
import playerofgame.Player;

import java.util.ArrayList;

public class PlayerBaccarat extends Player {
    public int getScoreOfPlayer() {
        int scoreOfPlayer = 0;
        for (int i = 0; i < cardsInHand.size(); ++i)
            scoreOfPlayer += cardsInHand.get(i).getRank();
        return scoreOfPlayer%10;
    }
}