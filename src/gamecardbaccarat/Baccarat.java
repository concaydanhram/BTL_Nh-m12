package gamecardbaccarat;

import java.util.ArrayList;
import java.util.Scanner;

public class Baccarat {
    private int numberOfPlayer;
    private int moneyPlayer;
    private DeckOfBaccarat deckOfBaccarat = new DeckOfBaccarat();
    private ArrayList<PlayerBaccarat> playersBaccarat = new ArrayList<PlayerBaccarat>();

    // Khỏi tạo Constructor: khi khởi tạo 1 đối tượng Baccarat mới sẽ chạy luôn chương trình:
    public Baccarat() {
        setNumberOfPlayer();
        setMoney();
        addPlayer();
        dealCard();
        winnerBaccarat();
        printPlayerInformation();
    }

    // Lấy số lượng người chơi
    public void setNumberOfPlayer() {
        int numberOfPersons ;
        do {
            System.out.println("Enter number of players: ");
            numberOfPersons = scanner.nextInt();
            scanner.nextLine();
        }while (numberOfPersons < 2 );
        this.numberOfPlayer = numberOfPersons;
    }

    public void setMoney(){
        System.out.println("Enter each player's starting amount ($): ");
        int money = scanner.nextInt();
        scanner.nextLine();
        this.moneyPlayer = money;
    }

    // Thêm số người chơi vào game
    public void addPlayer(){
        for(int i = 0; i < numberOfPlayer; i++){
            System.out.println("Player " + (i + 1) + ": ");
            String name = scanner.nextLine();  // Nhập tên người chơi
            PlayerBaccarat person = new PlayerBaccarat();
            person.setNameOfPlayer(name);
            person.setMoneyPlayer(this.moneyPlayer);
            playersBaccarat.add(person);
        }
    }

    // Chia bài cho người chơi
    public void dealCard(){
        deckOfBaccarat.shuffleDeck();
        for(int i = 0; i < 3; ++i){
            System.out.println("Deal cards in turn " + (i + 1) + ": ");
            for(int j = 0; j < numberOfPlayer; ++j){
                playersBaccarat.get(j).addCard(deckOfBaccarat.getCardTop());
                playersBaccarat.get(j).printCardInHand();
            }
        }
    }

    // In ra người thắng
    public void winnerBaccarat(){
        int index = 0;
        int maxPoint = 0;
        for(int i = 0; i < numberOfPlayer; i++) {
            int point = playersBaccarat.get(i).getScoreOfPlayer();
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

    public void printPlayerInformation(){
        for(int i = 0; i < numberOfPlayer; ++i){
            playersBaccarat.get(i).printPlayer();
        }
    }

    private Scanner scanner = new Scanner(System.in);
}