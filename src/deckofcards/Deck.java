package deckofcards;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Deck<T> {
	protected ArrayList<T> deck;
	protected Image backOfCard;

	// Phương thức xáo trộn bộ bài
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	// Lấy ra 1 quân bài ở trên cùng bộ bài
	public T getCardTop() {
		return deck.remove(deck.size() - 1);
	}
}