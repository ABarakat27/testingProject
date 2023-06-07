package GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class loginController {

    @FXML
    private Button Loginbtn;

    @FXML
    private TextField accountNumberField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLogin;

    SystemManager sys = SystemManager.singleINST();
    @FXML
    void userLogin(ActionEvent event) throws IOException {
        boolean state=sys.userLogin(accountNumberField.getText(),passwordField.getText());
        if(state){
            Main m = new Main();
            m.changeScene("Home.fxml");
        }
        else{
            statusLogin.setText("Account number or password is incorrect!");
        }
    }

}
