package deckofcards;
import java.util.ArrayList;
import java.util.Random;

public class Deck extends Card {
    private ArrayList<Card> deck;
    private Random random = new Random();

    Card A_H = new Card(1, 4, 14);
    Card A_D = new Card(1, 3, 14);
    Card A_C = new Card(1, 2, 14);
    Card A_S = new Card(1, 1, 14);
}
