package gamecardbaccarat;

import java.util.ArrayList;

public class Baccarat {
    private static Baccarat instance;
    private int numberOfPlayer;
    private DeckOfBaccarat deckOfBaccarat = new DeckOfBaccarat();
    private ArrayList<PlayerBaccarat> playersBaccarat = new ArrayList<>();

    public static Baccarat getInstance() {
        if (instance == null) {
            instance = new Baccarat();
        }
        return instance;
    }

    // Thiết lập số lượng người chơi
    public void setNumberOfPlayer(int a) {
        numberOfPlayer = a;
    }

    // Thêm người chơi vào game
    public void addPlayer(int startingMoney) {
        for (int i = 1; i <= numberOfPlayer; i++) {
            String playerName = "Player" + i;
            PlayerBaccarat person = new PlayerBaccarat();
            person.setNameOfPlayer(playerName);
            person.setMoneyPlayer(startingMoney); // Gán tiền khởi điểm cho mỗi người chơi
            playersBaccarat.add(person);
        }
    }

    // Lấy danh sách người chơi
    public ArrayList<PlayerBaccarat> getPlayersBaccarat() {
        return playersBaccarat;
    }

    // Chia bài cho người chơi
    public void dealCard() {
        for (PlayerBaccarat player : playersBaccarat) {
            player.clearCardsInHand();
        }
        deckOfBaccarat.shuffleDeck();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < numberOfPlayer; ++j) {
                playersBaccarat.get(j).addCard(deckOfBaccarat.getCardTop());
                playersBaccarat.get(j).printCardInHand();
            }
        }
        deckOfBaccarat.resetDeck();
    }


    // Làm mới trò chơi
    public void resetGame() {
        // Khởi tạo lại bộ bài
        deckOfBaccarat.resetDeck();

        // Làm sạch bài trong tay mỗi người chơi
        for (PlayerBaccarat player : playersBaccarat) {
            player.clearCardsInHand();
        }
    }

    // Lấy số lượng người chơi
    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

}
