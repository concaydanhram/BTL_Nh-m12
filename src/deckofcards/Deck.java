package deckofcards;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck  {

    private ArrayList<Card> deck;

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

        shuffleDeck(); // Xáo trộn bộ bài
    }


    // Phương thức xáo trộn bộ bài
    public void shuffleDeck() {
        for (int i = deck.size() - 1; i > 0; i--) {
            int j = ThreadLocalRandom.current().nextInt(i + 1); // Sử dụng ThreadLocalRandom
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }

        for (int i = 0; i < deck.size(); i++) {
            deck.get(i).setCardNumber(i + 1);
        }
    }
    // Lấy ra 1 quân bìa ở trên cùng bộ bài
    public Card removeCard() {
        return  deck.remove(deck.size() - 1);
    }
}
