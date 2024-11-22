package gamecardthirteens;

import java.util.ArrayList;
import java.util.Scanner;
import deckofcards.Card;

public class RulesOfThirteenS {
    protected int numberOfPlayer;
    protected DeckOfThirteenS deckOfThirteenS = new DeckOfThirteenS();
    protected ArrayList<PlayerThirteenS> playersThirteenS = new ArrayList<PlayerThirteenS>();

    protected boolean checkDoubleCard(Card card1, Card card2) {
        return card1.getRank() == card2.getRank();
    }

    protected boolean checkTripleCard(Card card1, Card card2, Card card3) {
        return checkDoubleCard(card1, card2) && checkDoubleCard(card2, card3);
    }

    protected boolean checkFourFoldCard(Card card1, Card card2, Card card3, Card card4) {
        return checkDoubleCard(card1, card2) && checkTripleCard(card2, card3, card4);
    }

    protected boolean checkLobby(ArrayList<Card> cards) {
        for(int i = 1; i < cards.size(); ++i){
            if(cards.get(i).getRank() - cards.get(i-1).getRank() != 1) return false;
        }
        return true;
    }

    private boolean endOfGame(ThirteenS thirteenSr){
        for(int i = 0; i < thirteenSr.numberOfPlayer; i++){
            if(thirteenSr.playersThirteenS.get(i).getCardsInHand().isEmpty()){
                return true;
            }
        }
        return false;
    }

    private final Scanner scanner = new Scanner(System.in);
}
