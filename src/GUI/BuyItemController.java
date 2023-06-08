package GUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BuyItemController implements Initializable {
        @FXML
        private ComboBox<String> ItemBox;

        @FXML
        private TextField NumberOfItems;
        @FXML
        private Label itemCostLabel;
        @FXML
        private Button buyBtn;

        @FXML
        private Label buyItemStatus;
        SystemManager sys = SystemManager.singleINST();
        public void initialize(URL url, ResourceBundle rb){
                ArrayList<String> itemNames=sys.getItemsNames();
                ItemBox.setItems(FXCollections.observableArrayList(itemNames));
        }
        @FXML
        void BuyItem(ActionEvent event) throws IOException {
            String itemChosen = ItemBox.getSelectionModel().getSelectedItem().toString();
            String numberOfItems=NumberOfItems.getText();
            int nItems=-1;
            try{
                    nItems=Integer.parseInt(numberOfItems);
            }
            catch(NumberFormatException nfe){
                buyItemStatus.setText("Please enter a valid number of items");
                return;
            }
            boolean buystate=sys.buyItem(itemChosen,nItems);
            if(buystate){
                    Main m = new Main();
                    m.changeScene("Home.fxml");
            }
            else{
                    buyItemStatus.setText("Something went wrong, please try again!");
            }
        }

        @FXML
        void itemChoiceClick(ActionEvent event) {
                String itemSelected = ItemBox.getSelectionModel().getSelectedItem().toString();
                itemCostLabel.setText(String.valueOf(sys.getItemCost(itemSelected)));
        }

}
