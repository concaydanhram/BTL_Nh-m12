package gamecardbaccarat;

import deckofcards.Deck;

import java.util.ArrayList;

public class DeckOfBaccarat extends Deck {

	// Constructor : Khởi tạo bộ bài Deck của game Baccarat
	// Note: Loại bỏ các lá J, Q, K
	public DeckOfBaccarat() {
		this.deck = new ArrayList<CardOfBaccarat>();
		String[] suit = {"C", "D", "H", "S"};
		String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9"};
		for (int i = 0; i < rank.length; ++i) {
			for (int j = 0; j < 4; ++j) {
				CardOfBaccarat card = new CardOfBaccarat(rank[i], suit[j]);
				deck.add(card);
			}
		}
	}
}