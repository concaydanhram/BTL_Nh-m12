package playerofgame;

import deckofcards.Card;

import java.util.ArrayList;

public class Player{
    private String nameOfPlayer;
    private int scoreOfPlayer = 0;
    private ArrayList<Card> cardOfPlayer  = new ArrayList<Card>();

    public Player(){
    }

    public Player(String nameOfPlayer){
        this.nameOfPlayer = nameOfPlayer;
    }

    public String getNameOfPlayer(){
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer){
        this.nameOfPlayer = nameOfPlayer;
    }

    public int getScoreOfPlayer(){
        return scoreOfPlayer;
    }

    public void addScoreOfPlayer(int rankOfCard){
        this.scoreOfPlayer +=rankOfCard;
    }

    public ArrayList<Card> getCardOfPlayer(){
        return cardOfPlayer;
    }

    public void addCardOfPlayer(Card card){
        cardOfPlayer.add(card);
        addScoreOfPlayer(card.getRank());
    }

    @Override
    public String toString(){
        return "nameOfPlayer='" + nameOfPlayer + '\'' + ", scoreOfPlayer=" + scoreOfPlayer + "\n" + ", cardOfPlayer=" + cardOfPlayer + '}' + "\n";
    }
}
