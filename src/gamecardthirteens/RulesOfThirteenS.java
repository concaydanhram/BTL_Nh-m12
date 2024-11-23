package gamecardthirteens;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class RulesOfThirteenS {
    protected int numberOfPlayer;
    protected DeckOfThirteenS deckOfThirteenS = new DeckOfThirteenS();
    protected ArrayList<PlayerThirteenS> playersThirteenS = new ArrayList<PlayerThirteenS>();

    protected ArrayList<CardOfThirteenS> sortCards(ArrayList<CardOfThirteenS> cards) {
        cards.sort(new Comparator<CardOfThirteenS>() {
            @Override
            public int compare(CardOfThirteenS card1, CardOfThirteenS card2) {
                int nameCompare = Integer.compare(card1.getRank(), card2.getRank());
                if (nameCompare != 0) return nameCompare;
                return Integer.compare(card1.getSuit(), card2.getSuit());
            }
        });
        return cards;
    }

    private boolean checkDoubleCard(ArrayList<CardOfThirteenS> cards) {
        if(cards.size() != 2) return false;
        return cards.get(0) == cards.get(1);
    }

    private boolean checkTripleCard(ArrayList<CardOfThirteenS> cards) {
        if(cards.size() != 3) return false;
        for(int i = 0; i < 2; ++i){
            if(cards.get(i) != cards.get(i+1)) return false;
        }
        return true;
    }

    private boolean checkFourFoldCard(ArrayList<CardOfThirteenS> cards) {
        if(cards.size() != 4) return false;
        for(int i = 0; i < 3; ++i){
            if(cards.get(i) != cards.get(i+1)) return false;
        }
        return true;
    }

    private boolean checkLobby(ArrayList<CardOfThirteenS> cards) {
        cards = sortCards(cards);
        for(int i = 1; i < cards.size(); ++i){
            if(cards.get(i).getRank() - cards.get(i-1).getRank() != 1) return false;
        }
        return true;
    }

    private boolean checkPine(ArrayList<CardOfThirteenS> cards) {
        if(cards.size()%2 == 1) return false;
        cards = sortCards(cards);
        if(cards.get(0).getRank() != cards.get(1).getRank() || cards.get(0).getRank() == 15) return false;
        for(int i = 3; i < cards.size(); i += 2){
            if(cards.get(i).getRank() == 15) return false;
            if(cards.get(i).getRank() != cards.get(i-1).getRank() || cards.get(i).getRank() - cards.get(i-2).getRank() != 1) return false;
        }
        return true;
    }

    private boolean compare(CardOfThirteenS card1, CardOfThirteenS card2) {
        if(card1.getRank() == card2.getRank())
            return card1.getSuit() > card2.getSuit();
        return card1.getRank() > card2.getRank();
    }

    private boolean compareCard(ArrayList<CardOfThirteenS> card1s, ArrayList<CardOfThirteenS> card2s) {
        card1s = sortCards(card1s);
        card2s = sortCards(card2s);
        return compare(card1s.getLast(), card2s.getLast());
    }

    private String getTypeOfCards(ArrayList<CardOfThirteenS> cards) {
        if(checkDoubleCard(cards)) return "Double";
        if(checkTripleCard(cards)) return "Triple";
        if(checkFourFoldCard(cards)) return "Four-Fold";
        if(checkLobby(cards)) return "Lobby";
        if(checkPine(cards)) return "Pine";
        return "Once";
    }

    protected boolean checkCardsDrop(ArrayList<CardOfThirteenS> cards,ArrayList<CardOfThirteenS> cardsPreTurn) {
        if(cards.isEmpty()) return false;
        if(cardsPreTurn.isEmpty()) return true;
        String type = getTypeOfCards(cardsPreTurn);
        if(!getTypeOfCards(cards).equals(type)) return false;
        return compareCard(cards, cardsPreTurn);
    }

    protected PlayerThirteenS checkWinner(){
        for(int i = 0; i < numberOfPlayer; i++) {
            ArrayList<CardOfThirteenS> cards = new ArrayList<CardOfThirteenS>();
            for(int j = 9; j < 13; ++j) {
                CardOfThirteenS card = (CardOfThirteenS) (playersThirteenS.get(i).getCardsInHand()).get(j);
                cards.add(card);
            }
            if(checkFourFoldCard(cards)) return playersThirteenS.get(i);
        }
        return null;
    }

    protected PlayerThirteenS endOfGame(){
        for(int i = 0; i < numberOfPlayer; i++){
            if(playersThirteenS.get(i).getCardsInHand().isEmpty()){
                return playersThirteenS.get(i);
            }
        }
        return null;
    }

    private final Scanner scanner = new Scanner(System.in);
}