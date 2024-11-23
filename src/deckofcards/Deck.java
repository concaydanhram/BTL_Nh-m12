package deckofcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Deck <T> {
    protected ArrayList<T> deck;

    // Phương thức xáo trộn bộ bài
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    // Lấy ra 1 quân bìa ở trên cùng bộ bài
    public T getCardTop() {
        return deck.remove(deck.size() - 1);
    }
}
