package gamecardbaccarat;

import deckofcards.Deck;
import java.util.ArrayList;

public class DeckOfBaccarat extends Deck {
    public DeckOfBaccarat() {
        this.deck = new ArrayList<CardOfBaccarat>();
        String[] suit = {"C", "D", "H", "S"};
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < rank.length; ++i) {
            for (int j = 0; j < 4; ++j) {
                CardOfBaccarat card = new CardOfBaccarat(rank[i], suit[j]);
                deck.add(card);
            }
        }
    }
}