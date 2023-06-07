package GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
public class BuyItemController {
        @FXML
        private ComboBox<String> ItemBox;

        @FXML
        private PasswordField NumberOfItems;

        @FXML
        private Button buyBtn;

        @FXML
        private Label buyItemStatus;
        SystemManager sys = SystemManager.singleINST();

        @FXML
        void BuyItem(ActionEvent event) {
            String itemChosen = ItemBox.getSelectionModel().getSelectedItem().toString();
//            sys.
        }

        @FXML
        void itemChoiceClick(ActionEvent event) {
        }

}
