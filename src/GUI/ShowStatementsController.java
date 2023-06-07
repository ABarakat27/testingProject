package GUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowStatementsController implements Initializable {



        @FXML
        private ListView<?> accountStatements;

        @FXML
        private Button backBtn;
        SystemManager sys=SystemManager.singleINST();
    public void initialize(URL url, ResourceBundle rb){
       // ArrayList<String> statements= sys.g();
    }
        @FXML
        void Back(ActionEvent event) {

        }

}