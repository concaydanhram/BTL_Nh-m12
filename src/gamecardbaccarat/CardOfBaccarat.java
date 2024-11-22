package gamecardbaccarat;

import deckofcards.Card;

public class CardOfBaccarat extends Card {
    CardOfBaccarat(String rank, String suit) {
        super(rank, suit);
    }

    public int getRank(){
        if(this.rank.equals("A"))
            return 11;
        return Integer.parseInt(rank);
    }

    public int getSuit(){
        if(this.suit.equals("D")) return 4;
        if(this.suit.equals("H")) return 3;
        if(this.suit.equals("S")) return 2;
        return 1;
    }
}