package deckofcards;

import gamecardthirteens.CardOfThirteenS;
import javafx.scene.image.Image;

import java.util.Objects;

public class Card {
	protected String suit;// Chât của lá bài
	protected String rank;// Điểm của lá bài
	protected Image image;// Ảnh của lá bài

//      ♥ H (Hearts) : Chất cơ
//      ♦ D (Diamonds) : Chất rô
//      ♣ C (Clubs) : Chất nhép
//      ♠ S (Spade) : Chất bích

	// Constructor
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	// In ra lá bài
	@Override
	public String toString() {
		return rank + '-' + suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	public String getCardName() {
		return this.rank + "-" + this.suit;
	}
}