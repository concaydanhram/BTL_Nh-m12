package deckofcards;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck <T> {
    protected ArrayList<T> deck;
    // Phương thức xáo trộn bộ bài
    public void shuffleDeck() {
        for (int i = deck.size() - 1; i > 0; i--) {
            int j = ThreadLocalRandom.current().nextInt(i + 1); // Sử dụng ThreadLocalRandom
            T temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    // Lấy ra 1 quân bìa ở trên cùng bộ bài
    public T getCardTop() {
        return deck.remove(deck.size() - 1);
    }
}
