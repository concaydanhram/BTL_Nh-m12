package gamecardbaccarat;

import deckofcards.Card;
import playerofgame.Player;

public class PlayerBaccarat extends Player {
    private int scoreOfPlayer ;
    private int moneyPlayer;

    public PlayerBaccarat() {
        super("Player");
        this.moneyPlayer = 0;
    }

    public int getMoneyPlayer() {
        return moneyPlayer;
    }

    public void setMoneyPlayer(int moneyPlayer) {
        this.moneyPlayer = moneyPlayer;
    }

    public void addMoneyPlayer(int moneyPlayer) {
        this.moneyPlayer += moneyPlayer;
    }

    public void addCard(CardOfBaccarat card){
        cardsInHand.add(card);
        this.scoreOfPlayer += card.getRank();
        while (this.scoreOfPlayer > 10)
            this.scoreOfPlayer -= 10;
    }

    protected boolean compareCard(CardOfBaccarat card1, CardOfBaccarat card2){
        if(card1.getSuit() > card2.getSuit()) return true;
        if(card1.getSuit() < card2.getSuit()) return false;
        if(card1.getRank() > card2.getRank()) return true;
        return false;
    }

    public CardOfBaccarat biggestCardInHand(){
        CardOfBaccarat card = (CardOfBaccarat) cardsInHand.get(0);
        for(int i = 1; i < cardsInHand.size(); i++){
            CardOfBaccarat cardinhand = (CardOfBaccarat) cardsInHand.get(i);
            if(compareCard(cardinhand, card)){
                card = cardinhand;
            }
        }
        return card;
    }

    public void printPlayer(){
        System.out.println("Player " + this.getNameOfPlayer() + " has " + moneyPlayer + " $");
    }

    // Tính điểm của người chơi
    public int getScoreOfPlayer(){
        CardOfBaccarat biggestCard = biggestCardInHand();
        return 100 * scoreOfPlayer + 10 * biggestCard.getSuit() + biggestCard.getRank();
    }
}