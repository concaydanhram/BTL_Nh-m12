package deckofcards;

import gamecardthirteens.CardOfThirteenS;

import java.util.Objects;

public class Card {
    protected String suit;// Chât của lá bài
    protected String rank;// Điểm của lá bài

//      ♥ H (Hearts) : Chất cơ
//      ♦ D (Diamonds) : Chất rô
//      ♣ C (Clubs) : Chất nhép
//      ♠ S (Spade) : Chất bích

    // Constructor
    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    // In ra lá bài
    @Override
    public String toString(){
        return  rank + '-' + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false; CardOfThirteenS card = (CardOfThirteenS) obj;
        return rank.equals(card.rank) && suit.equals(card.suit);
    }
    @Override
    public int hashCode() {
        Objects Objects = null;
        return Objects.hash(rank, suit);
    }

}