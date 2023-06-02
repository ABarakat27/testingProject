package Implementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {
    private double Balance;
    ArrayList<BankStatement>transferStatements=new ArrayList<BankStatement>();
    ArrayList<BankStatement>buyItemsStatements=new ArrayList<BankStatement>();
    ArrayList<BankStatement>payBillsStatements=new ArrayList<BankStatement>();
    Map<String,ArrayList<BankStatement>> statements= new HashMap<String,ArrayList<BankStatement>>();
    public Account(double amount){
        Balance=amount;

    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double amount) {
        Balance= amount;
    }



    private BankStatement intiateAStatement(String operation,double amount){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ArrayList<String>sb=new ArrayList<String>();
        sb.add(operation);
        sb.add(String.valueOf(amount));
        sb.add(dtf.format(now));
        BankStatement s=new BankStatement(sb);
        return  s ;
    }



    public void transfer(double amount,Account x) throws InsufficientBalanceException {
        if(Balance>amount) {
            x.setBalance(x.getBalance() + amount);
            Balance -= amount;
           transferStatements.add(intiateAStatement("transfer",amount));
           statements.put("transfer",transferStatements);

        }
        else
            throw new InsufficientBalanceException();

    }
    public void  BuyItem(item x,int noOfItems) throws InsufficientBalanceException {

        if(noOfItems * x.getPrice()<=Balance && x.getNoOfItems()>=noOfItems) {
            Balance -= (noOfItems * x.getPrice());
            x.setNoOfItems(x.getNoOfItems()-noOfItems);

            buyItemsStatements.add(intiateAStatement("BuyItem",noOfItems * x.getPrice()));
            statements.put("BuyItem",buyItemsStatements);
        }
            else
            throw new InsufficientBalanceException();


    }
}