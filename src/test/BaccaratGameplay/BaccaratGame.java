package test.BaccaratGameplay;

import gamecardbaccarat.Baccarat;
import gamecardbaccarat.PlayerBaccarat;
import gamecardbaccarat.RulesOfBaccarat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BaccaratGame implements Initializable {

    @FXML private ImageView deckImage;

    @FXML private ImageView cardImageP1_1, cardImageP1_2, cardImageP1_3;
    @FXML private ImageView cardImageP2_1, cardImageP2_2, cardImageP2_3;
    @FXML private ImageView cardImageP3_1, cardImageP3_2, cardImageP3_3;
    @FXML private ImageView cardImageP4_1, cardImageP4_2, cardImageP4_3;

    // Labels to display player names and budgets
    @FXML private Label playerName1 = new Label("");
    @FXML private Label playerName2 = new Label("");
    @FXML private Label playerName3 = new Label("");
    @FXML private Label playerName4 = new Label("");

    @FXML private Label budgetPlayer1 = new Label("");
    @FXML private Label budgetPlayer2 = new Label("");
    @FXML private Label budgetPlayer3 = new Label("");
    @FXML private Label budgetPlayer4 = new Label("");

    @FXML private Button menuButton;
    @FXML private Button newGame;

    Baccarat baccarat = BaccaratDataManager.getInstance().getBaccarat();
    RulesOfBaccarat rules = new RulesOfBaccarat();

    public void menuPushed(ActionEvent event) throws IOException {
        Parent baccaratScene = FXMLLoader.load(getClass().getResource("../Menu.fxml"));
        Scene menuScene = new Scene(baccaratScene);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    public void newGamePushed(ActionEvent event) throws IOException {
        // Chuyển lại cảnh chơi game
        Parent baccaratScene = FXMLLoader.load(getClass().getResource("BaccaratGame.fxml"));
        Scene menuScene = new Scene(baccaratScene);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();

        // Chia bài mới
        baccarat.dealCard();

        // Xác định người thắng
        PlayerBaccarat winner = rules.winnerBaccarat(); // Giả sử hàm này trả về Player thắng

        // Trừ tiền người thua, cộng tiền người thắng
        for (PlayerBaccarat player : baccarat.getPlayersBaccarat()) {
            if (player.equals(winner)) {
                player.setMoneyPlayer(player.getMoneyPlayer() + player.getMoneyPlayer() * 2); // Cộng tiền thắng
            } else {
                player.setMoneyPlayer(player.getMoneyPlayer() - player.getMoneyPlayer()); // Trừ tiền cược
            }
        }

        // Cập nhật giao diện
        updateCards();
        updatePlayerInfo();
    }


    private void updateCards() {
        ArrayList<PlayerBaccarat> players = baccarat.getPlayersBaccarat();

        // Hiển thị bài của Player 1
        if (players.size() > 0) {
            displayCardsForPlayer(players.get(0), cardImageP1_1, cardImageP1_2, cardImageP1_3);
        }

        // Hiển thị bài của Player 2
        if (players.size() > 1) {
            displayCardsForPlayer(players.get(1), cardImageP2_1, cardImageP2_2, cardImageP2_3);
        }

        // Hiển thị bài của Player 3
        if (players.size() > 2) {
            displayCardsForPlayer(players.get(2), cardImageP3_1, cardImageP3_2, cardImageP3_3);
        }

        // Hiển thị bài của Player 4
        if (players.size() > 3) {
            displayCardsForPlayer(players.get(3), cardImageP4_1, cardImageP4_2, cardImageP4_3);
        }
    }

    private void displayCardsForPlayer(PlayerBaccarat player, ImageView card1, ImageView card2, ImageView card3) {
        ArrayList<String> handCards = player.getHandCards();

        card1.setImage(null);
        card2.setImage(null);
        card3.setImage(null);

        card1.setImage(new Image(getClass().getResource("/cardsimage/" + handCards.get(0) + ".png").toExternalForm()));
        card2.setImage(new Image(getClass().getResource("/cardsimage/" + handCards.get(1) + ".png").toExternalForm()));
        card3.setImage(new Image(getClass().getResource("/cardsimage/" + handCards.get(2) + ".png").toExternalForm()));

    }

    private void updatePlayerInfo() {
        ArrayList<PlayerBaccarat> players = baccarat.getPlayersBaccarat();

        if (players.size() > 0) {
            playerName1.setText(players.get(0).getNameOfPlayer());
            budgetPlayer1.setText("Budget: " + players.get(0).getMoneyPlayer() + "$");
        }

        if (players.size() > 1) {
            playerName2.setText(players.get(1).getNameOfPlayer());
            budgetPlayer2.setText("Budget: " + players.get(1).getMoneyPlayer() + "$");
        }

        if (players.size() > 2) {
            playerName3.setText(players.get(2).getNameOfPlayer());
            budgetPlayer3.setText("Budget: " + players.get(2).getMoneyPlayer() + "$");
        }

        if (players.size() > 3) {
            playerName4.setText(players.get(3).getNameOfPlayer());
            budgetPlayer4.setText("Budget: " + players.get(3).getMoneyPlayer() + "$");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Cập nhật hình ảnh của bài lưng
        deckImage.setImage(new Image(getClass().getResource("/cardsimage/BACK.png").toExternalForm()));

        // Lấy danh sách người chơi từ Baccarat
        ArrayList<PlayerBaccarat> players = baccarat.getPlayersBaccarat();

        // Cập nhật thông tin cho từng người chơi, kiểm tra nếu có đủ người chơi
        if (baccarat.getNumberOfPlayer() > 0) {
            playerName1.setText(players.get(0).getNameOfPlayer());
            budgetPlayer1.setText("Budget: " + players.get(0).getMoneyPlayer() + "$");
        }

        if (baccarat.getNumberOfPlayer() > 1) {
            playerName2.setText(players.get(1).getNameOfPlayer());
            budgetPlayer2.setText("Budget: " + players.get(1).getMoneyPlayer() + "$");
        }

        if (baccarat.getNumberOfPlayer() > 2) {
            playerName3.setText(players.get(2).getNameOfPlayer());
            budgetPlayer3.setText("Budget: " + players.get(2).getMoneyPlayer() + "$");
        }

        if (baccarat.getNumberOfPlayer() > 3) {
            playerName4.setText(players.get(3).getNameOfPlayer());
            budgetPlayer4.setText("Budget: " + players.get(3).getMoneyPlayer() + "$");
        }
        updateCards();

    }

}
