package GUI;
import Implementation.BankStatement;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class ShowStatementsController implements Initializable {
        @FXML
        private ListView<String> accountStatements;
    @FXML
    private ImageView backImg;
        @FXML
        private Button backBtn;
        SystemManager sys=SystemManager.singleINST();
    public void initialize(URL url, ResourceBundle rb){

        Map<String, ArrayList<BankStatement>> statements= sys.getStatements();
        ArrayList<BankStatement> transferStat=statements.get("transfer");
        ArrayList<BankStatement> buyItemStat=statements.get("BuyItem");
        ArrayList<BankStatement> payBillStat=statements.get("PayBill");
        ArrayList<String> transferArr=new ArrayList<String>();
        ArrayList<String> buyItemArr=new ArrayList<String>();
        ArrayList<String> payBillArr=new ArrayList<String>();
        if(transferStat != null){
            for(int i=0;i<transferStat.size();i++){
                transferArr.add("Type:"+transferStat.get(i).getOperationType()+" ,Amount:"+transferStat.get(i).getAmount()+" ,Time:"+transferStat.get(i).getTime());
            }
        }
        if(buyItemStat != null){
            for(int i=0;i<buyItemStat.size();i++){
                buyItemArr.add("Type:"+buyItemStat.get(i).getOperationType()+" ,Amount:"+buyItemStat.get(i).getAmount()+" ,Time:"+buyItemStat.get(i).getTime());
            }
        }
        if(payBillStat != null){
            for(int i=0;i<payBillStat.size();i++){
                payBillArr.add("Type:"+payBillStat.get(i).getOperationType()+" ,Amount:"+payBillStat.get(i).getAmount()+" ,Time:"+payBillStat.get(i).getTime());
            }
            System.out.println(payBillArr);
        }
        for (String s:transferArr
             ) {
            accountStatements.getItems().add(s);
        }
        for (String s:buyItemArr
        ) {
            accountStatements.getItems().add(s);
        }
        for (String s:payBillArr
        ) {
            accountStatements.getItems().add(s);
        }
//        accountStatements.getItems().add(FXCollections.observableArrayList(transferArr).toString());
//        accountStatements.getItems().add(FXCollections.observableArrayList(buyItemArr).toString());
//        accountStatements.getItems().add(FXCollections.observableArrayList(payBillArr).toString());

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
        void Back(ActionEvent event) throws IOException {
            Main m = new Main();
            m.changeScene("Home.fxml");
        }

}