package gamecardbaccarat;

import java.util.ArrayList;
import playerofgame.Player;

public class PlayerBaccarat extends Player {
	private int moneyPlayer; // Số tiền của người chơi

	// Constructor
	public PlayerBaccarat() {
		ArrayList<CardOfBaccarat> cards = new ArrayList<>();
		super("Player", cards);
		this.moneyPlayer = 0;
	}

	// Thêm tiền cho người chơi
	public void addMoneyPlayer(int moneyPlayer) {
		this.moneyPlayer += moneyPlayer;
	}

	// Trừ tiền người chơi
	public void subtractMoneyPlayer(int moneyPlayer) {
		this.moneyPlayer -= moneyPlayer;
	}

	// Xóa tất cả bài trong tay
	public void clearCardsInHand() {
		cardsInHand.clear();
	}

	// Lấy danh sách bài trong tay dưới dạng chuỗi
	public ArrayList<String> getHandCards() {
		ArrayList<String> cardNames = new ArrayList<>();
		for (Object card : cardsInHand) {
			if (card instanceof CardOfBaccarat) {
				CardOfBaccarat baccaratCard = (CardOfBaccarat) card;
				String cardName = baccaratCard.getCardName(); // Gọi hàm lấy tên bài
				cardNames.add(cardName);
			}
		}
		return cardNames;
	}

	// Tìm lá bài cao nhất trong tay người chơi
	public CardOfBaccarat biggestCardInHand() {
		if (cardsInHand.isEmpty()) {
			return null; // Không có bài trong tay
		}
		CardOfBaccarat card = (CardOfBaccarat) cardsInHand.get(0);
		for (int i = 1; i < cardsInHand.size(); i++) {
			CardOfBaccarat cardInHand = (CardOfBaccarat) cardsInHand.get(i);
			if (compareCard(cardInHand, card)) {
				card = cardInHand;
			}
		}
		return card;
	}

	// So sánh hai lá bài
	protected boolean compareCard(CardOfBaccarat card1, CardOfBaccarat card2) {
		// So sánh theo chất
		if (card1.getSuit() > card2.getSuit()) {
			return true;
		}
		if (card1.getSuit() < card2.getSuit()) {
			return false;
		}
		// Nếu chất giống nhau, so sánh theo giá trị
		return card1.getRank() > card2.getRank();
	}

	// Getter và Setter cho tiền người chơi
	public int getMoneyPlayer() {
		return moneyPlayer;
	}

	public void setMoneyPlayer(int moneyPlayer) {
		this.moneyPlayer = moneyPlayer;
	}
}
