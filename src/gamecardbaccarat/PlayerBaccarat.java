package gamecardbaccarat;

import playerofgame.Player;

public class PlayerBaccarat extends Player {
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

    protected boolean compareCard(CardOfBaccarat card1, CardOfBaccarat card2){
        if(card1.getSuit() > card2.getSuit()) return true;
        if(card1.getSuit() < card2.getSuit()) return false;
        return card1.getRank() > card2.getRank();
    }

    public CardOfBaccarat biggestCardInHand(){
        CardOfBaccarat card = (CardOfBaccarat) cardsInHand.getFirst();
        for(int i = 1; i < cardsInHand.size(); i++){
            CardOfBaccarat cardinhand = (CardOfBaccarat) cardsInHand.get(i);
            if(compareCard(cardinhand, card)){
                card = cardinhand;
            }
        }
        return card;
    }

    public void printPlayer(){
        System.out.println("Player " + this.getNameOfPlayer() + " has " + moneyPlayer + "$");
    }
}