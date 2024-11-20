package gamecardbaccarat;

import deckofcards.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class Baccarat {
    public int numberOfPlayer;
    private DeckOfBaccarat deckOfBaccarat = new DeckOfBaccarat();
    private ArrayList<PlayerBaccarat> playersBaccarat = new ArrayList<PlayerBaccarat>();
    private Scanner scanner = new Scanner(System.in);

    public void setNumberOfPlayer() {
        System.out.println("Hay nhap vao so luong nguoi choi: ");
        int numberOfPersons = scanner.nextInt();
        while (numberOfPersons < 2 || numberOfPersons >4 ) {
            System.out.println("Hay nhap vao so luong nguoi choi tu 2 toi 4! ");
            numberOfPersons = scanner.nextInt();
            scanner.nextLine();
        };
        this.numberOfPlayer = numberOfPersons;
    }

    public void addPlayer(){
        for(int i = 0; i < numberOfPlayer; i++){
            System.out.print("Nhap ten nguoi choi " + (i + 1) + ": ");
            String name = scanner.nextLine();  // Nhập tên người chơi
            ArrayList<Card> ListCard = new ArrayList<Card>();
            PlayerBaccarat person = new PlayerBaccarat();
            person.setNameOfPlayer(name);
            person.setCardsInHand(ListCard);
            playersBaccarat.add(person);
        }
    }

    public void printCardsOfPlayer() {
        for (int i = 0; i < numberOfPlayer; i++) {
            PlayerBaccarat player = playersBaccarat.get(i);
            System.out.println(player.getNameOfPlayer() + " has the following cards:");

            // Lấy danh sách các lá bài của người chơi và in chúng ra
            ArrayList<Card> cardsInHand = player.getCardsInHand();
            int totalPoints = 0;

            // Hiển thị các lá bài
            for (Card card : cardsInHand) {
                System.out.println(card.toString());
            }

            // Hiển thị tổng điểm của người chơi
            System.out.println("Total points: " + (player.getScoreOfPlayer()));

        }
    }

    public void dealCard(){

        deckOfBaccarat.shuffleDeck();
        for(int i = 0; i < 3; ++i){
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