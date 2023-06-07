package GUI;

import Implementation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SystemManager {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private static SystemManager single_instance=null;
    private boolean loginFlag=false;
    private static boolean initiatedFlag=false;
    private Account loggedInAccount;
    private ArrayList<item> itemsList=new ArrayList<item>();


    private Map<Account,ArrayList<PayBill>> availableBills = new HashMap<Account,ArrayList<PayBill>>();

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
        //initiate accounts
        accounts.add(new Account(5000,"12345"));
        accounts.add(new Account(7000,"12345"));
        accounts.add(new Account(1000,"12345"));
        //initiate items
        itemsList.add(new item(200,3));
        itemsList.add(new item(400,4));
        itemsList.add(new item(700.8,20));
        itemsList.add(new item(300,1));
        itemsList.add(new item(900,14));
        //initiate bills for each account
        //acc 1
        ArrayList<PayBill> aPB = new ArrayList<PayBill>();
        aPB.add(new PayBill(150,"gas"));
        aPB.add(new PayBill(2000,"electricity"));
        availableBills.put(accounts.get(0),aPB);
        aPB.clear();
        //acc 2
        aPB.add(new PayBill(450,"gas"));
        availableBills.put(accounts.get(1),aPB);
        aPB.clear();
        //acc3
        aPB.add(new PayBill(450,"gas"));
        aPB.add(new PayBill(450,"electricity"));
        aPB.add(new PayBill(450,"land line"));
        availableBills.put(accounts.get(2),aPB);
        aPB.clear();




    }

//🍎🍎🍎🍎🍎🍎🍎🍎🍎 login criteria number and password
   public boolean userLogin(String accountNum,String password){
        for(Account User : accounts){
            if((User.getPassword() .equals(password) )&& User.getAccountNo().equals(accountNum)){
                loggedInAccount=User;
                loginFlag=true;
                return loginFlag;
            }
        }
        return loginFlag;


    }




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
