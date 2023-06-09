package Implementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {
    private static int counter =0;
    private String accountNo;
    private String password;
    private double Balance;
    private ArrayList<BankStatement> transferStatements = new ArrayList<BankStatement>();
    private ArrayList<BankStatement> buyItemsStatements = new ArrayList<BankStatement>();
    private ArrayList<BankStatement> payBillsStatements = new ArrayList<BankStatement>();
    private ArrayList<String> notifications = new ArrayList<String>();
    private Map<String, ArrayList<BankStatement>> statements = new HashMap<String, ArrayList<BankStatement>>();

    public Account(double amount) {
        Balance = amount;
        accountNo="29910"+String.valueOf(counter);
        counter++;



    }
   public Account(double amount,String password){
       Balance = amount;
       accountNo="29910"+String.valueOf(counter);
       counter++;
       this.password=password;

   }

    public String getPassword() {
        return password;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double amount) {
        Balance = amount;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }

    public Map<String, ArrayList<BankStatement>> getStatements() {
        return statements;
    }

    private BankStatement intiateAStatement(String operation, double amount) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ArrayList<String> sb = new ArrayList<String>();
        sb.add(operation);
        sb.add(String.valueOf(amount));
        sb.add(dtf.format(now));
        BankStatement s = new BankStatement(sb);
        return s;
    }

    private String notifyUser(boolean succes) {
        if(succes)
            return "A successful transaction has been made";
        else
            return "A failed transaction has been made";
    }


    public void transfer(double amount, Account x) throws InsufficientBalanceException {
        if (Balance >= amount&& amount>0) {
            x.setBalance(x.getBalance() + amount);
            Balance -= amount;
            transferStatements.add(intiateAStatement("transfer", amount));
            statements.put("transfer", transferStatements);
            notifications.add(notifyUser(true));

        } else {
            notifications.add(notifyUser(false));
            throw new InsufficientBalanceException();
        }

    }

    public void BuyItem(item x, int noOfItems) throws InsufficientBalanceException,noOfItemsException {

            if (noOfItems * x.getPrice() <= Balance && x.getNoOfItems() >= noOfItems && noOfItems>0) {
                Balance -= (noOfItems * x.getPrice());
                x.setNoOfItems(x.getNoOfItems() - noOfItems);

                buyItemsStatements.add(intiateAStatement("BuyItem", noOfItems * x.getPrice()));
                statements.put("BuyItem", buyItemsStatements);
                notifications.add(notifyUser(true));
            } else if (x.getNoOfItems() < noOfItems) {
                notifications.add(notifyUser(false));
                throw new noOfItemsException();
            }


            else {
                notifications.add(notifyUser(false));
                throw new InsufficientBalanceException();
            }





    }
    public void payBill(PayBill pb) throws InsufficientBalanceException , PaidException {
        if(pb.getCost()<=Balance && !pb.isPaid()){
            Balance-=pb.getCost();
            pb.setPaid(true);
            payBillsStatements.add(intiateAStatement("PayBill", pb.getCost()));
            statements.put("PayBill", payBillsStatements);
            notifications.add(notifyUser(true));
        }
        else if(pb.isPaid()){
            notifications.add(notifyUser(false));
            throw new PaidException();
        }
        else {
            notifications.add(notifyUser(false));
            throw new InsufficientBalanceException();
        }

    }

    public void setFailedNotification(){
        notifications.add(notifyUser(false));
    }
}