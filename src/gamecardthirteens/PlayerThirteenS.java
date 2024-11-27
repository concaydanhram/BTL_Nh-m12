package gamecardthirteens;

import playerofgame.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PlayerThirteenS extends Player {
	protected String getSelection;
	protected String listCardPlayed;
	private RulesOfThirteenS rules = new RulesOfThirteenS();

	public PlayerThirteenS(String name) {
		ArrayList<CardOfThirteenS> cards = new ArrayList<>();
		super(name, cards);
	}

	public String getSelection(ArrayList<CardOfThirteenS> cardsPreTurn) {
		return getSelection;
	}

	public void setSelection() {
		this.getSelection = scanner.nextLine();
	}

	public String getListCardPlayed() {
		return listCardPlayed;
	}

	public void setListCardPlayed() {
		this.listCardPlayed = scanner.nextLine();
	}

	public void sortCardsInHand() {
		super.cardsInHand = rules.sortCards(super.cardsInHand);
	}

	private final Scanner scanner = new Scanner(System.in);
}
