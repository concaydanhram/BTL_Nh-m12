package gamecardthirteens;

import java.util.ArrayList;

public class BotThirteenS extends PlayerThirteenS {
	private final RulesOfThirteenS rules = new RulesOfThirteenS();
	private boolean checkSort = false;
	private ArrayList<CardOfThirteenS> listCards =  new ArrayList<>();

	public BotThirteenS(String name) {
		super(name);
	}

	@Override
	public void setSelection() {

	}

	@Override
	public String getSelection(ArrayList<CardOfThirteenS> cardsPreTurn) {
		if (!checkSort) {
			checkSort = true;
			return "Sort";
		}
		if(!selectionOfBot(cardsPreTurn).isEmpty()) {
			listCards = selectionOfBot(cardsPreTurn);
			return "Play";
		}
		return "Skip";
	}

	@Override
	public void setListCardPlayed() {

	}

	@Override
	public String getListCardPlayed() {
		String played = "";
		for(CardOfThirteenS card : listCards) {
			played = played.concat(card.printRank()).concat("-").concat(card.printSuit()).concat(" ");
		}
		return played;
	}

	public ArrayList<CardOfThirteenS> selectionOfBot(ArrayList<CardOfThirteenS> cardsPreTurn) {
		ArrayList<CardOfThirteenS> listCardsPlayed = new ArrayList<>();
		if(cardsPreTurn.isEmpty()) {
			listCardsPlayed.add((CardOfThirteenS) cardsInHand.get(0));
			return listCardsPlayed;
		}
		String typeCardsPreTurn = rules.getTypeOfCards(cardsPreTurn);
		if(typeCardsPreTurn.equals("Once")) {
			for(Object card : cardsInHand) {
				listCardsPlayed.add((CardOfThirteenS) card);
				if(rules.checkCardsDrop(listCardsPlayed, cardsPreTurn))
					return listCardsPlayed;
				else listCardsPlayed.clear();
			}
			return listCardsPlayed;
		}
		if(typeCardsPreTurn.equals("Double")) {
			for(int i = 0; i < cardsInHand.size() - 1; i++) {
				for (int j = 0; j < 2; ++j) {
					listCardsPlayed.add((CardOfThirteenS) cardsInHand.get(i+j));
				}
				if(rules.checkCardsDrop(listCardsPlayed, cardsPreTurn))
					return listCardsPlayed;
				else listCardsPlayed.clear();
			}
			return listCardsPlayed;
		}
		if(typeCardsPreTurn.equals("Triple")) {
			for(int i = 0; i < cardsInHand.size() - 2; i++) {
				for (int j = 0; j < 3; ++j) {
				listCardsPlayed.add((CardOfThirteenS) cardsInHand.get(i+j));
				}
				if(rules.checkCardsDrop(listCardsPlayed, cardsPreTurn))
					return listCardsPlayed;
				else listCardsPlayed.clear();
			}
			return listCardsPlayed;
		}
		if(typeCardsPreTurn.equals("Four-Fold")) {
			for(int i = 0; i < cardsInHand.size() - 3; i++) {
				for (int j = 0; j < 4; ++j) {
					listCardsPlayed.add((CardOfThirteenS) cardsInHand.get(i+j));
				}
				if(rules.checkCardsDrop(listCardsPlayed, cardsPreTurn))
					return listCardsPlayed;
				else listCardsPlayed.clear();
			}
			return listCardsPlayed;
		}
		return listCardsPlayed;
	}
}