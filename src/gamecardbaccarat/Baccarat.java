package gamecardbaccarat;

import java.util.ArrayList;
import java.util.Scanner;

public class Baccarat {
    public int numberOfPlayer;
    private DeckOfBaccarat deckOfBaccarat = new DeckOfBaccarat();
    private ArrayList<PlayerBaccarat> playersBaccarat;
    private Scanner scanner = new Scanner(System.in);

    public Baccarat() {
    }

    public void setNumberOfPlayer() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = Integer.parseInt(scanner.nextLine());
        scanner.close();
        if(numberOfPersons < 2) return;
        this.numberOfPlayer = numberOfPersons;
    }

    public void addPlayer(){
        for(int i = 0; i < numberOfPlayer; i++){
            String name = scanner.nextLine();
            PlayerBaccarat person = new PlayerBaccarat();
            person.setNameOfPlayer(name);
            playersBaccarat.add(person);
        }
    }

    public void printCardsOfPlayer(){
        for(int i = 0; i < numberOfPlayer; i++){
            playersBaccarat.get(i).toString();
        }
    }

    public void dealCard(){
        deckOfBaccarat.shuffleDeck();
        for(int i = 0; i < 4; ++i){
            for(int j = 0; j < numberOfPlayer; j++){
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