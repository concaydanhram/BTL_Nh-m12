package deckofcards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck  {
    private ArrayList<Card> deck;
    private Random random = new Random();

    // Constructor
    public Deck() {
        this.deck = new ArrayList<Card>();
        String[] suit = {"C", "D", "H", "S"};
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                Card card = new Card(suit[i], rank[j]);
                deck.add(card);
            }
        }

        shuffleDeck(); // Xóa trộn bộ bài
    }


    // Phương thức xáo trộn bộ bài
    public void shuffleDeck() {
        Collections.shuffle(deck);
        for (int i = 0; i < deck.size(); i++) {
            deck.get(i).setCardNumber(i+1);
        }

       System.out.println("Affter shuffleDeck");// In ra bộ bài sau khi xáo trộn
       System.out.println(deck);
    }

    // Lấy ra 1 quân bìa ở trên cùng bộ bài
    public Card removeCard() {
        return  deck.remove(deck.size() - 1);
    }
}
