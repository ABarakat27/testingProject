package GUI;

import Implementation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SystemManager {
    private ArrayList<Account> accounts = new ArrayList<>();
    private static SystemManager single_instance=null;
    private boolean loginFlag=false;
    private static boolean initiatedFlag=false;
    private Account loggedInAccount=null;
    private Map<Account,ArrayList<PayBill>> availableBills = new HashMap<Account,ArrayList<PayBill>>();
    private ArrayList<item> itemsList=new ArrayList<>();

    public static SystemManager singleINST(){
        if(single_instance == null){
            single_instance = new SystemManager();
        }
        if(!initiatedFlag){
            single_instance.initiateData();
            initiatedFlag=true;
        }
        return single_instance;
    }

    private void initiateData(){

    }
//🍎🍎🍎🍎🍎🍎🍎🍎🍎 login criteria number and password
//    public boolean userLogin(string accountNum,string password){
//
//    }

    public double getAccountBalance(){
        return loggedInAccount.getBalance();
    }
    public Map<String, ArrayList<BankStatement>> getAccountStatements(){
        return loggedInAccount.getStatements();
    }
    //account number🍎🍎🍎🍎🍎🍎🍎
    public boolean transfer(double amount,String toAccountNum){
        try{
            loggedInAccount.transfer(amount,toAccountNum);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
    //itemId or itemName 🍎🍎🍎🍎🍎🍎
    public boolean buyItem(String itemName ,int numofitems){
        try{
//            loggedInAccount.BuyItem(String itemName,numofitems);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    //bill name 🍎🍎🍎🍎

    public ArrayList<String> getAvailableBillsNames(){
        if(!loginFlag){
            return null;
        }
        ArrayList<String> billNames=new ArrayList<>();
        ArrayList<PayBill> bills = availableBills.get(loggedInAccount);
        for(int i=0;i<bills.size();i++){
            PayBill bill=bills.get(i);
            billNames.add(bill.getName());
        }
        return billNames;
    }
    public double getBillCost(String billName){
        double billCost=-1;
        ArrayList<PayBill> bills = availableBills.get(loggedInAccount);
        for(int i=0;i<bills.size();i++){
            PayBill bill=bills.get(i);
            if(billName==bill.getName()){
                billCost=bill.getCost();
            }
        }
        return billCost;
    }
    public boolean payBill(String billName){
        try{
            ArrayList<PayBill> bills = availableBills.get(loggedInAccount);
            PayBill bill=null;
            for(int i=0;i<bills.size();i++){
                String actualBillName=bills.get(i).getName().split()
                if(billName==bills.get(i).getName()) {
                    bill = bills.get(i);
                }
            }
            if(bill!=null){
                loggedInAccount.payBill(bill);
                return true;
            }
            else{
                return false;
            }

        }
        catch(InsufficientBalanceException | PaidException e){
            return false;
        }
    }

}
