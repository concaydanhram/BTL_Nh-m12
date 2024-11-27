package gamecardthirteens;

import playerofgame.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PlayerThirteenS extends Player {
    protected String getSelection;
    protected String listCardPlayed;

    public PlayerThirteenS(String name) {
        ArrayList<CardOfThirteenS> cards = new ArrayList<>();
        super(name, cards);
    }

    public String getGetSelection() {
        return getSelection;
    }

    public void setGetSelection() {
        this.getSelection = scanner.nextLine();
    }

    public String getListCardPlayed() {
        return listCardPlayed;
    }

    public void setListCardPlayed() {
        this.listCardPlayed = scanner.nextLine();
    }

    // Lặp code
    public void sortCardsInHand(){
        super.cardsInHand.sort(new Comparator<CardOfThirteenS>() {
            @Override
            public int compare(CardOfThirteenS card1, CardOfThirteenS card2) {
                return card1.compareCard(card2);
            }
        });
    }

    private final Scanner scanner = new Scanner(System.in);
}
