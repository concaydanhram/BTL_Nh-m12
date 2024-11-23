package gamecardthirteens;

import playerofgame.Player;

import java.util.Comparator;

public class PlayerThirteenS extends Player {
    public PlayerThirteenS() {
        super("Player");
    }

    // Sắp xếp các lá bài trên tay của ngươời chơi
    public void sortCardsInHand(){
        cardsInHand.sort(new Comparator<CardOfThirteenS>() {
            @Override
            public int compare(CardOfThirteenS card1, CardOfThirteenS card2) {
                int nameCompare = Integer.compare(card1.getRank(), card2.getRank());
                if (nameCompare != 0) return nameCompare;
                return Integer.compare(card1.getSuit(), card2.getSuit());
            }
        });
    }

    // So sánh các lá bài theo rank -> suit
    private boolean compareCard(CardOfThirteenS card1, CardOfThirteenS card2) {
        if(card1.getRank() > card2.getRank()) return true;
        if(card1.getRank() < card2.getRank()) return false;
        if(card1.getSuit() > card2.getSuit()) return true;
        return false;
    }
}
