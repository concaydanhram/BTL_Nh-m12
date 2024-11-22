package gamecardbaccarat;

import java.util.ArrayList;

public class RulesOfBaccarat {
    protected int numberOfPlayer;
    protected int moneyPlayer;
    protected DeckOfBaccarat deckOfBaccarat = new DeckOfBaccarat();
    protected ArrayList<PlayerBaccarat> playersBaccarat = new ArrayList<PlayerBaccarat>();

    public int getScoreOfPlayer(PlayerBaccarat player) {
        CardOfBaccarat biggestCard = player.biggestCardInHand();
        int scoreOfPlayer = 0;
        for(int i = 0; i < 3; ++i) {
            scoreOfPlayer += ((CardOfBaccarat) player.getCardsInHand().get(i)).getRank();
            if(scoreOfPlayer > 10){
                scoreOfPlayer -= 10;
            }
        }
        return 100 * scoreOfPlayer + 10 * biggestCard.getSuit() + biggestCard.getRank();
    }

    public void winnerBaccarat(){
        int index = 0;
        int maxPoint = 0;
        for(int i = 0; i < numberOfPlayer; i++) {
            int point = getScoreOfPlayer(playersBaccarat.get(i));
            if (point > maxPoint) {
                maxPoint = point;
                index = i;
            }
        }
        for(int i = 0; i < numberOfPlayer; ++i){
            if(i != index){
                playersBaccarat.get(index).addMoneyPlayer(playersBaccarat.get(i).getMoneyPlayer());
                playersBaccarat.get(i).setMoneyPlayer(0);
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("Player " + playersBaccarat.get(index).getNameOfPlayer() + " wins!");
        System.out.println("----------------------------------------");
    }
}
