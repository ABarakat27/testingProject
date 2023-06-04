package testFiles;

import Implementation.*;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

public class NotifyUserTest {

    static Account a ;
    static Account b ;
    static  item i;
    static  PayBill pb;
    static  PayBill g;
    @BeforeClass
    public static void start()  {

     a = new Account(5000);
     b = new Account(5000);
     i = new item(15, 3);
     pb = new PayBill(15, "Gas");
     g = new PayBill(15000, "shawrma");


        System.out.println("start testing");
    }
    @org.junit.Test
    public void showNotificationsAfterTransfer()  {
        try {

            a.transfer(100, b);
            assertEquals("A successful transaction has been made",a.getNotifications().get(2) );
        }catch (InsufficientBalanceException e){
            assertEquals("A failed transaction has been made", a.getNotifications().get(2));
        }

    }
    @org.junit.Test
    public void showNotificationsAfterBuyingItem()  {

        try {

            a.BuyItem(i, 2);
            assertEquals("A successful transaction has been made",a.getNotifications().get(4) );
        }catch (noOfItemsException|InsufficientBalanceException e){
            assertEquals("A failed transaction has been made", a.getNotifications().get(4));
        }
    }

    @org.junit.Test
    public void showNotificationsPayBill()  {
    try{

        a.payBill(pb);
        assertEquals("A successful transaction has been made",a.getNotifications().get(3) );
    }catch(InsufficientBalanceException |PaidException e) {
        assertEquals("A failed transaction has been made", a.getNotifications().get(3));
    }
    }
    @org.junit.Test
    public void showNotificationsPayBillFailedIsPaid()  {
        try{
            a.payBill(pb);

        }catch(InsufficientBalanceException |PaidException e) {
            assertEquals("A failed transaction has been made", a.getNotifications().get(1));
        }
    }
    @org.junit.Test
    public void showNotificationsPayBillFailedBalance()  {
        try{
            a.payBill(g);

        }catch(InsufficientBalanceException |PaidException e) {
            assertEquals("A failed transaction has been made", a.getNotifications().get(0));
        }
    }


}
