package gamecardbaccarat;

import deckofcards.Card;

public class CardOfBaccarat extends Card {

	// Constructor lá bài game Baccarat
	CardOfBaccarat(String rank, String suit) {
		super(rank, suit);
	}

	// Get Rank lá bài game Baccarat:
	// Note: Lá A đc gán Rank = 11;
	public int getRank() {
		if (this.rank.equals("A"))
			return 11;
		return Integer.parseInt(rank);
	}

	// Get Suit
	public int getSuit() {
		if (this.suit.equals("D"))
            return 4;
		if (this.suit.equals("H"))
            return 3;
		if (this.suit.equals("S"))
            return 2;
		return 1;
	}
}