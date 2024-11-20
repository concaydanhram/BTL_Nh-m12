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
        System.out.print("Nhập số lượng người chơi (ít nhất 2 người): ");
        numberOfPersons = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line sau khi nhập số nguyên

        if (numberOfPersons < 2) {
            System.out.println("Số lượng người chơi phải lớn hơn hoặc bằng 2.");
            return;
        }
        this.numberOfPlayer = numberOfPersons; // Gán giá trị cho số người chơi
    }

    public void addPlayer(){
        // Duyệt qua từng người chơi và yêu cầu nhập tên
        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.print("Nhập tên cho người chơi " + (i + 1) + ": ");
            String name = scanner.nextLine();

            // Khởi tạo danh sách thẻ bài cho người chơi
            ArrayList<Card> listCard = new ArrayList<Card>();

            // Khởi tạo đối tượng người chơi và gán tên và danh sách thẻ bài
            PlayerBaccarat player = new PlayerBaccarat();
            player.setNameOfPlayer(name);
            player.setCardsInHand(listCard);

            // Thêm người chơi vào danh sách
            playersBaccarat.add(player);
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
        System.out.println(playersBaccarat.get(index).getNameOfPlayer() + " chiến thắng với " + maxPoint + " điểm!");
    }
}