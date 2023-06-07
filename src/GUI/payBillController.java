package GUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class payBillController implements Initializable {

    @FXML
    private ComboBox availableBillsChoice;
    @FXML
    private Label billCostLabel;
    @FXML
    private Button payBillBtn;

    @FXML
    private Label payBillStatusLabel;
    SystemManager sys = SystemManager.singleINST();
    public void initialize(URL url, ResourceBundle rb){
        ArrayList<String> bills= sys.getAvailableBillsNames();
        System.out.println(bills);
        availableBillsChoice.setItems(FXCollections.observableArrayList(bills));
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

        String selectedBillName=availableBillsChoice.getValue().toString();
        boolean payBillState=sys.payBill(selectedBillName);
        if(payBillState){

            Main m = new Main();
            m.changeScene("Home.fxml");
        }
        else{
            payBillStatusLabel.setText("Something went wrong, Please try again.");
        }
    }

}
