package deckofcards;

public class Card {
    private int cardNumber;
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
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    // Đổi rank thành Int trả về rank của quân bài
    public int getRank()        {
        if ("AJQK".contains(rank)) {
            if ( rank.equals("A"))
                return 1;
            else return 10;
        }
        else return Integer.parseInt(rank);
    }


    // In ra lá bài
    @Override
    public String toString() {
        return "[cardNumber= " + cardNumber +
                ", suit= '" + suit + '\'' +
                ", rank= '" + rank + ']' + "\n"
                ;
    }
}