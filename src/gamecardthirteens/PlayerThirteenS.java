package gamecardthirteens;

import playerofgame.Player;

import java.util.ArrayList;
import java.util.Comparator;

public class PlayerThirteenS extends Player {

    public PlayerThirteenS() {
        ArrayList<CardOfThirteenS> cards = new ArrayList<>();
        super("Player", cards);
    }

    // Lặp code
    public void sortCardsInHand(){
        super.cardsInHand.sort(new Comparator<CardOfThirteenS>() {
            @Override
            public int compare(CardOfThirteenS card1, CardOfThirteenS card2) {
                return card1.compareCard(card2);
            }
        });
    }
}
