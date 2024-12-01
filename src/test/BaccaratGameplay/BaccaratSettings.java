package test.BaccaratGameplay;

import gamecardbaccarat.Baccarat;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaccaratSettings implements Initializable {

    @FXML private TextField text1;
    @FXML private TextField text2;
    @FXML private Label label;
    @FXML private Button button;

    Baccarat baccarat = BaccaratDataManager.getInstance().getBaccarat();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(""); // Khởi tạo nhãn trống

        // Lắng nghe thay đổi trên cả hai TextField
        text1.textProperty().addListener((observable, oldValue, newValue) -> validateInput());
        text2.textProperty().addListener((observable, oldValue, newValue) -> validateInput());

        // Ràng buộc disable cho nút Continue
        button.disableProperty().bind(
                text1.textProperty().isEmpty() // Nếu text1 trống
                        .or(text2.textProperty().isEmpty()) // Hoặc text2 trống
                        .or(label.textProperty().isNotEmpty()) // Hoặc nhãn có lỗi
        );
    }

    private void validateInput() {
        String input1 = text1.getText().trim();
        String input2 = text2.getText().trim();

        // Kiểm tra text1
        if (input1.isEmpty() || input2.isEmpty()) {
            label.setText("*Please fill in all fields!*");
            return;
        }

        try {
            int a = Integer.parseInt(input1);
            int b = Integer.parseInt(input2);

            // Kiểm tra số lượng người chơi
            if (a < 2 || a > 4) {
                label.setText("*Invalid number of players! (2-4)*");
            }
            // Kiểm tra số tiền người chơi
            else if (b <= 0) {
                label.setText("*Invalid money! Must be > 0.*");
            } else {
                label.setText(""); // Dữ liệu hợp lệ
                baccarat.setNumberOfPlayer(a);
                baccarat.addPlayer(b); // Thêm người chơi vào game
            }
        } catch (NumberFormatException e) {
            label.setText("*Please enter valid numbers!*");
        }
    }

    // Chức năng quay lại menu
    public void backPushed(ActionEvent event) throws IOException {
        Parent baccaratScene = FXMLLoader.load(getClass().getResource("../Menu.fxml"));
        Scene menuScene = new Scene(baccaratScene);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    // Chức năng tiếp tục vào màn chơi
    public void continuePushed(ActionEvent event) throws IOException {
        // Kiểm tra nếu người chơi chưa được cấu hình đúng
        if (baccarat.getNumberOfPlayer() == 0 || baccarat.getPlayersBaccarat().get(1).getMoneyPlayer() == 0) {
            label.setText("*Please configure the game settings properly!*");
            return;
        }

        int a = Integer.parseInt(text1.getText().trim());
        int b = Integer.parseInt(text2.getText().trim());
        BaccaratDataManager.getInstance().getBaccarat().setNumberOfPlayer(a);
        BaccaratDataManager.getInstance().getBaccarat().addPlayer(b);

        // Tiến hành chuyển sang scene tiếp theo
        Parent baccaratScene = FXMLLoader.load(getClass().getResource("BaccaratGameDeal.fxml"));
        Scene menuScene = new Scene(baccaratScene);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }
}
