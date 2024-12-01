package test;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import  javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController implements Initializable {

    @FXML private Button baccarat;
    @FXML private Button thirteens;

    public void baccaratPushed(ActionEvent event) throws IOException {
        Parent menuScene = FXMLLoader.load(getClass().getResource("BaccaratGameplay/BaccaratSettings.fxml"));
        Scene baccaratScene = new Scene(menuScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(baccaratScene);
        window.show();
    }

    public void thirteensPushed(){
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
