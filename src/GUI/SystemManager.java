package GUI;

import Implementation.Account;

import java.util.ArrayList;

public class SystemManager {
    private ArrayList<Account> accounts = new ArrayList<>();
    private static SystemManager single_instance=null;
    private boolean loginFlag=false;
    private static boolean initiatedFlag=false;
    private Account loggedInAccount;

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
/*
    public double getAccountBalance(){
        return loggedInAccount.getBalance();
    }
    public Map<String, ArrayList<BankStatement>> getAccountStatements(){
        return loggedInAccount.getStatements();
    }
    //account number🍎🍎🍎🍎🍎🍎🍎
    public boolean transfer(double amount,string toAccountNum){
        try{
            loggedInAccount.transfer(amount,toAccountNum);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
    //itemId or itemName 🍎🍎🍎🍎🍎🍎
    public boolean buyItem(string itemName ,int numofitems){
        try{
            loggedInAccount.BuyItem(String itemName,numofitems);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    //bill name 🍎🍎🍎🍎
    public boolean payBill(string billName){
        try{
            loggedInAccount.payBill(billName);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    */
}
