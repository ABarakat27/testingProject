package GUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
    private ImageView backImg;
        @FXML
        private Label buyItemStatus;
        SystemManager sys = SystemManager.singleINST();
        public void initialize(URL url, ResourceBundle rb){
                ArrayList<String> itemNames=sys.getItemsNames();
                ItemBox.setItems(FXCollections.observableArrayList(itemNames));
            backImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent)  {
                    Main m = new Main();
                    try {
                        m.changeScene("Home.fxml");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        @FXML
        void BuyItem(ActionEvent event) throws IOException {
            ArrayList<String> sList = sys.getNotifications();
            Object itemChosen = ItemBox.getSelectionModel().getSelectedItem();
            boolean buystate=false;
            System.out.println("here item"+itemChosen);
            if(itemChosen!=null){
                String numberOfItems=NumberOfItems.getText();
                int nItems=-1;
                try{
                    nItems=Integer.parseInt(numberOfItems);
                }
                catch(NumberFormatException nfe){
                    buyItemStatus.setText("Please enter a valid number of items");
                }
                buystate=sys.buyItem(itemChosen.toString(),nItems);
            }
            else{
                sys.failedNotification();
            }
            if (buystate) {
                buyItemStatus.setText("");
                Alert nott = new Alert(Alert.AlertType.INFORMATION);
                nott.setTitle("Notification");
                nott.setContentText(sList.get(sList.size() - 1));
                nott.setHeaderText("Buy Item Transaction");
                Optional<ButtonType> result = nott.showAndWait();
                if (result.isPresent() && (result.get() == ButtonType.OK || result.get() == ButtonType.CANCEL || result.get() == ButtonType.CLOSE)) {
                    Main m = new Main();
                    m.changeScene("Home.fxml");
                }
                System.out.println("done transfer new new");
            } else {
                Alert nott = new Alert(Alert.AlertType.INFORMATION);
                nott.setTitle("Notification");
                nott.setContentText(sList.get(sList.size() - 1));
                nott.setHeaderText("Buy Item Transaction");
                nott.showAndWait();
                buyItemStatus.setText("something is not right please check the entered data and try again ");
            }
        }

        @FXML
        void itemChoiceClick(ActionEvent event) {
                String itemSelected = ItemBox.getSelectionModel().getSelectedItem().toString();
                itemCostLabel.setText(String.valueOf(sys.getItemCost(itemSelected)));
        }
    @FXML
    void Back(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Home.fxml");
    }
}
