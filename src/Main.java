import gamecardbaccarat.Baccarat;

public class Main{
    public static void main(String[] args) {
        Baccarat baccarat = new Baccarat();
        baccarat.setNumberOfPlayer(3);
        baccarat.addPlayer();
        baccarat.dealCard();
        baccarat.printCardsOfPlayer();
        baccarat.winnerBaccarat();
    }
}
