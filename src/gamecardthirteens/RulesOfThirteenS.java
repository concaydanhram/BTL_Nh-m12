package gamecardthirteens;

import java.util.ArrayList;
import java.util.Scanner;
import deckofcards.Card;

public class RulesOfThirteenS {
    protected int numberOfPlayer;//Số người chơi
    protected DeckOfThirteenS deckOfThirteenS = new DeckOfThirteenS();// Bộ bài
    protected ArrayList<PlayerThirteenS> playersThirteenS = new ArrayList<PlayerThirteenS>();// Danh sách người chơi

    // Kiểm tra điều kiện kết thúc game : 1 người chơi ko còn lá bài trên tay
    private boolean endOfGame(ThirteenS thirteenSr){
        for(int i = 0; i < thirteenSr.numberOfPlayer; i++){
            if(thirteenSr.playersThirteenS.get(i).getCardsInHand().isEmpty()){
                return true;
            }
        }
        return false;
    }

    // Kiểm tra bộ 2,3, tứ quý , sảnh dây
    protected boolean checkDoubleCard(CardOfThirteenS card1, CardOfThirteenS card2) {
        return card1.getRank() == card2.getRank();
    }

    protected boolean checkTripleCard(CardOfThirteenS card1, CardOfThirteenS card2, CardOfThirteenS card3) {
        return checkDoubleCard(card1, card2) && checkDoubleCard(card2, card3);
    }

    protected boolean checkFourFoldCard(CardOfThirteenS card1, CardOfThirteenS card2, CardOfThirteenS card3, CardOfThirteenS card4) {
        return checkDoubleCard(card1, card2) && checkTripleCard(card2, card3, card4);
    }

    protected boolean checkLobby(ArrayList<CardOfThirteenS> cards) {
        for(int i = 1; i < cards.size(); ++i){
            if(cards.get(i).getRank() - cards.get(i-1).getRank() != 1) return false;
        }
        return true;
    }

    private final Scanner scanner = new Scanner(System.in);
}
