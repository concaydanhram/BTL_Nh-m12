package gamecardthirteens;

import deckofcards.Card;

public class CardOfThirteenS extends Card {
	CardOfThirteenS(String rank, String suit) {
		super(rank, suit);
	}

	// Điểm cuả lá bài
	// Note: 2 -> A -> K -> Q -> J ...
	public int getRank() {
		if (this.rank.equals("2"))
			return 15;
		if (this.rank.equals("A"))
			return 14;
		if (this.rank.equals("K"))
			return 13;
		if (this.rank.equals("Q"))
			return 12;
		if (this.rank.equals("J"))
			return 11;
		return Integer.parseInt(rank);
	}

	// Chất của lá bài
	// Note: H -> D -> C -> S
	public int getSuit() {
		if (this.suit.equals("H"))
			return 4;
		if (this.suit.equals("D"))
			return 3;
		if (this.suit.equals("C"))
			return 2;
		return 1;
	}

	public String printRank() {
		return this.rank;
	}

	public String printSuit() {
		return this.suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CardOfThirteenS card = (CardOfThirteenS) obj;
		return rank.equals(card.rank) && suit.equals(card.suit);
	}

	public int compareCard(CardOfThirteenS other) {
		int rankComparison = Integer.compare(this.getRank(), other.getRank());
		if (rankComparison != 0)
			return rankComparison;
		return Integer.compare(this.getSuit(), other.getSuit());
	}
}