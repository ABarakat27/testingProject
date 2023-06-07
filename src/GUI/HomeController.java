package GUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController {

        @FXML
        private Label accountNumberLabel;

        @FXML
        private Button buyItemBtn;

        @FXML
        private Button payBillBtn;

        @FXML
        private Button showStatementBtn;

        @FXML
        private Button transferBtn;
        public void initialize(URL url, ResourceBundle rb){

        }
        @FXML
        void gotoBuyItem(ActionEvent event) {

        }

        @FXML
        void gotoPayBill(ActionEvent event) throws IOException {
                Main m = new Main();
                m.changeScene("PayBill.fxml");
        }

        @FXML
        void gotoShowStatements(ActionEvent event) {

        }

        @FXML
        void gotoTransfer(ActionEvent event) {

        }



}
