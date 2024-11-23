package gamecardthirteens;

import deckofcards.Card;

public class CardOfThirteenS extends Card {
    CardOfThirteenS(String rank, String suit) {
        super(rank, suit);
    }

    public int getRank(){
        if(this.rank.equals("2"))
            return 15;
        if(this.rank.equals("A"))
            return 14;
        if(this.rank.equals("J"))
            return 11;
        if(this.rank.equals("Q"))
            return 12;
        if(this.rank.equals("K"))
            return 13;
        return Integer.parseInt(rank);
    }

    public int getSuit(){
        if(this.suit.equals("H")) return 4;
        if(this.suit.equals("D")) return 3;
        if(this.suit.equals("C")) return 2;
        return 1;
    }

    public String printRank(){
        return this.rank;
    }

    public String printSuit(){
        return this.suit;
    }
}