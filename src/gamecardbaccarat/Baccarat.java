package gamecardbaccarat;

import deckofcards.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class Baccarat {
    public int numberOfPlayer;
    private DeckOfBaccarat deckOfBaccarat = new DeckOfBaccarat();
    private ArrayList<PlayerBaccarat> playersBaccarat = new ArrayList<PlayerBaccarat>();
    private Scanner scanner = new Scanner(System.in);

    public void setNumberOfPlayer(int numberOfPersons) {
        if(numberOfPersons < 2) return;
        this.numberOfPlayer = numberOfPersons;
    }

    public void addPlayer(){
        for(int i = 0; i < numberOfPlayer; i++){
            String name = "Bien";
            ArrayList<Card> ListCard = new ArrayList<Card>();
            PlayerBaccarat person = new PlayerBaccarat();
            person.setNameOfPlayer(name);
            person.setCardsInHand(ListCard);
            playersBaccarat.add(person);
        }
    }

    public void printCardsOfPlayer(){
        for(int i = 0; i < numberOfPlayer; i++){
            System.out.println(playersBaccarat.get(i).getNameOfPlayer());
        }
    }

    public void dealCard(){
        deckOfBaccarat.shuffleDeck();
        for(int i = 0; i < 4; ++i){
            for(int j = 0; j < numberOfPlayer; ++j){
                playersBaccarat.get(j).addCard(deckOfBaccarat.getCardTop());
            }
        }
    }

    public void winnerBaccarat(){
        int index = 0;
        int maxPoint = 0;
        for(int i = 0; i < numberOfPlayer; i++){
            int point = playersBaccarat.get(i).getScoreOfPlayer();
            if(point > maxPoint){
                maxPoint = point;
                index = i;
            }
        }
        System.out.println(playersBaccarat.get(index).getNameOfPlayer() + " wins!");
    }
}