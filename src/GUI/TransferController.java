package GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class TransferController {


    @FXML
    private TextField accNoText;

    @FXML
    private TextField amountText;

    @FXML
    private Label errorLabel;
    SystemManager sys =SystemManager.singleINST();
    @FXML
    void transferFunc(ActionEvent event) throws IOException {
        ArrayList<String>sList =sys.getNotifications();
        System.out.println(sList.size());
     boolean done=  sys.Transfer(accNoText.getText(),Double.parseDouble(amountText.getText()));
        System.out.println(sList.size());
      //  boolean done= true;
      if(done){
          Alert nott=new Alert(Alert.AlertType.INFORMATION);
          nott.setTitle("Notification");
          nott.setContentText(sList.get(sList.size()-1));
          nott.setHeaderText("Transfer Transaction");
          Optional<ButtonType>result=nott.showAndWait();
          if(result.isPresent()&&(result.get()==ButtonType.OK||result.get()==ButtonType.CANCEL||result.get()==ButtonType.CLOSE)){
              Main m = new Main();
              m.changeScene("Home.fxml");
          }
          System.out.println("done transfer new new");
      }else{
          Alert nott=new Alert(Alert.AlertType.INFORMATION);
          nott.setTitle("Notification");
          nott.setContentText(sList.get(sList.size()-1));
          nott.setHeaderText("Transfer Transaction");
          nott.showAndWait();

          System.out.println("failed to do it");
      }

    }
}
