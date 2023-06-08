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
        itemsList.add(new item(200,3,"shoes"));
        itemsList.add(new item(400,4,"samsung flip flop"));
        itemsList.add(new item(700.8,20,"apple tok tok"));
        itemsList.add(new item(300,1,"phone case"));
        itemsList.add(new item(900,14,"toy car"));
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
                if(Receiver.getAccountNo()==loggedInAccount.getAccountNo()){
                    loggedInAccount.setFailedNotification();
                    return false;
                }
                try {
                    loggedInAccount.transfer(amount, Receiver);
                    //System.out.println("this is the transfer size"+loggedInAccount.getNotifications().size());
                    return true;
                }
                catch (InsufficientBalanceException e){
                    return  false;
                }
            }


            }
            loggedInAccount.setFailedNotification();
            return  false;

    }






    public double getAccountBalance(){
        return loggedInAccount.getBalance();
    }
    /*
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

        public ArrayList<String> getNotifications(){
          //  System.out.println("this is the size"+loggedInAccount.getNotifications().size());
        return loggedInAccount.getNotifications();

    }
    public Map<String, ArrayList<BankStatement>> getStatements(){
        return loggedInAccount.getStatements();
    }
    public ArrayList<String> getItemsNames(){
        ArrayList<String> itemNames= new ArrayList<String>();
        for (item i:itemsList
             ) {
            itemNames.add(i.getItemName());
        }
        return itemNames;
    }
    public double getItemCost(String itemName){
        for (item i:itemsList
             ) {
            if(i.getItemName()==itemName){
                return i.getPrice();
            }
        }
        return -1;
    }
    public boolean buyItem(String itemName,int noItems) {
        try {
            item chosenItem = null;
            for (item i : itemsList
            ) {
                if (i.getItemName() == itemName) {
                    chosenItem = i;
                }
            }
            if (chosenItem != null) {
                loggedInAccount.BuyItem(chosenItem, noItems);
                return true;
            }
            else{
                return false;
            }
        }
        catch(InsufficientBalanceException |  Implementation.noOfItemsException e){
            return false;
        }

    }
}
