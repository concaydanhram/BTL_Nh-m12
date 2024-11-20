import gamecardbaccarat.Baccarat;

public class Main{
    public static void main(String[] args) {
        Baccarat baccarat = new Baccarat();
        baccarat.setNumberOfPlayer();
        baccarat.addPlayer();
        baccarat.dealCard();
        baccarat.printCardsOfPlayer();
        baccarat.winnerBaccarat();
    }
}
