package gamecardbaccarat;

import deckofcards.Deck;

import java.util.ArrayList;

public class DeckOfBaccarat extends Deck<CardOfBaccarat> {

	// Constructor : Khởi tạo bộ bài Deck của game Baccarat
	public DeckOfBaccarat() {
		initializeDeck();
	}

	// Phương thức khởi tạo lại bộ bài
	public void initializeDeck() {
		this.deck = new ArrayList<>();
		String[] suit = {"C", "D", "H", "S"};
		String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9"};
		for (String r : rank) {
			for (String s : suit) {
				CardOfBaccarat card = new CardOfBaccarat(r, s);
				deck.add(card);
			}
		}
	}

	// Làm mới bộ bài
	public void resetDeck() {
		initializeDeck();
		shuffleDeck();
	}
}
