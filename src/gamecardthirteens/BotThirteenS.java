package gamecardthirteens;

import java.util.ArrayList;

public class BotThirteenS extends PlayerThirteenS {
	private RulesOfThirteenS rules = new RulesOfThirteenS();
	private boolean checkSort = false;

	public BotThirteenS(String name) {
		super(name);
	}

	@Override
	public void setGetSelection() {

	}

	@Override
	public String getGetSelection() {
		if (!checkSort) {
			checkSort = true;
			return "Sort";
		}
		return "Skip";
	}

	@Override
	public void setListCardPlayed() {

	}

	@Override
	public String getListCardPlayed() {
		return null;
	}

	public boolean selectionOfBot(ArrayList<CardOfThirteenS> cardsPreTurn) {
		if (cardsPreTurn.isEmpty())
            return true;
		int size = cardsPreTurn.size();
		String typeCardsPreTurn = rules.typeOfCards(cardsPreTurn);
		return false;
	}
}