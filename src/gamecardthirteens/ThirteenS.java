package gamecardthirteens;

import java.util.Scanner;

public class ThirteenS extends RulesOfThirteenS {

    public ThirteenS() {
        setNumberOfPlayer();
        addPlayer();
        dealCard();
    }

    public void setNumberOfPlayer() {
        int numberOfPersons ;
        do {
            System.out.print("Enter number of players: ");
            numberOfPersons = scanner.nextInt();
            scanner.nextLine();
        }while (numberOfPersons < 2);
        this.numberOfPlayer = numberOfPersons;
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

    private void sortCardsInHandPlayer(){
        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("- Do you want to sort the cards in hand, " + playersThirteenS.get(i).getNameOfPlayer() + "? (Y/N)");
            String choose = scanner.nextLine();
            if(choose.equalsIgnoreCase("Y") || choose.equalsIgnoreCase("y")
                    || choose.equalsIgnoreCase("yes") || choose.equalsIgnoreCase("Yes")){
                playersThirteenS.get(i).sortCardsInHand();
            }
            playersThirteenS.get(i).printCardInHand();
            System.out.println();
        }
    }

    private void reverseCardsInHandPlayer(){
    }

    public void turnOfGame(){
    }

    private final Scanner scanner = new Scanner(System.in);

}