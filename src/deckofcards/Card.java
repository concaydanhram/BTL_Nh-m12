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

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getter and setter

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
        return "suit= '" + suit + '\'' + ", rank= '" + rank + ']' + "\n";
    }
}