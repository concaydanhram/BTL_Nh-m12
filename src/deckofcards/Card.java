package deckofcards;

public class Card {
    private String suit;
    private String rank;

//      ♦ Diamonds : Chất rô
//      ♥ Hearts : Chất cơ
//      ♣ Clubs : Chất nhép
//      ♠ Spade : Chất bích

    // Constructor
    public Card(){
    }

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getter and setter

    public int getSuit() {
        if(this.suit.equals("H")) return 4;
        if(this.suit.equals("D")) return 3;
        if(this.suit.equals("C")) return 2;
        return 1;
    }

    // Đổi rank thành Int trả về rank của quân bài
    public int getRank(){
        if(this.rank.equals("A"))
            return 1;
        if(this.rank.equals("J"))
            return 11;
        if(this.rank.equals("Q"))
            return 12;
        if(this.rank.equals("K"))
            return 13;
        return Integer.parseInt(rank);
    }

    // In ra lá bài
    @Override
    public String toString(){
        return  rank + '-' + suit;
    }
}