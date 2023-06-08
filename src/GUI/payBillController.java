package GUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class payBillController implements Initializable {

    @FXML
    private ComboBox availableBillsChoice;
    @FXML
    private Label billCostLabel;
    @FXML
    private Button payBillBtn;
    @FXML
    private ImageView backImg;
    @FXML
    private Label payBillStatusLabel;
    SystemManager sys = SystemManager.singleINST();
    public void initialize(URL url, ResourceBundle rb){
        ArrayList<String> bills= sys.getAvailableBillsNames();
        availableBillsChoice.setItems(FXCollections.observableArrayList(bills));
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
    void choiceClick(ActionEvent event) throws IOException {
        String billChosen = availableBillsChoice.getSelectionModel().getSelectedItem().toString();
        billCostLabel.setText(String.valueOf(sys.getBillCost(billChosen))+" EGP");
    }
//    @FXML
//    void availableBillsChoice.setOnAction((event) -> {
//        int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
//        Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();
//
//        System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
//        System.out.println("   ChoiceBox.getValue(): " + choiceBox.getValue());
//    });
    @FXML
    void payBill(ActionEvent event) throws IOException {
        ArrayList<String> sList = sys.getNotifications();
        Object selectedBillName=availableBillsChoice.getValue();
        boolean payBillState=false;
        if(selectedBillName!=null){
            payBillState=sys.payBill(selectedBillName.toString());
        }
        else{
            sys.failedNotification();
        }
        if (payBillState) {
            payBillStatusLabel.setText("");
            Alert nott = new Alert(Alert.AlertType.INFORMATION);
            nott.setTitle("Notification");
            nott.setContentText(sList.get(sList.size() - 1));
            nott.setHeaderText("Pay Bill Transaction");
            Optional<ButtonType> result = nott.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK || result.get() == ButtonType.CANCEL || result.get() == ButtonType.CLOSE)) {
                Main m = new Main();
                m.changeScene("Home.fxml");
            }
        } else {
            Alert nott = new Alert(Alert.AlertType.INFORMATION);
            nott.setTitle("Notification");
            nott.setContentText(sList.get(sList.size() - 1));
            nott.setHeaderText("Pay Bill Transaction");
            nott.showAndWait();

            payBillStatusLabel.setText("something is not right please check the entered data and try again ");
        }

    }
    @FXML
    void Back(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Home.fxml");
    }

}
