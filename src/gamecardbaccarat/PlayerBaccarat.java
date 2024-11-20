package gamecardbaccarat;

import playerofgame.Player;

public class PlayerBaccarat extends Player {
    private int scoreOfPlayer = 0;

    private void addScore() {
        for (int i = 0; i < cardsInHand.size(); ++i)
            this.scoreOfPlayer += cardsInHand.get(i).getRank();
        scoreOfPlayer %= 10;
    };

    public int getScoreOfPlayer() {
        return scoreOfPlayer;
    }

    @Override
    public String toString(){
        return "nameOfPlayer='" + nameOfPlayer + '\'' + ", scoreOfPlayer=" + scoreOfPlayer + "\n" + ", cardOfPlayer=" + cardsInHand + '}' + "\n";
    }
}