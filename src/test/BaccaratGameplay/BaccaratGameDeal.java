package test.BaccaratGameplay;

import gamecardbaccarat.Baccarat;
import gamecardbaccarat.RulesOfBaccarat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BaccaratGameDeal implements Initializable {

    @FXML private ImageView deckImage;
    @FXML private Button dealButton;
    Baccarat baccarat = BaccaratDataManager.getInstance().getBaccarat();
    RulesOfBaccarat rules = new RulesOfBaccarat();

    public void dealPushed(ActionEvent event) throws IOException {
        baccarat.dealCard();
        rules.winnerBaccarat();

        Parent baccaratScene = FXMLLoader.load(getClass().getResource("BaccaratGame.fxml"));
        Scene menuScene = new Scene(baccaratScene);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deckImage.setImage(new Image(getClass().getResource("/cardsimage/BACK.png").toExternalForm()));

    }
}
