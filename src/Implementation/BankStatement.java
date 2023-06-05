package Implementation;

import java.util.ArrayList;

public class BankStatement {

    private ArrayList<String>statementBody=new ArrayList<String>();
    public BankStatement(ArrayList<String>statementBody){
        this.statementBody=statementBody;
    }

    public String getOperationType() {
        return statementBody.get(0);
    }
    public String getAmount() {
        return statementBody.get(1);
    }
    public String getTime() {
        return statementBody.get(2);
    }


}
