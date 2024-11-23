package gamecardthirteens;

import java.util.ArrayList;
import java.util.Scanner;

public class ThirteenS extends RulesOfThirteenS {

    private ArrayList<CardOfThirteenS> cardPreTurn = new ArrayList<>();

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

    public void turnOfGame(){
        int index = 1;
        while (endOfGame() == null) {
            System.out.println("- Turn " + index + ":");
            for (int i = 0; i < numberOfPlayer; i++) {
                playersThirteenS.get(i).printCardInHand();
                System.out.println(playersThirteenS.get(i).getNameOfPlayer() + " invites to choose: ");
                String getSelection;
                boolean check = false;
                while (!check){
                    System.out.println("Choose 'Skip' or 'Sort' or 'Play cards'");
                    getSelection = scanner.nextLine();
                    if(getSelection.equals("Skip")){
                        break;
                    }
                    if(getSelection.equals("Sort")){
                        playersThirteenS.get(i).sortCardsInHand();
                        playersThirteenS.get(i).printCardInHand();
                    }
                    if(getSelection.equals("Play cards")){
                        while (true){
                            ArrayList<CardOfThirteenS> cards = new ArrayList<>();
                            System.out.println("Select card (enter in format Rank-Suit, enter 'Play' to play cards)");
                            String selectedCard;
                            while (true){
                                selectedCard = scanner.nextLine();
                                if(selectedCard.equals("Play")){
                                    break;
                                }
                                String[] rankandsuit = selectedCard.split("-");
                                CardOfThirteenS card = new CardOfThirteenS(rankandsuit[0], rankandsuit[1]);
                                cards.add(card);
                            }
                            if(checkCardsDrop(cards, cardPreTurn)) {
                                System.out.print(playersThirteenS.get(i).getNameOfPlayer() + " plays cards: ");
                                for(CardOfThirteenS card : cards){
                                    System.out.print(card.printRank() + "-" + card.printSuit() + " ");
                                    playersThirteenS.get(i).dropCard(card);
                                }
                                System.out.println();
                                playersThirteenS.get(i).printCardInHand();
                                this.cardPreTurn = cards;
                                check = true;
                                break;
                            }
                            else System.out.println("Invalid, please select again!");
                        }
                    }
                }
            }
            index++;
        }
        System.out.println(endOfGame().getNameOfPlayer() + "wins the game!");
    }

    private final Scanner scanner = new Scanner(System.in);

}