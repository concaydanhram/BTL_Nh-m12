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

    public void addCard(Card card){
        cardsInHand.add(card);
        if(card.getRank() == 14) this.scoreOfPlayer += 11;
        else this.scoreOfPlayer += card.getRank();
        while (this.scoreOfPlayer > 10)
            this.scoreOfPlayer -= 10;
    }

    private int reSuit(Card card){
        if(card.getSuit().equals("D")) return 4;
        if(card.getSuit().equals("H")) return 3;
        if(card.getSuit().equals("S")) return 2;
        return 1;
    }

    protected boolean compareCard(Card card1, Card card2){
        if(reSuit(card1) > reSuit(card2)) return true;
        if(reSuit(card1) < reSuit(card2)) return false;
        if(card1.getRank() > card2.getRank()) return true;
        return false;
    }

    public Card biggestCardInHand(){
        Card card = cardsInHand.get(0);
        for(int i = 1; i < cardsInHand.size(); i++){
            if(compareCard(cardsInHand.get(i), card)){
                card = cardsInHand.get(i);
            }
        }
        return card;
    }

    public void printPlayer(){
        System.out.println("Player " + this.getNameOfPlayer() + " has " + moneyPlayer + " $");
    }

    // Tính điểm của người chơi
    public int getScoreOfPlayer(){
        Card biggestCard = biggestCardInHand();
        return 100 * scoreOfPlayer + 10 * reSuit(biggestCard) + biggestCard.getRank();
    }
}