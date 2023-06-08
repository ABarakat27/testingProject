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
    private  Account Receiver;
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
//        aPB.clear();
        //acc 2
        ArrayList<PayBill> aPB2 = new ArrayList<PayBill>();
        aPB2.add(new PayBill(450,"gas"));
        availableBills.put(accounts.get(1),aPB2);
//        aPB.clear();
        //acc3
        ArrayList<PayBill> aPB3 = new ArrayList<PayBill>();
        aPB3.add(new PayBill(450,"gas"));
        aPB3.add(new PayBill(450,"electricity"));
        aPB3.add(new PayBill(450,"land line"));
        availableBills.put(accounts.get(2),aPB3);
//        aPB.clear();




    }


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

    public Boolean Transfer(String accountNum ,double amount)  {
        for(Account User : accounts){
            if(User.getAccountNo().equals(accountNum)){
                Receiver=User;
                try {
                    loggedInAccount.transfer(amount, Receiver);
                }
                catch (InsufficientBalanceException e){
                    return  false;
                }
            }
                return true;

            }

            return  false;

    }




/*

    public double getAccountBalance(){
        return loggedInAccount.getBalance();
    }
    public Map<String, ArrayList<BankStatement>> getAccountStatements(){
        return loggedInAccount.getStatements();
    }
    //account number🍎🍎🍎🍎🍎🍎🍎
    
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
*/
    public ArrayList<String> getAvailableBillsNames(){
        if(!loginFlag){
            System.out.println("here null");
            return null;
        }
        ArrayList<String> billNames=new ArrayList<String>();
        ArrayList<PayBill> bills = availableBills.get(loggedInAccount);
        System.out.println(bills);
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
    public Map<String, ArrayList<BankStatement>> getStatements(){
         return loggedInAccount.getStatements();
    }
//    public boolean buyItem(String itemName,int n){
//        item myItem=null;
//        for (item i:itemsList
//             ) {
//            if(i.)
//        }{
//
//        }
//        loggedInAccount.BuyItem();
//    }
}
