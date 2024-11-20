package gamecardbaccarat;
import deckofcards.Card;
import deckofcards.Deck;

import java.util.ArrayList;

public class DeckOfBaccarat extends Deck{
    @Override
    public void Deck(){
        this.deck = new ArrayList<Card>();
        String[] suit = {"C", "D", "H", "S"};
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                Card card = new Card(suit[i], rank[j]);
                deck.add(card);
            }
        }
    }
}
