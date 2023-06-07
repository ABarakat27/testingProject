package GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.util.ArrayList;

public class TransferController {
    @FXML
    private Notifications notifications ;

    @FXML
    private TextField accNoText;

    @FXML
    private TextField amountText;

    @FXML
    private Label errorLabel;
    SystemManager sys =SystemManager.singleINST();
    @FXML
    void transferFunc(ActionEvent event) throws IOException {

      boolean done=  sys.Transfer(accNoText.getText(),Double.parseDouble(amountText.getText()));
      if(done){
          ArrayList<String>list=sys.getStatements();
          System.out.println(list.size()-1);
          System.out.println(list.get(list.size()-1));
          notifications.create()
                  .text(list.get(list.size()-1))
                  .title("Transaction Notification")
                  .hideAfter(Duration.seconds(10))
                  .position(Pos.TOP_RIGHT);
          notifications.darkStyle();
          notifications.show();
          Main m = new Main();
          m.changeScene("Home.fxml");
      }else{

      }

    }
}
