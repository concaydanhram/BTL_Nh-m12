import deckofcards.Deck;
import playerofgame.Player;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        // Test
        Deck deck = new Deck(); // Tạo 1 bộ bài mới đã xáo trộn
        // Tạo 1 danh sách người chơi
        ArrayList<Player> listPlayer = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Player player = new Player("Player" + (i+1));
            listPlayer.add(player);
        }

        // Chia 3 lá bài cho 4 người chơi
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                listPlayer.get(j).addCardOfPlayer(deck.removeCard());
            }
        }

        // In ra Người chơi cùng các lá bài của họ
        System.out.println(listPlayer);
 }
}
