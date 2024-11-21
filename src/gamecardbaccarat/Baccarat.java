package gamecardbaccarat;

import deckofcards.Card;
import java.util.ArrayList;
import java.util.Scanner;

public class Baccarat {
    public int numberOfPlayer;
    private DeckOfBaccarat deckOfBaccarat = new DeckOfBaccarat();
    private ArrayList<PlayerBaccarat> playersBaccarat = new ArrayList<PlayerBaccarat>();

    // Khỏi tạo Constructor: khi khởi tạo 1 đối tượng Baccarat mới sẽ chạy luôn chương trình:
    public Baccarat() {
        setNumberOfPlayer();
        addPlayer();
        dealCard();
        winnerBaccarat();
    }

    // Lấy số lượng người chơi
    public void setNumberOfPlayer() {
        int numberOfPersons ;
        do {
            System.out.println("Số lượng người chơi: ");
            numberOfPersons = scanner.nextInt();
            scanner.nextLine();
        }while (numberOfPersons < 2 );
        this.numberOfPlayer = numberOfPersons;
    }

    // Thêm số người chơi vào game
    public void addPlayer(){
        for(int i = 0; i < numberOfPlayer; i++){
            System.out.println("Người chơi thứ " + (i + 1) + ": ");
            String name = scanner.nextLine();  // Nhập tên người chơi
            PlayerBaccarat person = new PlayerBaccarat();
            person.setNameOfPlayer(name);
            playersBaccarat.add(person);
        }
    }

    // Chia bài cho người chơi
    public void dealCard(){
        deckOfBaccarat.shuffleDeck();
        for(int i = 0; i < 3; ++i){
            System.out.println("Chia bài lượt thứ " + (i + 1) + ": ");
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
        System.out.println("----------------------------------------");
        System.out.println(playersBaccarat.get(index).getNameOfPlayer() + " wins!");
    }

    private Scanner scanner = new Scanner(System.in);
}