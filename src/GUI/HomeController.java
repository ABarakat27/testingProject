package GUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
        @FXML
        private Label accountBalanceLabel;

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
        SystemManager sys=SystemManager.singleINST();
        public void initialize(URL url, ResourceBundle rb){
                accountNumberLabel.setText(sys.getAccountNumber());
                accountBalanceLabel.setText(String.valueOf(sys.getAccountBalance()));
        }
        @FXML
        void gotoBuyItem(ActionEvent event) throws IOException {
                Main m = new Main();
                m.changeScene("BuyItem.fxml");
        }

        @FXML
        void gotoPayBill(ActionEvent event) throws IOException {
                Main m = new Main();
                m.changeScene("PayBill.fxml");
        }

        @FXML
        void gotoShowStatements(ActionEvent event) throws IOException {
                Main m = new Main();
                m.changeScene("ShowStatements.fxml");
        }

        @FXML
        void gotoTransfer(ActionEvent event) throws IOException {
                Main m = new Main();
                m.changeScene("Transfer.fxml");
        }



}
