package GUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class TransferController implements Initializable {

    @FXML
    private Label balanceLabel;

    @FXML
    private TextField accNoText;

    @FXML
    private TextField amountText;

    @FXML
    private Label errorLabel;
    SystemManager sys =SystemManager.singleINST();
    @FXML
    void transferFunc(ActionEvent event) throws IOException {
        ArrayList<String> sList = sys.getNotifications();
        System.out.println(sList.size());
        double d = -1;
        try {
            d = Double.parseDouble(amountText.getText());
        } catch (NumberFormatException nfe) {
            errorLabel.setText("something is not right please check the entered data and try again ");
        }

        boolean done = sys.Transfer(accNoText.getText(), d);
        System.out.println(sList.size());

        if (done) {
            errorLabel.setText("");
            Alert nott = new Alert(Alert.AlertType.INFORMATION);
            nott.setTitle("Notification");
            nott.setContentText(sList.get(sList.size() - 1));
            nott.setHeaderText("Transfer Transaction");
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
            nott.setHeaderText("Transfer Transaction");
            nott.showAndWait();

         errorLabel.setText("something is not right please check the entered data and try again ");
        }

    }
    public void initialize(URL url, ResourceBundle rb){

        balanceLabel.setText(String.valueOf(sys.getAccountBalance()));
    }
}
