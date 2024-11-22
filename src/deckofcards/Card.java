package deckofcards;

public class Card {
    protected String suit;
    protected String rank;

//      ♦ Diamonds : Chất rô
//      ♥ Hearts : Chất cơ
//      ♣ Clubs : Chất nhép
//      ♠ Spade : Chất bích

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
}