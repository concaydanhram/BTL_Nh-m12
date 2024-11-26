package gamecardthirteens;

import java.util.ArrayList;
import java.util.Scanner;

public class ThirteenS extends RulesOfThirteenS {

    private ArrayList<CardOfThirteenS> cardPreTurn = new ArrayList<>();
    private boolean[] checkTurn;
    private boolean checkSkip = false;

    public ThirteenS() {
        setNumberOfPlayer();
        addPlayer();
        dealCard();
        if(checkWinner() != null){
            System.out.println(checkWinner().getNameOfPlayer() + " wins the game!");
        }
        else{
            turnOfGame();
        }
    }

    public void setNumberOfPlayer() {
        int numberOfPersons ;
        do {
            // Kiểm tra nhập vào đúng định dạng int
            while (true){
                System.out.print("Enter number of players: ");
                if (scanner.hasNextInt()) {
                    int input = scanner.nextInt();
                    scanner.nextLine();
                    numberOfPersons = input;
                    break;
                } else {
                    System.out.println("Invalid format. Please enter an integer.");
                    scanner.nextLine();
                }
            }
        }while (numberOfPersons < 2);
        super.numberOfPlayer = numberOfPersons;
        checkTurn = new boolean[numberOfPlayer];
    }

    public void addPlayer(){
        for(int i = 0; i < numberOfPlayer; i++){
            System.out.print("Player " + (i + 1) + ": ");
            String name = scanner.nextLine();  // Nhập tên người chơi
            PlayerThirteenS person = new PlayerThirteenS();
            person.setNameOfPlayer(name);
            playersThirteenS.add(person);
        }
    }

    protected void dealCard(){
        deckOfThirteenS.shuffleDeck();
        for(int i = 0; i < 13; ++i){
            System.out.println("- Deal cards in turn " + (i + 1) + ": ");
            for(int j = 0; j < numberOfPlayer; ++j){
                CardOfThirteenS card = (CardOfThirteenS) deckOfThirteenS.getCardTop();
                playersThirteenS.get(j).addCard(card);
                playersThirteenS.get(j).printCardInHand();
            }
        }
    }

    public void resetTurn() {
        for(int i = 0; i < numberOfPlayer; ++i){
            checkTurn[i] = true;
        }
    }

    public boolean checkEndTurn(){
        int counter = 0;
        for(int i = 0; i < numberOfPlayer; ++i){
            if(checkTurn[i]){
                counter++;
            }
        }
        return counter == 1;
    }

    public boolean playCards(PlayerThirteenS player){
        ArrayList<CardOfThirteenS> cards = new ArrayList<>();
        System.out.println("Select card (enter in format Rank-Suit, write on one line, separated by spaces) to play or enter 'Sort' to sort cards in hand or enter 'Skip' to skip turn:");
        String listCardPlayed = scanner.nextLine();
        if(listCardPlayed.equals("Skip")){
            checkSkip = true;
            return true;
        }
        if(listCardPlayed.equals("Sort")){
            player.sortCardsInHand();
        }
        for(String selectedCard : listCardPlayed.split(" ")){
            String[] rankandsuit = selectedCard.split("-");
            if(rankandsuit.length != 2){
                System.out.println("Invalid, please select again!");
                return false;
            }
            CardOfThirteenS card = new CardOfThirteenS(rankandsuit[0], rankandsuit[1]);
            cards.add(card);
        }
        if(checkCardsDrop(cards, cardPreTurn)) {
            System.out.print(player.getNameOfPlayer() + " plays cards: ");
            for(CardOfThirteenS card : cards){
                System.out.print(card.printRank() + "-" + card.printSuit() + " ");
                player.dropCard(card);
            }
            System.out.println();
            player.printCardInHand();
            this.cardPreTurn = cards;
            return true;
        }
        System.out.println("The cards you played are smaller!");
        return false;
    }

    public void turnOfGame(){
        int index = 1;
        resetTurn();
        System.out.println("- Turn" + index + ":");
        while (endOfGame() == null) {
            for (int i = 0; i < numberOfPlayer; i++) {
                if(checkTurn[i]){
                    if(checkEndTurn()){
                        index++;
                        System.out.println("-Turn " + index + " :");
                        resetTurn();
                        cardPreTurn.clear();
                    }
                    playersThirteenS.get(i).printCardInHand();
                    System.out.println(playersThirteenS.get(i).getNameOfPlayer() + " invites to choose: ");
                    String getSelection;
                    while (true){
                        System.out.println("Choose 'Skip' or 'Sort' or 'Play'");
                        getSelection = scanner.nextLine();
                        if(getSelection.equals("Skip")){
                            checkTurn[i] = false;
                            break;
                        }
                        if(getSelection.equals("Sort")){
                            playersThirteenS.get(i).sortCardsInHand();
                            playersThirteenS.get(i).printCardInHand();
                        }
                        if(getSelection.equals("Play")){
                            boolean check = false;
                            while (!check){
                                check = playCards(playersThirteenS.get(i));
                                if(checkSkip) {
                                    checkTurn[i] = false;
                                    checkSkip = false;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(endOfGame().getNameOfPlayer() + "wins the game!");
    }

    private final Scanner scanner = new Scanner(System.in);

}